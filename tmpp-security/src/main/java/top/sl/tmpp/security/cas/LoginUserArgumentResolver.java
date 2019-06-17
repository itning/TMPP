package top.sl.tmpp.security.cas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import top.sl.tmpp.common.entity.LoginUser;
import top.sl.tmpp.common.mapper.CasMapper;
import top.sl.tmpp.security.exception.RoleException;
import top.sl.tmpp.security.util.JwtUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author itning
 * @date 2019/6/17 8:43
 */
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
    private static final Logger logger = LoggerFactory.getLogger(LoginUserArgumentResolver.class);
    private final CasMapper casMapper;

    public LoginUserArgumentResolver(CasMapper casMapper) {
        this.casMapper = casMapper;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        String authorization = webRequest.getHeader(HttpHeaders.AUTHORIZATION);
        LoginUser loginUser = JwtUtils.getLoginUser(authorization);
        logger.info("get login user: {}", loginUser);
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
        if (loginUser.getUserType().equals(LoginUser.STUDENT_USER)) {
            throw new RoleException("FORBIDDEN", HttpStatus.FORBIDDEN);
        }
    }

    /**
     * 检查权限
     *
     * @param loginUser  登录用户
     * @param requestUri 请求URI
     * @param method     请求方法
     */
    private void checkPermission(LoginUser loginUser, String requestUri, String method) {
        //TODO 缓存
        String loginId = loginUser.getId();
        long admin = casMapper.getResourcesByUserName(loginId)
                .stream()
                .filter(adminResource -> adminResource.getUrl().equals(requestUri))
                .filter(adminResource -> adminResource.getMethod().equals(method))
                .count();
        if (admin == 0L) {
            throw new RoleException("FORBIDDEN", HttpStatus.FORBIDDEN);
        }
    }
}
