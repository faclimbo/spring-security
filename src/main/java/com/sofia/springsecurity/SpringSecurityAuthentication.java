package com.sofia.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityAuthentication {


    //SecurityFilterChain  - org.springframework.security.web
    // HttpSecurity - parameter needed
    // authorizeRequests
    // "/demo" and "/demo/one" - no need for authentication
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(
                (req) -> req
                        .antMatchers("/demo", "/demo/one").permitAll()
                        .anyRequest().authenticated()
        ).formLogin();

        return http.build();
    }

    //in-memory authentication
    //InMemoryUserDetailsManager org.springframework.security.provisioning
    //UserDetails- org.springframework.security.core.userdetails
    //User - org.springframework.security.core.userdetails
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        UserDetails userOne = users
                .username("admin1")
                .password("password1")
                .roles("USER")
                .build();

        UserDetails userTwo = users
                .username("admin2")
                .password("password2")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(userOne, userTwo);


    }

}
