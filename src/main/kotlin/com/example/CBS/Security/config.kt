package com.example.CBS.Security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod


class config
{
//
//    @Configuration
//    @EnableWebSecurity
//    class WebSecurityConfig(userService: UserService, encoder: BCryptPasswordEncoder) {
//        private val userService: UserService
//        private val encoder: BCryptPasswordEncoder
//
//        init {
//            this.userService = userService
//            this.encoder = encoder
//        }
//
//        @Bean
//        @Throws(Exception::class)
//        fun filterChain(http: HttpSecurity): SecurityFilterChain {
//            http
//                    .csrf()
//                    .disable()
//                    .authorizeRequests()
//                    .antMatchers("/offers/{id}/edit", "/offers/{id}/remove", "/offers/create", "/offers/{id}/applications", "/company/{id}/edit").hasAuthority("Company")
//                    .antMatchers(HttpMethod.POST, "/offers/{id}", "/company/{id}").hasAuthority("Company")
//                    .antMatchers("/login", "/register/**", "/offers/", "/offers/{id}", "/", "/company/{id}").permitAll()
//                    .antMatchers("/offers/{id}/**", "/user/{id}/edit").hasAuthority("User")
//                    .antMatchers(HttpMethod.POST, "/user/{id}").hasAuthority("User")
//                    .antMatchers("user/{id}").authenticated()
//                    .and()
//                    .formLogin()
//                    .loginPage("/login")
//                    .loginProcessingUrl("/login")
//                    .and()
//                    .logout()
//                    .invalidateHttpSession(true)
//                    .deleteCookies("JSESSIONID")
//                    .logoutSuccessUrl("/")
//            return http.build()
//        }
//
//        @Bean
//        @Throws(Exception::class)
//        fun authenticationManager(configuration: AuthenticationConfiguration): AuthenticationManager {
//            return configuration.getAuthenticationManager()
//        }
//
//        @Bean
//        fun daoAuthenticationProvider(): DaoAuthenticationProvider {
//            val provider = DaoAuthenticationProvider()
//            provider.setPasswordEncoder(encoder)
//            provider.setUserDetailsService(userService)
//            return provider
//        }
//    }

}