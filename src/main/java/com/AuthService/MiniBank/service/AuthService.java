
package com.AuthService.MiniBank.service;



import com.AuthService.MiniBank.dto.LoginRequest;
import com.AuthService.MiniBank.dto.LoginResponse;
import com.AuthService.MiniBank.dto.RegisterRequest;

public interface AuthService {

    String register(RegisterRequest request);

   // String login(LoginRequest request);
    
    LoginResponse login(LoginRequest request);
}