package com.jtsolv.jtsolvcurr.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

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

    /*
    @Bean
    @Primary
    @ConditionalOnMissingBean(DataSource.class)
    public DataSource fallbackDataSource() {
        System.out.println("⚠️ MySQL unavailable! Using H2 in-memory database as fallback.");
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .build();
    }
     */

    private  void logInfoEx(String s1, String s2 ){

    }
}
