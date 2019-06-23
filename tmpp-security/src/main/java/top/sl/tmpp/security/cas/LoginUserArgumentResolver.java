package top.sl.tmpp.security.cas;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import top.sl.tmpp.common.entity.AdminResource;
import top.sl.tmpp.common.entity.LoginUser;
import top.sl.tmpp.common.mapper.CasMapper;
import top.sl.tmpp.security.exception.RoleException;
import top.sl.tmpp.security.util.JwtUtils;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author itning
 * @date 2019/6/17 8:43
 */
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
    private static final Logger logger = LoggerFactory.getLogger(LoginUserArgumentResolver.class);

    private static final String STUDENT_USER = "99";
    private final LoadingCache<String, List<AdminResource>> loadingCache;

    public LoginUserArgumentResolver(CasMapper casMapper) {
        loadingCache = CacheBuilder.newBuilder()
                //软引用
                .softValues()
                .maximumSize(1000)
                .build(new CacheLoader<String, List<AdminResource>>() {
                    @Override
                    @ParametersAreNonnullByDefault
                    public List<AdminResource> load(String key) {
                        return casMapper.getResourcesByUserName(key);
                    }
                });
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(LoginUser.class);
    }

    @Override
    public Object resolveArgument(@Nonnull MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String authorization = webRequest.getHeader(HttpHeaders.AUTHORIZATION);
        LoginUser loginUser = JwtUtils.getLoginUser(authorization);
        logger.debug("get login user: {}", loginUser);
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        String requestUri = request.getRequestURI();
        String method = request.getMethod();
        checkRole(loginUser);
        checkPermission(loginUser, requestUri, method.toUpperCase());
        return loginUser;
    }

    /**
     * 检查角色
     * 根据{@link LoginUser#getId()}检查admin_user表中角色(type)，没有的话检查是否是学生，是学生禁止
     *
     * @param loginUser 登录用户
     */
    private void checkRole(LoginUser loginUser) {
        /*if (loginUser.getUserType().equals(STUDENT_USER)) {
            logger.debug("CheckRole FORBIDDEN And LoginUser Type:{}", loginUser.getUserType());
            throw new RoleException("FORBIDDEN", HttpStatus.FORBIDDEN);
        }*/
    }

    /**
     * 检查权限
     *
     * @param loginUser  登录用户
     * @param requestUri 请求URI
     * @param method     请求方法
     */
    private void checkPermission(LoginUser loginUser, String requestUri, String method) throws ExecutionException {
        String loginId = loginUser.getId();
        List<AdminResource> adminResourceList = loadingCache.get(loginId);
        long admin = adminResourceList
                .stream()
                .filter(adminResource -> adminResource.getUrl().equals(requestUri))
                .filter(adminResource -> adminResource.getMethod().equals(method))
                .count();
        if (admin == 0L) {
            logger.debug("CheckPermission FORBIDDEN {}", loginUser);
            throw new RoleException("FORBIDDEN", HttpStatus.FORBIDDEN);
        }
    }
}
