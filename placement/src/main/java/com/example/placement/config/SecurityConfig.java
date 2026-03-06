package com.example.placement.config;

import com.example.placement.security.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Autowired
    private JwtFilter jwtFilter;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/register").hasRole("ADMIN")
                        .requestMatchers("/auth/register").denyAll()
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/students/apply").hasRole("STUDENT")
                        .requestMatchers("/students/**").hasRole("STUDENT")
                        .requestMatchers("/students/applicatons/**").hasRole("COMPANY")
                        .requestMatchers("/companies/applications/**").hasRole("COMPANY")
                        .requestMatchers("/companies/**").hasRole("COMPANY")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
