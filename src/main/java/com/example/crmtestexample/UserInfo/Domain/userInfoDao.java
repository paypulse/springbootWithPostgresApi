package com.example.crmtestexample.UserInfo.Domain;

import com.example.crmtestexample.model.response.commonCode;
import com.example.crmtestexample.model.response.userInfoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface userInfoDao {

    //상품
    public List<commonCode> goodSelectBox();
    //온라인 교육상태
    public List<commonCode> onlineStudySelectBox();

    //회원 정보 그리드 리스트
    public List<userInfoVO> setUserInfoGridList();

}
