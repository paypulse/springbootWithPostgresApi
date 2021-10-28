package com.example.crmtestexample.UserInfo.Service;

import com.example.crmtestexample.model.response.userInfoVO;

import java.util.List;
import java.util.Map;

public interface userInfoService {
    /**
     * 회원관리 페이지 SelectBoxes
     * **/
    public Map<String,Object> userInfoSelectBox();

    /**
     * 회원 관리 페이지 grid list
     * */
    public List<userInfoVO> userInfoGridList();

}
