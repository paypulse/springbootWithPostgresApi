package com.example.crmtestexample.common.fileUtils.service;

import org.springframework.web.multipart.MultipartFile;

public interface fileUtilService {

    /**
     * File Upload
     * @param
     * @return
     * */
    public void singleFileUpload(MultipartFile file,String user,String savePath);

}
