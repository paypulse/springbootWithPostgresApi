package com.example.crmtestexample.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Alias("comCodeUtilVo")
public class comCodeUtilVO {
    public String  rnum;
    public String  mainCode;
    public String  mainCdNm;
    public String  subCode;
    public String  subCodeNm;
    public String  createdBy;
    public String  createdAt;
    public String  updatedBy;
    public String  updatedAt;
    public String  useYn;
    public String  sort;
}
