package com.example.crmtestexample.common.comCodeUtil.Controller;

import com.example.crmtestexample.common.comCodeUtil.service.comCodeUtilService;
import com.example.crmtestexample.model.request.comCodeUtilRequest;
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
     */
    @RequestMapping(value = "/selectComCode", method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> selectComCode(HttpServletRequest req, HttpServletResponse res) {


        return ResponseEntity.ok(CommonResponse.builder()
                .data(comcodeUtilService.selectComCodeList())
                .status("SUCCESS")
                .msg("structure test")
                .build());
    }

    /**
     * 공통 코드 중복 체크
     * @param mainCd
     * @return
     **/
    @RequestMapping(value = "/selectCheckMainCd", method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> selectCheckMainCd(HttpServletRequest req, HttpServletResponse res, @RequestParam("mainCode") String mainCd) {

        Map<String, Object> result = comcodeUtilService.selectCheckMainCd(mainCd);

        return ResponseEntity.ok(CommonResponse.builder()
                .data(result.get("data"))
                .status("SUCCESS")
                .msg((String) result.get("message"))
                .build());
    }

    /**
     * 공통코드 추가.
     * @param comReq
     * @return
     */
    @RequestMapping(value = "/insertComCode", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> insertComCode(HttpServletRequest req, HttpServletResponse res, @RequestBody comCodeUtilRequest comReq) {

        Map<String, Object> result = comcodeUtilService.insertComCode(comReq);

        return ResponseEntity.ok(CommonResponse.builder()
                .data(result.get("data"))
                .status("SUCCESS")
                .msg((String) result.get("message"))
                .build());
    }

    /**
     * 공통 코드 수정
     * @param comReq
     * @return
     */
    @RequestMapping(value = "/updateComCode", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> updateComCode(HttpServletRequest req, HttpServletResponse res, @RequestBody comCodeUtilRequest comReq) {

        System.out.println(comReq);
        Map<String,Object> result = comcodeUtilService.updateComCode(comReq);


        return ResponseEntity.ok(CommonResponse.builder()
                .data(result.get("data"))
                .status("SUCCESS")
                .msg((String) result.get("message"))
                .build());
    }

    /**
     * 공통 코드 삭제
     * @param mainCode, subCode
     * @return
     * */
    @RequestMapping(value = "/deleteComCode", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> deleteComCode(HttpServletRequest req, HttpServletResponse res, @RequestParam("mainCode") String mainCode, @RequestParam("subCode") String subCode) {

        Map<String,Object> result = comcodeUtilService.deleteComCode(mainCode,subCode);

        return ResponseEntity.ok(CommonResponse.builder()
                .data(result.get("data"))
                .status("SUCCESS")
                .msg((String) result.get("message"))
                .build());
    }




    }
