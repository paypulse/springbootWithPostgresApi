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
        int res1 = 0;
        int res2 = 0;
        Map<String,Object> result = new HashMap<String,Object>();

        // 중복 체크
        if(comcodeUtilDao.selectCheckMainCd(comReq.getMainCode()) < 1){
            try{
                res1 = comcodeUtilDao.insertComCode000(comReq);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        //code100 에 저장
        try{
            res2 = comcodeUtilDao.insertComCode100(comReq);


            if( (res1 + res2) >=1){
                // 등록완성
                result.put("data", res1+res2);
                result.put("message","등록이 되었습니다");
            }else{
                //등록이 되지 않음
                result.put("data", res1+res2);
                result.put("message","등록이 되지않았습니다.");
            }


        }catch (Exception e){
            e.printStackTrace();
        }


        return result;
    }


    /**
     * 공통코드 수정
     * @param comReq
     * @return
     * */
    @Override
    public Map<String, Object> updateComCode(comCodeUtilRequest comReq) {

        int res1=0;
        int res2=0;
        Map<String,Object> result = new HashMap<String,Object>();

        try{
            //code000 수정
            res1 = comcodeUtilDao.updateComCode000(comReq);
            //code100 수정
            res2 = comcodeUtilDao.updateComCode100(comReq);
            if(res1+res2 >=1){
                result.put("data", res1+res2);
                result.put("message", "수정했습니다.");
            }else{
                result.put("data", res1+res2);
                result.put("message", "수정에 실패 했습니다.");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 공통코드 삭제
     * @param mainCode, subCode
     * @return
     * */
    @Override
    public Map<String, Object> deleteComCode(String mainCode, String subCode) {
        Map<String,String> param = new HashMap<String,String>();
        param.put("mainCode", mainCode);
        param.put("subCode",subCode);

        Map<String,Object> result = new HashMap<String,Object>();
        int counting  =0;
        int res1 =0;
        int res2 =0;
        try{
            counting =comcodeUtilDao.selectCode100Cnt(param.get("mainCode"));
            if(counting > 1){
                //아직 code000에서 삭제 하지 않는다.
                res1 = comcodeUtilDao.deleteCode100(param);
            }else{
                //code000에도 삭제
                res1 = comcodeUtilDao.deleteCode100(param);
                res2 = comcodeUtilDao.deleteCode000(param);
            }

            if((res1+res2) >=1){
                result.put("data",res1+res2);
                result.put("message","삭제 했습니다");
            }else{
                result.put("data",res1+res2);
                result.put("message","삭제를 실패했습니다.");
            }


        }catch (Exception e){

        }

        return result;
    }


}
