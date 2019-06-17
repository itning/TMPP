package top.sl.tmpp.security.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import top.sl.tmpp.common.entity.LoginUser;

public class JwtUtilsTest {

    @org.junit.Test
    public void buildJwt() throws JsonProcessingException {
        LoginUser loginUser = new LoginUser();
        loginUser.setId("14008");
        loginUser.setName("舒露");
        loginUser.setUserType("13");


        String s = JwtUtils.buildJwt(loginUser);
        System.out.println(s);
    }

    @org.junit.Test
    public void getLoginUser() {
    }
}