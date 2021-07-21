package com.example.crmtestexample.Login.Controller;

import com.example.crmtestexample.Login.service.loginService;
import com.example.crmtestexample.loggerMenu.Controller.loggerController;
import com.example.crmtestexample.model.request.loginRequest;
import com.example.crmtestexample.model.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class loginController {

    //Logger
    private static final Logger logger = LoggerFactory.getLogger(loggerController.class);

    //service
    @Autowired
    private loginService loginService;


    /**
     * Login ID/PW check
     * @param
     * @return
     * */
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> checkIdPw(HttpServletRequest req, HttpServletResponse res, @RequestBody loginRequest param ) throws Exception{

        System.out.println(param);

        String result = loginService.checkLogin(param.getId(), param.getPw());

        return ResponseEntity.ok(CommonResponse.builder()
                .data(result)
                .status("SUCCESS")
                .msg("structure test")
                .build());
    }


}
