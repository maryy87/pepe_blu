package com.example.pepe.blu.repository.security;

import com.example.pepe.blu.entities.security.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {


    boolean existsByEmail(String email);

    Optional<CustomerEntity> findByEmail(String email);
}
