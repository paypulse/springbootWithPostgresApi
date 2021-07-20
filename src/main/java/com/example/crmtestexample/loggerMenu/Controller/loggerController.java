package com.example.crmtestexample.loggerMenu.Controller;


import com.example.crmtestexample.model.request.loggerRequest;
import com.example.crmtestexample.model.response.CommonResponse;
import com.example.crmtestexample.loggerMenu.service.loggerService;
import com.example.crmtestexample.model.response.loggerVO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/loggerMenu")
public class loggerController {

    //logger
    private static final Logger logger = LoggerFactory.getLogger(loggerController.class);


    @Autowired
    private loggerService loggersercice;

    /* *
     *  api 구조 테스트
     * @param
     * @return
     * */
    @RequestMapping(value="/checkStructure",method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> checkStructure(HttpServletRequest req, HttpServletResponse res) throws Exception{


        int response = loggersercice.getLoggerList();

        return ResponseEntity.ok(CommonResponse.builder()
                .data(response)
                .status("SUCCESS")
                .msg("structure test")
                .build());
    }


    /* *
     *  Logger list 조회
     * @param
     * @return
     * */
    @RequestMapping(value="/loggerGridList",method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> loggerGidList(HttpServletRequest req, HttpServletResponse res) throws Exception{

        List<loggerVO> response = loggersercice.getLoggerGridList();
        Long processCnt = Long.parseLong(response.get(0).totalCnt);

        return ResponseEntity.ok(CommonResponse.builder()
                            .data(response)
                            .status("SUCCESS")
                            .processCnt(processCnt)
                            .build());
    }

    /* *
     *  Logger 삭제
     * @param Array
     * @return int
     * */
    @RequestMapping(value="/loggerDeleteRow",method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> loggerRowDelete(HttpServletRequest req, HttpServletResponse res, @RequestBody loggerRequest param) throws Exception{

        loggersercice.deleteRowList(param);

        return ResponseEntity.ok(CommonResponse.builder()
                .data("{}")
                .status("SUCCESS")
                .processCnt(1)
                .build());
    }










}
