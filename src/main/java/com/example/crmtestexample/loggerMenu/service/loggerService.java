package com.example.crmtestexample.loggerMenu.service;


import com.example.crmtestexample.model.response.loggerVO;

import java.util.List;

public interface loggerService {

    //Logger List
    public int getLoggerList();

    //Logger Grid List
    public List<loggerVO> getLoggerGridList();

}
