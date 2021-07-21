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
    public String checkLogin(String id, String pw) {
        Map<String,String> req = new HashMap<>();
        req.put("id",id);
        req.put("pw",pw);

        String result="test";
        int idCheck = loginDao.checkUserId(id);

        if(idCheck>=1){
           //password
           int pwCheck = loginDao.checkUserIDandPw(req);
           if(pwCheck<1){
               result = "비밀 번호를 다시 입력해 주세요 ";
           }else{
               result = "로그인 성공";
           }

        }else{
            result = "아이디를 다시 입력해 주세요 ";
        }

        return result;
    }

}
