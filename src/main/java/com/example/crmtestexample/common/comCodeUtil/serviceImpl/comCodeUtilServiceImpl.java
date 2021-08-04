package com.example.crmtestexample.common.comCodeUtil.serviceImpl;

import com.example.crmtestexample.common.comCodeUtil.domain.comCodeUtilDao;
import com.example.crmtestexample.common.comCodeUtil.service.comCodeUtilService;
import com.example.crmtestexample.model.response.comCodeUtilVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
public class comCodeUtilServiceImpl implements comCodeUtilService {

    @Autowired
    public comCodeUtilDao comcodeUtilDao;


    @Override
    public List<comCodeUtilVO> selectComCodeList() {


        return comcodeUtilDao.selectComCodeList();
    }
}
