package com.chatai.chataiweb.member;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() { // 해싱 Bean 등록
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable()); // csrf 보안 해제

        // 모든 페이지에 접속 허용 가능
        http.authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("/**").permitAll()
        );

        // form으로 로그인 설정
        http.formLogin((formLogin) -> formLogin.loginPage("/login")
                .defaultSuccessUrl("/") // 성공 시
                .failureUrl("/fail") // 실패 시
        );

        // 로그아웃 설정
        http.logout(logout -> logout.logoutUrl("/logout")
                .logoutSuccessUrl("/") // 성공 시
        );

        return http.build();
    }
}