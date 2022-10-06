package com.project.dmsport.global.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dmsport.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@RequiredArgsConstructor
@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .csrf().disable()
                .exceptionHandling()

                .and()
                .headers()
                .frameOptions()
                .sameOrigin()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()

                //user
                .antMatchers(HttpMethod.POST, "/users/mail/duplicate").permitAll()
                .antMatchers(HttpMethod.POST, "/users/mail/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/users/mail/verify").permitAll()
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.POST, "/users/auth").permitAll()
                .antMatchers(HttpMethod.PUT, "/users/auth").permitAll()
                .antMatchers(HttpMethod.PUT, "/users/auth").permitAll()

                .antMatchers(HttpMethod.POST, "/notice/club").hasAuthority("MANAGER")
                .antMatchers(HttpMethod.POST, "/notice/all").hasAuthority("ADMIN")


                .antMatchers(HttpMethod.PATCH, "/admin/ban").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/admin/users/manager/{user-id}").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/admin/users").hasAnyAuthority("ADMIN")

                .anyRequest().authenticated()

                .and()
                .apply(new FilterConfig(jwtTokenProvider, objectMapper))
                .and().build();

    }
}