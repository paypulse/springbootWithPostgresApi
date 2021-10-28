package com.example.crmtestexample.UserInfo.ServiceImpl;

import com.example.crmtestexample.UserInfo.Domain.userInfoDao;
import com.example.crmtestexample.UserInfo.Service.userInfoService;
import com.example.crmtestexample.model.response.userInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
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
        result.put("goods", userInfoDao.goodSelectBox());
        result.put("onlineStudy", userInfoDao.onlineStudySelectBox());

        return result;
    }

    /**
     * 회원 관리 페이지 grid list
     * **/
    @Override
    public List<userInfoVO> userInfoGridList() {

        return  userInfoDao.setUserInfoGridList();
    }
}
