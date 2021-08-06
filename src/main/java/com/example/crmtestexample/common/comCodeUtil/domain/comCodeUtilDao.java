package com.example.crmtestexample.common.comCodeUtil.domain;

import com.example.crmtestexample.model.request.comCodeUtilRequest;
import com.example.crmtestexample.model.response.comCodeUtilVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface comCodeUtilDao {

    /**
     * comCodeList 조회
     * */
    List<comCodeUtilVO> selectComCodeList();

    /**
     * comCode 중복 체크
     * */
    int selectCheckMainCd(String main_code);

    /**
     * comCode 신규 추가.
     * */
    int insertComCode000(comCodeUtilRequest req);
    int insertComCode100(comCodeUtilRequest req);

    /**
     * comCode 수정
     * */
    int updateComCode000(comCodeUtilRequest req);
    int updateComCode100(comCodeUtilRequest req);


    /**
     * comCode 삭제
     * */
    int selectCode100Cnt(String mainCode);
    int deleteCode100(Map<String,String> param);
    int deleteCode000(Map<String,String> param);



}
