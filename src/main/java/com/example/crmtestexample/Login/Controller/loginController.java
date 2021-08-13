package com.example.crmtestexample.Login.Controller;

import com.example.crmtestexample.Login.service.loginService;
import com.example.crmtestexample.model.request.loginRequest;
import com.example.crmtestexample.model.response.CommonResponse;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class loginController {

    //Logger
    private static final Logger logger = LoggerFactory.getLogger(loginController.class);

    //service
    @Autowired
    private loginService loginService;




    /**
     * User Login
     * @param
     * @return
     * */
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> checkIdPw(HttpServletRequest req, HttpServletResponse res, @RequestBody loginRequest param ) throws Exception{

        Map<String,Object> result = loginService.checkLogin(param.getId(), param.getPw());

        if(!result.get("token").equals("")){

            res.setHeader("jwtAuthToken",result.get("token").toString());

        }

        return ResponseEntity.ok(CommonResponse.builder()
                .data(result.get("data"))
                .status("SUCCESS")
                .msg((String) result.get("msg"))
                .processCnt((int)result.get("processCnt"))
                .build());
    }



}
