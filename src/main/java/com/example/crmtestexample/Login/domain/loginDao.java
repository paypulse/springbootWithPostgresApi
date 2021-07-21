package com.example.crmtestexample.Login.domain;

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




}
