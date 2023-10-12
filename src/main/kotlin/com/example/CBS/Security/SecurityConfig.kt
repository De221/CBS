package com.example.CBS.Security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.HttpStatusEntryPoint

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    open fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
                .authorizeHttpRequests { authorizeHttpRequests ->
                    authorizeHttpRequests
                            .requestMatchers("/**").permitAll()
                }
                .cors(({ cors -> cors.disable() }))
                .csrf(({ csrf -> csrf.disable() }))
                .exceptionHandling({ exceptionHandling ->
                    exceptionHandling
                            .accessDeniedPage("/errors/access-denied")
                            .authenticationEntryPoint(HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                })
                .formLogin(withDefaults())
        return http.build()

    }
}
