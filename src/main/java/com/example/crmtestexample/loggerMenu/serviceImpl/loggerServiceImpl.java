package com.example.crmtestexample.loggerMenu.serviceImpl;

import com.example.crmtestexample.loggerMenu.domain.loggerDao;
import com.example.crmtestexample.loggerMenu.service.loggerService;
import com.example.crmtestexample.model.request.loggerRequest;
import com.example.crmtestexample.model.response.loggerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class loggerServiceImpl implements loggerService {

    @Autowired
    private loggerDao logerDao;

    /**
     * Structure Example
     * */
    @Override
    public int getLoggerList() {

        return logerDao.getLoggerList();
    }

    /**
     * Logger Grid List
     * */
    @Override
    public List<loggerVO> getLoggerGridList() {

        return logerDao.getLoggerGridList();
    }


    @Override
    public void deleteRowList(loggerRequest param) {

       for(int i=0;i<param.getLoggerId().size();i++){
           logerDao.loggerDeleteRow(Integer.parseInt(param.getLoggerId().get(i)));
       }


    }
}
