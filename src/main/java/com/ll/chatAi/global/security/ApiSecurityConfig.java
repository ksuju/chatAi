package com.ll.chatAi.global.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * packageName    : com.ll.chatAi.global.security
 * fileName       : ApiSecurityConfig
 * author         : sungjun
 * date           : 2025-01-10
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-10        kyd54       최초 생성
 */
// api 경로 보안 설정
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ApiSecurityConfig {
    private final JwtAuthorizationFilter jwtAuthorizationFilter;
    @Bean
    SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/api/**")
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers(HttpMethod.GET, "/api/*/articles").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/*/articles/*").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/*/members/login").permitAll() // 로그인은 누구나 가능, post 요청만 허용
                        .requestMatchers(HttpMethod.GET, "/api/*/members/*").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/*/members/logout").permitAll()   // 로그아웃
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable()) // csrf 토큰 끄기
                .httpBasic(httpBasic -> httpBasic.disable()) // httpBasic 로그인 방식 끄기
                .formLogin(formLogin -> formLogin.disable()) // 폼 로그인 방식 끄기
                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))   // 세션 끄기
                .addFilterBefore(
                        jwtAuthorizationFilter, //엑세스 토큰을 이용한 로그인 처리
                        UsernamePasswordAuthenticationFilter.class
                );
        return http.build();
    }
}
