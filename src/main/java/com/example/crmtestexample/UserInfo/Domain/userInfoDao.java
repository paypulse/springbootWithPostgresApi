package com.example.crmtestexample.UserInfo.Domain;

import com.example.crmtestexample.model.response.commonCode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface userInfoDao {


    //지사
    public List<commonCode> areaSelectBox();

    //상품
    public List<commonCode> goodSelectBox();

    //납부현황
    public List<commonCode> paymentSelectBox();

    //온라인 교육상태
    public List<commonCode> onlineStudySelectBox();

    //방문 교육 상태
    public List<commonCode> visitStudySelectBox();
}
