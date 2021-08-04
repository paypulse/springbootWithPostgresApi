package com.example.crmtestexample.common.comCodeUtil.domain;

import com.example.crmtestexample.model.response.comCodeUtilVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface comCodeUtilDao {

    /**
     * comCodeList 조회
     * */
    List<comCodeUtilVO> selectComCodeList();

}
