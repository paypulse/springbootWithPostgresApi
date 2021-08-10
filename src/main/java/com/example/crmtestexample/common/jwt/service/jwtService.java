package com.example.crmtestexample.common.jwt.service;

public interface jwtService {

    /**
     * 토큰 발행
     */
    public String createToken(String Subject, long time);

    

}
