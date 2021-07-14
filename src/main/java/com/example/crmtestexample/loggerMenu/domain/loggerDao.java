package com.example.crmtestexample.loggerMenu.domain;

import com.example.crmtestexample.model.response.loggerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface loggerDao {


    //Logger List
    public  int getLoggerList();


    public List<loggerVO> getLoggerGridList();

}
