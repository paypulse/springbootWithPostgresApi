package com.example.crmtestexample.Login.domain;

import com.example.crmtestexample.model.response.UserLoginVO;
import com.example.crmtestexample.model.response.UserVO;
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
    public int checkUserIDandPw(UserVO user);

    /**
     * Login User Info
     * */
    public UserLoginVO selectUser(String uid);



}
