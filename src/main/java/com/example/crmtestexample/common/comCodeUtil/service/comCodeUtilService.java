package com.example.crmtestexample.common.comCodeUtil.service;

import com.example.crmtestexample.model.request.comCodeUtilRequest;
import com.example.crmtestexample.model.response.comCodeUtilVO;


import java.util.List;
import java.util.Map;


public interface comCodeUtilService {

    /**
     * comCode List 조회
     * @param
     * @return
    * */
    public List<comCodeUtilVO> selectComCodeList();


    /**
     * 공통 코드 중복 체크
     *  @param mainCd
     *  @return
     * **/
    public Map<String,Object> selectCheckMainCd(String mainCd);

    /**
     * 공통코드 신규 추가.
     *  @param comReq
     *  @return
     * **/
    public Map<String,Object> insertComCode(comCodeUtilRequest comReq);

    /**
     * 공통코드 수정
     * @param comReq
     * @return
     * */
    public Map<String,Object> updateComCode(comCodeUtilRequest comReq);

    /**
     * 공통코드 삭제
     * @param mainCode,subCode
     * @return
     * */
    public Map<String,Object> deleteComCode(String mainCode, String subCode);


}
