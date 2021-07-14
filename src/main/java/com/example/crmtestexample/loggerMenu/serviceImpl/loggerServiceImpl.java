package com.example.crmtestexample.loggerMenu.serviceImpl;

import com.example.crmtestexample.loggerMenu.domain.loggerDao;
import com.example.crmtestexample.loggerMenu.service.loggerService;
import com.example.crmtestexample.model.response.loggerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class loggerServiceImpl implements loggerService {

    @Autowired
    private loggerDao logerDao;

    @Override
    public int getLoggerList() {

        return logerDao.getLoggerList();
    }

    @Override
    public List<loggerVO> getLoggerGridList() {

        return logerDao.getLoggerGridList();
    }
}
