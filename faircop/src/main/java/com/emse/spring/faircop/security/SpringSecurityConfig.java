//package com.emse.spring.faircop.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//public class SpringSecurityConfig {
//
//    private static final String ROLE_USER = "USER";
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        // We create a password encoder
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(
//                User.withUsername("user").password(encoder.encode("myPassword")).roles(ROLE_USER).build()
//        );
//        return manager;
//    }
//}
