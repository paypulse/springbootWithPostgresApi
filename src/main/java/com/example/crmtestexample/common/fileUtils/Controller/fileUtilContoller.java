package com.example.crmtestexample.common.fileUtils.Controller;


import com.example.crmtestexample.common.fileUtils.service.fileUtilService;
import com.example.crmtestexample.model.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping
public class fileUtilContoller {

    //logger
    private static final Logger logger = LoggerFactory.getLogger(fileUtilContoller.class);

    @Autowired
    private fileUtilService fileUtilService;

    //fileupload 위치
    @Value("${spring.servlet.multipart.location}")
    String savePath;

    /**
     * File Upload
     * @param
     * @return
     * */
    @RequestMapping(value="/singleFileUpload", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> singleFileUpload(HttpServletRequest req, HttpServletResponse res, @RequestParam("file") MultipartFile file, @RequestParam("user") String user){

        fileUtilService.singleFileUpload(file,user,savePath);

        return null;
    }

}
