package com.example.crmtestexample.model.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class loginRequest {
    //login Id
    private String id;
    //login pw
    private String pw;
}
