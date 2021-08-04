package com.example.crmtestexample.model.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class fileUtilRequest {
    private String filetype;
    private String filename;
    private String fileoriname;
    private String filepath;
    private String fileMakeUser;
}
