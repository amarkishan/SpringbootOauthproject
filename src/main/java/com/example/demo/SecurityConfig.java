package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;


;

@Configuration
public class SecurityConfig 
{

    
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
     
    	   http.authorizeHttpRequests((authz) -> authz
                                .requestMatchers("/","/index","/error").permitAll()
                                
                                .anyRequest().authenticated()
                )
                .oauth2Login(login -> login
                        .defaultSuccessUrl("/home", true));

        return http.build();
    }
}