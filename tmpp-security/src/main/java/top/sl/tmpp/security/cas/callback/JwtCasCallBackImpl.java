package top.sl.tmpp.security.cas.callback;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import top.itning.cas.CasProperties;
import top.itning.cas.RestModel;
import top.itning.cas.callback.login.ILoginFailureCallBack;
import top.itning.cas.callback.login.ILoginNeverCallBack;
import top.itning.cas.callback.login.ILoginSuccessCallBack;
import top.sl.tmpp.common.entity.AdminUser;
import top.sl.tmpp.common.entity.LoginUser;
import top.sl.tmpp.common.mapper.CasMapper;
import top.sl.tmpp.common.mapper.LoginUserMapper;
import top.sl.tmpp.security.util.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

import static org.springframework.http.HttpHeaders.*;

/**
 * Jwt实现
 *
 * @author itning
 */
@Component
public class JwtCasCallBackImpl implements ILoginSuccessCallBack, ILoginFailureCallBack, ILoginNeverCallBack {
    private final Logger logger = LoggerFactory.getLogger(JwtCasCallBackImpl.class);

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String STUDENT_USER = "99";

    private final CasProperties casProperties;
    private final LoginUserMapper loginUserMapper;
    private final CasMapper casMapper;

    public JwtCasCallBackImpl(CasProperties casProperties, LoginUserMapper loginUserMapper, CasMapper casMapper) {
        this.casProperties = casProperties;
        this.loginUserMapper = loginUserMapper;
        this.casMapper = casMapper;
    }

    @Override
    public void onLoginSuccess(HttpServletResponse resp, HttpServletRequest req, Map<String, String> attributesMap) throws IOException {
        if (attributesMap.isEmpty()) {
            sendRefresh2Response(resp);
            return;
        }
        LoginUser loginUser = map2userLoginEntity(attributesMap);
        if (loginUser.getUserType().equals(STUDENT_USER)) {
            logger.debug("CheckRole FORBIDDEN And LoginUser Type Is Student. {}", loginUser);
            resp.setCharacterEncoding("utf-8");
            PrintWriter writer = resp.getWriter();
            writer.write("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>身份信息认证失败</title></head>" +
                    "<body>学生用户无法访问该系统 学号：" + loginUser.getId() + " 姓名：" + loginUser.getName() + " <a href='" + casProperties.getLogoutUrl() + "'>注销</a></body></html>");
            writer.flush();
            writer.close();
            return;
        }
        AdminUser adminUser = casMapper.selectByUserName(loginUser.getId());
        if (adminUser != null) {
            loginUser.setUserType(adminUser.getType());
        } else {
            loginUser.setUserType("T");
            logger.debug("username {} is teacher", loginUser.getId());
        }
        String jwt = JwtUtils.buildJwt(loginUser);
        if (loginUserMapper.selectByPrimaryKey(loginUser.getId()) == null) {
            Date date = new Date();
            loginUser.setGmtCreate(date);
            loginUser.setGmtModified(date);
            loginUserMapper.insert(loginUser);
        }
        //重定向到登陆成功需要跳转的地址
        resp.sendRedirect(casProperties.getLoginSuccessUrl().toString() + "/token/" + jwt);
    }

    @Override
    public void onLoginFailure(HttpServletResponse resp, HttpServletRequest req, Exception e) throws IOException {
        sendRefresh2Response(resp);
    }

    @Override
    public void onNeverLogin(HttpServletResponse resp, HttpServletRequest req) throws IOException {
        allowCors(resp, req);
        writeJson2Response(resp, HttpStatus.UNAUTHORIZED, "请先登录");
    }

    /**
     * 将Map集合转换成{@link LoginUser}
     *
     * @param map 要转换的Map集合
     * @return {@link LoginUser}
     */
    private LoginUser map2userLoginEntity(Map<String, String> map) {
        LoginUser loginUser = new LoginUser();
        loginUser.setId(map.get("no"));
        loginUser.setName(map.get("name"));
        loginUser.setUserType(map.get("userType"));
        return loginUser;
    }

    /**
     * 登陆失败时
     *
     * @param resp {@link HttpServletResponse}
     * @throws IOException IOException
     */
    private void sendRefresh2Response(HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("utf-8");
        String location = casProperties.getLoginUrl() + "?service=" + URLEncoder.encode(casProperties.getLocalServerUrl().toString(), "UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<!DOCTYPE html><html><head><meta charset=\"UTF-8\">\n" +
                "<meta http-equiv=\"refresh\" content=\"3;url=" + location + "\">" +
                "<title>身份信息获取失败</title></head><body>" +
                "身份信息获取失败，3秒后重试..." +
                "</body></html>");
        writer.flush();
        writer.close();
    }

    /**
     * 允许跨域(不管客户端地址是什么，全部允许)
     *
     * @param resp {@link HttpServletResponse}
     * @param req  {@link HttpServletRequest}
     */
    private void allowCors(HttpServletResponse resp, HttpServletRequest req) {
        String origin = req.getHeader(ORIGIN);
        resp.setHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        resp.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, origin);
        resp.setHeader(ACCESS_CONTROL_ALLOW_METHODS, "POST,GET,OPTIONS,DELETE,PUT,PATCH");
        resp.setHeader(ACCESS_CONTROL_ALLOW_HEADERS, req.getHeader(ACCESS_CONTROL_REQUEST_HEADERS));
        resp.setIntHeader(ACCESS_CONTROL_MAX_AGE, 2592000);
    }

    /**
     * 将消息转换成JSON并写入到{@link HttpServletResponse}中
     *
     * @param resp       {@link HttpServletResponse}
     * @param httpStatus {@link HttpStatus}
     * @param msg        消息
     * @throws IOException IOException
     */
    @SuppressWarnings("SameParameterValue")
    private void writeJson2Response(HttpServletResponse resp, HttpStatus httpStatus, String msg) throws IOException {
        resp.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        resp.setStatus(httpStatus.value());
        RestModel<Void> restModel = new RestModel<>();
        restModel.setCode(httpStatus.value());
        restModel.setMsg(msg);
        String json = MAPPER.writeValueAsString(restModel);
        PrintWriter writer = resp.getWriter();
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
