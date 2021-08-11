package com.example.crmtestexample.common.config.interceptor;

import com.example.crmtestexample.common.config.jwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
@Slf4j
public class jwtInterceptor implements HandlerInterceptor {

    @Autowired
    private jwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("*** interceptor*** ");
        if(request.getMethod().equals("OPTIONS")){
            return  true;
        }else{
            //request의 parameter에서 auth_token으로 넘어온 애를 찾아 보기
            String token = request.getHeader("jwtAuthToken");

            if(token != null && token.length() >0){
                jwtService.checkValid(token);
                log.debug("토큰 사용 가능  : {}", token);
                return true;
            }else{
                throw new RuntimeException("인증 토큰이 없습니다.");
            }

        }

    }
}
