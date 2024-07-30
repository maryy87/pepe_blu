package com.example.pepe.blu.service;

import com.example.pepe.blu.dto.request.SignupRequest;
import com.example.pepe.blu.entities.CustomerEntity;
import com.example.pepe.blu.repository.CustomerRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{


    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;
    @Autowired
    public AuthServiceImpl(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean createCustomer(SignupRequest signupRequest) {
        //Check if customer already exist
        if (customerRepository.existsByEmail(signupRequest.getEmail())){
            return false;
        }
        CustomerEntity customer = new CustomerEntity();
        BeanUtils.copyProperties(signupRequest, customer);

        //Hash the password before saving
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        customer.setPassword(hashPassword);
        customerRepository.save(customer);
        return true;
    }
}
