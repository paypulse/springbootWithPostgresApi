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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
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

        int result = loginService.checkLogin(param.getId(), param.getPw());
        CommonResponse commonResponse = new CommonResponse();

        if(result == 1){
            commonResponse.setData(result);
            commonResponse.setMsg("로그인 성공");
            commonResponse.setStatus("SUCCESS");
        }else if(result == 2){
            commonResponse.setData(result);
            commonResponse.setMsg("존재 하지 않는 계정 입니다.");
            commonResponse.setStatus("SUCCESS");
        }else if(result == 3){
            commonResponse.setData(result);
            commonResponse.setMsg("비밀번호가 틀렸습니다.");
            commonResponse.setStatus("SUCCESS");
        }

        return ResponseEntity.ok(commonResponse);
    }


}
