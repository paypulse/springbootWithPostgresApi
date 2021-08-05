package com.example.crmtestexample.common.comCodeUtil.serviceImpl;

import com.example.crmtestexample.common.comCodeUtil.domain.comCodeUtilDao;
import com.example.crmtestexample.common.comCodeUtil.service.comCodeUtilService;
import com.example.crmtestexample.model.request.comCodeUtilRequest;
import com.example.crmtestexample.model.response.comCodeUtilVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Transactional
@Service
public class comCodeUtilServiceImpl implements comCodeUtilService {

    @Autowired
    public comCodeUtilDao comcodeUtilDao;


    /**
     * comCode List 조회
     * @param
     * @return
     * */
    @Override
    public List<comCodeUtilVO> selectComCodeList() {

        return comcodeUtilDao.selectComCodeList();
    }


    /**
     * 공통 코드 중복 체크
     * @param
     * @return
     * **/
    @Override
    public Map<String,Object> selectCheckMainCd(String mainCd) {
        int res;
        Map<String,Object> result = new HashMap<>();

        try{
           res = comcodeUtilDao.selectCheckMainCd(mainCd);
           if(res >=1){
               result.put("data",res);
               result.put("message","중복되었습니다.");
           }else{
               result.put("data", res);
               result.put("message","중복되지 않았습니다.");
           }

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    /**
     *
     * 공통코드 추가.
     *  @param
     *  @return
     * **/
    @Override
    public Map<String, Object> insertComCode(comCodeUtilRequest comReq) {

        //code000 에 저장


        //code100 에 저장


        return null;
    }
}
