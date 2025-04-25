package com.dronezzfly.onetoone.config;

import com.dronezzfly.onetoone.interceptor.Intercrptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private Intercrptors intercrptors;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       // WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(intercrptors)
                .addPathPatterns("/Aadhar/**")
                .excludePathPatterns("/user/**");
    }
}
