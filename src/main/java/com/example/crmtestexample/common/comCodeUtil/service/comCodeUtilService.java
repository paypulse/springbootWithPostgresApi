package com.example.crmtestexample.common.comCodeUtil.service;

import com.example.crmtestexample.model.response.comCodeUtilVO;


import java.util.List;


public interface comCodeUtilService {

    /**
     * comCode List 조회
     * @param
     * @return
    * */
    public List<comCodeUtilVO> selectComCodeList();


}
