package com.example.crmtestexample.common.userAuth.domain;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface userAuthDao {

    /**
     * 사용자 권한 조회 리스트
     * */
    public List<String> selectUserAuth();


}
