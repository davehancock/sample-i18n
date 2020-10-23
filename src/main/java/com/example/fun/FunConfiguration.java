package com.example.fun;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties
public class FunConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "fun")
    public Map<FunType, Fun> funEntries() {
        return new HashMap<>();
    }

}
