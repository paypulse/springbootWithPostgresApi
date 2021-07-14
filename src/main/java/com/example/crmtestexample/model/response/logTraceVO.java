package com.example.crmtestexample.model.response;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("logTraceVO")
public class logTraceVO {
    public String APP_VERSION_CODE;
    public String APP_VERSION_NAME;
    public String PHONE_MODEL;
    public String ANDROID_VERSION;
    public String CUSTOM_DATA;
    public String STACK_TRACE;

}
