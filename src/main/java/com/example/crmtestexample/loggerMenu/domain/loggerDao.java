package com.example.crmtestexample.loggerMenu.domain;

import com.example.crmtestexample.model.response.loggerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface loggerDao {


    //Logger structure Test
    public  int getLoggerList();


    //Logger Grid List
    public List<loggerVO> getLoggerGridList();

    //Logger Delete row
    public int loggerDeleteRow(Integer loggerId);

}
