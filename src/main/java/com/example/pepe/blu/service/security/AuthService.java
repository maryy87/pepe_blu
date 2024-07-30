package com.example.pepe.blu.service.security;

import com.example.pepe.blu.dto.request.security.SignupRequest;

public interface AuthService {

    boolean createCustomer(SignupRequest signupRequest);
}
