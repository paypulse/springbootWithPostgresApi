package com.example.crmtestexample.common.fileUtils.domain;

import com.example.crmtestexample.model.request.fileUtilRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface fileUtilDao {

    /**
     * File upload
     * */
    void singleFileUpload(fileUtilRequest req);

}
