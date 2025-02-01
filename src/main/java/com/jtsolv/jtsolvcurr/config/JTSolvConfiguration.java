package com.jtsolv.jtsolvcurr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JTSolvConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        final String s_fun = "passwordEncoder";
        logInfoEx(s_fun, "start");

        PasswordEncoder retObj = new BCryptPasswordEncoder();
        logInfoEx(s_fun, "end");
        return retObj;
    }

    private  void logInfoEx(String s1, String s2 ){

    }
}
