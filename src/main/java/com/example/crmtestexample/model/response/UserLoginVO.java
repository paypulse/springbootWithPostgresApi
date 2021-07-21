package com.example.crmtestexample.model.response;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("UserLoginVO")
public class UserLoginVO {
    public String userCd;
    public String userType;
    public String decisionYn;
    public String userNm;
    public String areaCd;
    public String ordClass;
    public String ordCd;
    public String rankCd;
    public String hpNo;
    public String telNo;
    public String birthDay;
    public String zipCode;
    public String addr1;
    public String addr2;
    public String userStatus;
    public String menuGrpCd;
    public String custCd;
    public String childCd;
}
