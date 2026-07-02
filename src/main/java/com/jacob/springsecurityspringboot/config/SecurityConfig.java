package com.jacob.springsecurityspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/user/login", "/login.html").permitAll() // Must permit public access
                        .requestMatchers("/findAll").hasRole("管理员")
                        .requestMatchers("/find").hasRole("管理员")
                        .requestMatchers("/find").hasAuthority("menu:user")
                        .anyRequest().authenticated()
            )
            .formLogin(form -> form
                    .loginPage("/login.html")
                    .loginProcessingUrl("/user/login")
                    .defaultSuccessUrl("/index")
                    .failureForwardUrl("/fail")
                .permitAll()
            );

        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
