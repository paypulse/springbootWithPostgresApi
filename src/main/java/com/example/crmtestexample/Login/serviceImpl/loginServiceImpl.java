package com.example.crmtestexample.Login.serviceImpl;

import com.example.crmtestexample.Login.domain.loginDao;
import com.example.crmtestexample.Login.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Transactional
@Service
public class loginServiceImpl implements loginService {

    @Autowired
    private loginDao loginDao;



    /**
     * Login ID/PW check
     * @param
     * @return
     * */
    @Override
    public Map<String,Object> checkLogin(String id, String pw) {
        Map<String,String> req = new HashMap<>();
        Map<String,Object> resultMap = new HashMap<>();

        req.put("id",id);
        req.put("pw",pw);

        int result=0;
        int idCheck = loginDao.checkUserId(id);

        if(idCheck>=1){
           //password
           int pwCheck = loginDao.checkUserIDandPw(req);
           if(pwCheck<1){
               result = 3;
               resultMap.put("loginYN",result);
           }else{
               //로그인 성공
               result = 1;
               resultMap.put("loginYN",result);
               resultMap.put("userInfo",loginDao.selectUser(id));
           }
        }else{
            result = 2;
            resultMap.put("loginYN",result);
        }

        return resultMap;
    }

}
