package com.example.crmtestexample.common.jwt.serviceImpl;

import com.example.crmtestexample.common.jwt.service.jwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class jwtServiceImpl implements jwtService {

    private static final String SECRET_KEY="accessToken";


}
