package top.sl.tmpp.security.cas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import top.itning.cas.callback.login.ILoginFailureCallBack;
import top.itning.cas.callback.login.ILoginNeverCallBack;
import top.itning.cas.callback.login.ILoginSuccessCallBack;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Jwt实现
 *
 * @author itning
 */
@Component
public class JwtCasCallBackImpl implements ILoginSuccessCallBack, ILoginFailureCallBack, ILoginNeverCallBack {
    private static final Logger logger = LoggerFactory.getLogger(JwtCasCallBackImpl.class);
    private static final String LOGIN_NAME = "loginName";
    private static final String STUDENT_USER_TYPE = "99";

    @Override
    public void onLoginSuccess(HttpServletResponse resp, HttpServletRequest req, Map<String, String> attributesMap) throws IOException, ServletException {

    }

    @Override
    public void onLoginFailure(HttpServletResponse resp, HttpServletRequest req, Exception e) throws IOException, ServletException {

    }

    @Override
    public void onNeverLogin(HttpServletResponse resp, HttpServletRequest req) throws IOException, ServletException {

    }
}
