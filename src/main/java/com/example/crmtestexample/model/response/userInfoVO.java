package com.example.crmtestexample.model.response;


import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("userInfoVO")
public class userInfoVO {

    /**
     *회원 관리 회원 정보*/
    public String  rnum;
    public String  custCd;
    public String  userNm;
    public String  childNm;
    public String  fCid;
    public String  fPid;
    public String  goodNm;
    public String  addr;
    public String  hno1;
    public String  hno2;
    public String  stuStat;
    public String  createAt;
    public String  agreementNm;

}
