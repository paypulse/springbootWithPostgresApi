package com.example.crmtestexample.common.userAuth.serviceImpl;

import com.example.crmtestexample.common.userAuth.domain.userAuthDao;
import com.example.crmtestexample.common.userAuth.service.userAuthService;
import com.example.crmtestexample.model.response.userAuthVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
public class userAuthServiceImpl implements userAuthService {

    @Autowired
    private userAuthDao userAuthDao;

    @Override
    public List<String> selectUserAuth() {
        return userAuthDao.selectUserAuth();
    }

}
