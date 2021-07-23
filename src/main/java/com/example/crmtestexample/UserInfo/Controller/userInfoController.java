package com.example.crmtestexample.UserInfo.Controller;

import com.example.crmtestexample.UserInfo.Service.userInfoService;
import com.example.crmtestexample.model.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/userInfo")
public class userInfoController {

    //logger
    private static final Logger logger = LoggerFactory.getLogger(userInfoController.class);

    @Autowired
    private userInfoService userInfoService;


    /**
     * 회원관리 페이지 SelectBoxes
     * **/
    @RequestMapping(value="/selectBox",method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> userSelectbox(HttpServletRequest req, HttpServletResponse res) throws Exception{

        Map<String,Object> response = userInfoService.userInfoSelectBox();

        System.out.println(response);

        return ResponseEntity.ok(CommonResponse.builder()
                .data(response)
                .status("SUCCESS")
                .msg("selectBoxes")
                .build());
    }



}
