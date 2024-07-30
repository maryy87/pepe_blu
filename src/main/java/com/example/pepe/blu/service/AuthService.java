package com.example.pepe.blu.service;

import com.example.pepe.blu.dto.request.SignupRequest;

public interface AuthService {

    boolean createCustomer(SignupRequest signupRequest);
}
