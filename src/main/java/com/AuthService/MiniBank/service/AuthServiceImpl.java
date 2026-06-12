package com.AuthService.MiniBank.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.AuthService.MiniBank.dto.LoginRequest;
import com.AuthService.MiniBank.dto.LoginResponse;
import com.AuthService.MiniBank.dto.RegisterRequest;
import com.AuthService.MiniBank.exception.EmailAlreadyExistsException;
import com.AuthService.MiniBank.model.User;
import com.AuthService.MiniBank.repository.UserRepository;
import com.AuthService.MiniBank.security.JwtUtil;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository userRepository,
            PasswordEncoder passwordEncoder , JwtUtil jwtUtil) {
this.userRepository = userRepository;
this.passwordEncoder = passwordEncoder;
this.jwtUtil = jwtUtil;
}
    
   
    
    

    @Override
    public String register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            
        	throw new EmailAlreadyExistsException(
                    "Email already exists");
        	
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        
        
        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()));
        
        
        user.setRole("USER");

        userRepository.save(user);

        return "User Registered Successfully";
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElse(null);

        if (user == null) {
        	throw new RuntimeException("User not found");
        }

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

        	throw new RuntimeException("Invalid Password");	
        }

        return new LoginResponse(
                jwtUtil.generateToken(
                        user.getEmail(),
                        user.getRole()));
    }
}