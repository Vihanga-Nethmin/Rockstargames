package com.example.Rockstargames.service.impl;

import com.example.Rockstargames.dto.AuthDto;
import com.example.Rockstargames.dto.AuthResponseDTO;
import com.example.Rockstargames.dto.RegisterDto;
import com.example.Rockstargames.entity.Customer;
import com.example.Rockstargames.entity.Role;
import com.example.Rockstargames.entity.User;
import com.example.Rockstargames.repository.CustomerRepository;
import com.example.Rockstargames.repository.UserRepository;
import com.example.Rockstargames.service.UserService;
import com.example.Rockstargames.utill.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public String saveUser(RegisterDto registerDTO) {
        if (userRepository.findByUsername(registerDTO.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already in use");
        }
        if (userRepository.findByEmail(registerDTO.getEmail()).isPresent()) {
            throw new IllegalStateException("Email is already in use");
        }
        User user = User.builder()
                .username(registerDTO.getUsername())
                .email(registerDTO.getEmail())
                .password(passwordEncoder.encode(registerDTO.getPassword()))
                .role(Role.valueOf(registerDTO.getRole()))
                .build();
        userRepository.save(user);
        return "User registered successfully";
    }

    @Override
    public AuthResponseDTO authenticate(AuthDto authDTO) {
        String loginInput = authDTO.getUsername();
        String password = authDTO.getPassword();


        Optional<User> userOpt;

        if (loginInput != null && loginInput.contains("@")) {
            userOpt = userRepository.findByEmail(loginInput);
        } else {
            userOpt = userRepository.findByUsername(loginInput);
        }

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (!passwordEncoder.matches(password, user.getPassword())) {
                throw new BadCredentialsException("Wrong password");
            }
            String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
            return new AuthResponseDTO(token);
        }


        Optional<Customer> customerOpt;

        if (loginInput != null && loginInput.contains("@")) {
            customerOpt = customerRepository.findByEmail(loginInput);
        } else {
            customerOpt = customerRepository.findByName(loginInput);
        }

        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();

            boolean passwordMatch;
            if (customer.getPassword().startsWith("$2a$")) {
                passwordMatch = passwordEncoder.matches(password, customer.getPassword());
            } else {
                passwordMatch = password.equals(customer.getPassword());
            }

            if (!passwordMatch) {
                throw new BadCredentialsException("Wrong password");
            }

            String token = jwtUtil.generateToken(customer.getName(), Role.CUSTOMER);
            return new AuthResponseDTO(token);
        }


        throw new UsernameNotFoundException("User not found: " + loginInput);
    }
}