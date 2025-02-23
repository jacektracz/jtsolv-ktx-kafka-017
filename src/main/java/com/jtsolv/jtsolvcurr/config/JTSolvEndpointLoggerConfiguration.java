package com.jtsolv.jtsolvcurr.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;

@Configuration
public class JTSolvEndpointLoggerConfiguration {


    @Bean
    public CommandLineRunner logEndpoints(@Qualifier(value = "requestMappingHandlerMapping") RequestMappingHandlerMapping mapping) {
        return args -> {
            Map<RequestMappingInfo, ?> handlerMethods = mapping.getHandlerMethods();
            System.out.println("Registered Endpoints:");
            handlerMethods.forEach(
                    (key, value) -> System.out.println(key));
        };
    }

}
