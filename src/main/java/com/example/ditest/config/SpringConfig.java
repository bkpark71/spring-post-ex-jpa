package com.example.ditest.config;

import com.example.ditest.controller.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;

@Configuration
public class SpringConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers("/login", "/users/new").permitAll()
                .anyRequest().authenticated();
        http.formLogin(login -> login.loginPage("/login")
                .usernameParameter("userId")
                .passwordParameter("password")
                        .successHandler(new LoginSuccessHandler())
                        //.defaultSuccessUrl("/posts")
                 )
                .exceptionHandling(exception -> exception.accessDeniedPage("/access-denied"));

        return http.build();
    }
}
