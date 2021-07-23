package com.example.crmtestexample.Login.service;


import java.util.Map;

public interface loginService {

    /**
     * Login ID/PW check
     * @param
     * @return
     * */
    public Map<String,Object>  checkLogin(String id, String pw);

}
