package com.grievanceredressalsystem.adminmanagementservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityWithCsrfCookieConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/user/**", "/department/**", "/role/**")
                .permitAll();
        return http.build();
        /*http.csrf((csrf) -> csrf
                .csrfTokenRepository(new HttpSessionCsrfTokenRepository()));
        return http.build();*/

        /*http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/user/**", "/department/**", "/role/**")
                        .permitAll()
                );
        return http.build();*/
    }
}
