package com.example.crmtestexample.common.config;

import com.example.crmtestexample.common.config.interceptor.jwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private jwtInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(interceptor)
               .addPathPatterns("/**")
               .excludePathPatterns("/login")
               .excludePathPatterns("/loggerMenu/**") ;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .exposedHeaders("jwtAuthToken");
    }
}
