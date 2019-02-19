package com.security.demo.securitydemo.untils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:test.properties")
public class OauthProperty {

    @Value("${jwt.signing.key}")
    private String jWTSigningKey;

    public String getjWTSigningKey() {
        return jWTSigningKey;
    }
}
