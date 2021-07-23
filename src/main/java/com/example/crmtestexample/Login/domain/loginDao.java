package com.example.crmtestexample.Login.domain;

import com.example.crmtestexample.model.response.UserLoginVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.Map;

@Mapper
public interface loginDao {

    /**
     * Login ID check
     * */
    public int checkUserId(String uid);

    /**
     * Login PW check
     * **/
    public int checkUserIDandPw(Map<String, String> idpw);

    /**
     * Login User Info
     * */
    public UserLoginVO selectUser(String uid);



}
