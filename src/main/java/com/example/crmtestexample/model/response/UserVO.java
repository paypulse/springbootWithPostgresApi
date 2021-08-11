package com.example.crmtestexample.model.response;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Alias("userVO")
public class UserVO {
    private String userCd;
    private String userPs;
}
