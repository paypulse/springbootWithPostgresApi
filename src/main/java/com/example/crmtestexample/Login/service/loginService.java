package com.example.crmtestexample.Login.service;


import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface loginService {

    /**
     * user Login
     * @param
     * @return
     * */
    public Map<String,Object>  checkLogin(String id, String pw);

}
