package com.example.crmtestexample.common.config;

import com.example.crmtestexample.model.response.UserVO;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
@Slf4j
public class jwtService {
    @Value("${jwt.salt}")
    private String salt;

    @Value("${jwt.expmin}")
    private Long expireMin;

    /**
     * JWTTOKEN을 생성
     * @param userVO
     * @return
     * */
    public String jwtCreate(UserVO userVO) {
        final JwtBuilder builder = Jwts.builder();

        //JWT token header 설정 , 토큰의 타입으로 고정 값
        builder.setHeaderParam("typ","JWT");

        //payload 설정 - claim 정보 포함
        builder.setSubject("loginToken")
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * expireMin ))
                .claim("User",userVO);

        //signature - secret key를 이용한 암호화
        builder.signWith(SignatureAlgorithm.HS256,salt.getBytes());

        //직렬화 처리
        final String jwt = builder.compact();
        log.debug("토큰 발생: {}", jwt);
        return jwt;

    }

    /**
     * JWTTOKEN 생성 확인
     * @param jwt
     * */
    public void checkValid(String jwt) {
        log.debug("토큰 점검:{}", jwt);
        Jwts.parser().setSigningKey(salt.getBytes()).parseClaimsJws(jwt);
    }

    /**
     * JWTTOKEN 분석
     * @param jwt
     * */
    public Map<String, Object> get(String jwt) {
        Jws<Claims> claims = null;
        try{
            claims = Jwts.parser().setSigningKey(salt.getBytes()).parseClaimsJws(jwt);
        }catch (final Exception e){
            throw new RuntimeException();
        }
        log.debug("claims:{}", claims);
        return claims.getBody();
    }
}
