package com.example.crmtestexample.model.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class comCodeUtilRequest {
    private String userId;
    private String userName;
    private String mainCode;
    private String mainCdNm;
    private String subCode;
    private String subCodeNm;
    private String useYn;

}
