package com.example.game.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;


//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig
{
/*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http
                .authorizeHttpRequests((authz) -> authz
                      //  .requestMatchers("/api/**").authenticated()
                        .requestMatchers("/api/v1/login/{email}").permitAll()
                        .anyRequest().authenticated()
                ).csrf(AbstractHttpConfigurer::disable);;
        return http.build();

    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
*/
}
