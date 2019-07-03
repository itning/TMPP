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
import top.sl.tmpp.common.entity.AdminResource;
import top.sl.tmpp.common.entity.AdminUser;
import top.sl.tmpp.common.entity.LoginUser;
import top.sl.tmpp.common.mapper.CasMapper;
import top.sl.tmpp.security.exception.RoleException;
import top.sl.tmpp.security.util.JwtUtils;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    public Object resolveArgument(@Nonnull MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        String authorization = webRequest.getHeader(HttpHeaders.AUTHORIZATION);
        LoginUser loginUser = JwtUtils.getLoginUser(authorization);
        logger.debug("get login user: {}", loginUser);
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        String requestUri = request.getRequestURI();
        String method = request.getMethod();
        checkPermission(loginUser, requestUri, method.toUpperCase());
        return loginUser;
    }

    /**
     * 检查权限
     *
     * @param loginUser  登录用户
     * @param requestUri 请求URI
     * @param method     请求方法
     */
    private void checkPermission(LoginUser loginUser, String requestUri, String method) {
        String loginId = loginUser.getId();
        AdminUser adminUser = casMapper.selectByUserName(loginId);
        if (adminUser == null) {
            //普通教师角色
            long teacherCount = casMapper.getResourcesByUserTypeIsTeacher()
                    .stream()
                    .filter(adminResource -> requestUri.startsWith(adminResource.getUrl()))
                    .filter(adminResource -> adminResource.getMethod().equals(method))
                    .count();
            if (teacherCount == 0L) {
                logger.debug("CheckPermission FORBIDDEN {}", loginUser);
                logger.debug("request uri {}", requestUri);
                throw new RoleException("FORBIDDEN", HttpStatus.FORBIDDEN);
            }
            return;
        }
        List<AdminResource> adminResourceList = casMapper.getResourcesByUserName(loginId);
        long admin = adminResourceList
                .stream()
                .filter(adminResource -> requestUri.startsWith(adminResource.getUrl()))
                .filter(adminResource -> adminResource.getMethod().equals(method))
                .count();
        if (admin == 0L) {
            logger.debug("CheckPermission FORBIDDEN {}", loginUser);
            logger.debug("request uri {}", requestUri);
            throw new RoleException("FORBIDDEN", HttpStatus.FORBIDDEN);
        }
    }
}
