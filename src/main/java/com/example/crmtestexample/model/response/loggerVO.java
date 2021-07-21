package com.example.crmtestexample.model.response;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("loggerVo")
public class loggerVO {
    public String totalCnt;
    public String id;
    public String alertYn;
    public String errorTime;
    public String headerMap;
    public String hostName;
    public String loggerName;
    public String message;
    public String parameterMap;
    public String logPath;
    public String phase;
    public String serverName;
    public String systemN;
    public String userInfo;

}
