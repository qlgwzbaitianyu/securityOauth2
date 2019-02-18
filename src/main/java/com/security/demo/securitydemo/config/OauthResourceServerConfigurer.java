package com.security.demo.securitydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class OauthResourceServerConfigurer extends ResourceServerConfigurerAdapter{

    @Override
    public void configure(HttpSecurity http) throws Exception {
        /*http
                .anonymous().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers("/form-login.html").permitAll();*/
                /*.and()
                .authorizeRequests()
                .antMatchers("/oauth/*").permitAll();*/
        http.requestMatchers().antMatchers("/users/*").antMatchers("/users*").antMatchers("/oauth/token*").and().authorizeRequests().anyRequest().authenticated()
                .and()
                .requestMatchers().antMatchers("/orders/*").and().authorizeRequests().anyRequest().authenticated();

    }
}
