package com.example.crmtestexample.common.comCodeUtil.Controller;

import com.example.crmtestexample.common.comCodeUtil.service.comCodeUtilService;
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

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping
public class comCodeUtilController {

    //logger
    private static final Logger logger = LoggerFactory.getLogger(comCodeUtilController.class);

    @Autowired
    private comCodeUtilService comcodeUtilService;


    /**
     * 공통 코드 조회
     * @param
     * @return
     * */
    @RequestMapping(value="/selectComCode", method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> selectComCode(HttpServletRequest req, HttpServletResponse res){


        return ResponseEntity.ok(CommonResponse.builder()
                .data(comcodeUtilService.selectComCodeList())
                .status("SUCCESS")
                .msg("structure test")
                .build());
    }
}
