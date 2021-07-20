package com.example.crmtestexample.model.request;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class loggerRequest {
    //logger List Id
    private List<String> loggerId;
}
