package com.example.crmtestexample.Login.serviceImpl;

import com.example.crmtestexample.Login.domain.loginDao;
import com.example.crmtestexample.Login.service.loginService;
import com.example.crmtestexample.common.config.jwtService;
import com.example.crmtestexample.model.response.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Transactional
@Service
public class loginServiceImpl implements loginService {

    @Autowired
    private loginDao loginDao;

    @Autowired
    private jwtService jwtService;

    /**
     * user Login
     * @param
     * @return
     * */
    @Override
    public Map<String,Object> checkLogin(String id, String pw) {

        Map<String,Object> resultMap = new HashMap<>();

        UserVO user = new UserVO();
        user.setUserCd(id);
        user.setUserPs(pw);


        int idCheck = loginDao.checkUserId(id);

        if(idCheck>=1){
           //password
           int pwCheck = loginDao.checkUserIDandPw(user);
           System.out.println("pwCheck :  "+pwCheck);
           if(pwCheck<1){

               resultMap.put("data","{}");
               resultMap.put("msg","비밀 번호가 틀렸습니다.");
               resultMap.put("processCnt",3);

           }else{

               //로그인 성공
               resultMap.put("data",loginDao.selectUser(id));
               resultMap.put("msg","로그인 성공");
               resultMap.put("processCnt", pwCheck);
               //토큰 생성
               resultMap.put("token",jwtService.jwtCreate(user));



           }
        }else{

            resultMap.put("data", "{}");
            resultMap.put("msg", "아이디가 존재하지 않습니다.");
            resultMap.put("processCnt", 2);
        }

        return resultMap;
    }

}
