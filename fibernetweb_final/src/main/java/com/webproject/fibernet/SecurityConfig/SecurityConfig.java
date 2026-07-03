package com.webproject.fibernet.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.webproject.fibernet.Services.EmployeeService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

   @Bean
public SecurityFilterChain filterChain(HttpSecurity http,
        JwtFilter jwtFilter,
        AuthenticationProvider authProvider) throws Exception {

    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/auth/**").permitAll()
            .requestMatchers(
                "/",
                "/index.html",
                "/signup.html",
                "/dashboard.html",
                "/installation.html",
                "/repair-ticket.html",
                "/job-status.html",
                "/stock-list.html",
                "/style.css",
                "/js/**"
            ).permitAll()
            .anyRequest().authenticated()
        )
        .sessionManagement(session ->
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
        .authenticationProvider(authProvider)
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
}

   @Bean
public AuthenticationProvider authenticationProvider(
        EmployeeService employeeService,
        PasswordEncoder encoder) {

    DaoAuthenticationProvider provider =
            new DaoAuthenticationProvider(employeeService);

    provider.setPasswordEncoder(encoder);

    return provider;
}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {

        return configuration.getAuthenticationManager();
    }
}