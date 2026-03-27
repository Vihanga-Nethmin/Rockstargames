package com.example.Rockstargames.config;

import com.example.Rockstargames.repository.CustomerRepository;
import com.example.Rockstargames.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {

            var userOpt = userRepository.findByUsername(username);
            if (userOpt.isPresent()) {
                var user = userOpt.get();
                return new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
                );
            }

            var customerOpt = customerRepository.findByName(username);
            if (customerOpt.isPresent()) {
                var customer = customerOpt.get();
                return new org.springframework.security.core.userdetails.User(
                        customer.getName(),
                        customer.getPassword(),
                        List.of(new SimpleGrantedAuthority("ROLE_CUSTOMER"))
                );
            }

            throw new UsernameNotFoundException("User not found: " + username);
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}