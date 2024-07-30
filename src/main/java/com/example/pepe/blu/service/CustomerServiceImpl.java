package com.example.pepe.blu.service;

import com.example.pepe.blu.entities.CustomerEntity;
import com.example.pepe.blu.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
@Service
public class CustomerServiceImpl implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //metodo per ricercare un utente con l'email
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //Write logic to fetch customer from DB
        CustomerEntity customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not find with email: " + email));
        return new User(customer.getEmail(), customer.getPassword(), Collections.emptyList());
    }
}

