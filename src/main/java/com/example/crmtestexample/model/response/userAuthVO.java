package com.example.crmtestexample.model.response;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("userAuthVO")
public class userAuthVO {

    public String userCd;
    public String grpAuthCd;
    public String roleCd;
    public String updatedAt;
    public String updatedBy;
    public String createdAt;
    public String createdBy;

}
