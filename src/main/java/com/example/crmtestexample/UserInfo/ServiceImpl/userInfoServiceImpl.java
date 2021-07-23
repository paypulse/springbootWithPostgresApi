package com.example.crmtestexample.UserInfo.ServiceImpl;

import com.example.crmtestexample.UserInfo.Domain.userInfoDao;
import com.example.crmtestexample.UserInfo.Service.userInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Transactional
@Service
public class userInfoServiceImpl implements userInfoService {

    @Autowired
    private userInfoDao userInfoDao;



    /**
     * 회원관리 페이지 SelectBoxes
     * */
    @Override
    public Map<String, Object> userInfoSelectBox() {
        //지사 selectbox
        Map<String,Object> result = new HashMap<>();
        result.put("area", userInfoDao.areaSelectBox());
        result.put("goods", userInfoDao.goodSelectBox());
        result.put("payment",userInfoDao.paymentSelectBox());
        result.put("onlineStudy", userInfoDao.onlineStudySelectBox());
        result.put("visiteStudy", userInfoDao.visitStudySelectBox());

        return result;
    }
}
