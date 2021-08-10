package com.example.crmtestexample.common.userAuth.service;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface userAuthService {

    //사용자 권한 조회
    public List<String> selectUserAuth();

}
