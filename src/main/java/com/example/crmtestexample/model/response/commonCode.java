package com.example.crmtestexample.model.response;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("commonCode")
public class commonCode {
    public String codeCd;
    public String codeNm;
}
