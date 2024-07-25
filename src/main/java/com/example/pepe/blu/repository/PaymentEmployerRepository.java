package com.example.pepe.blu.repository;

import com.example.pepe.blu.entities.PaymentEmployerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentEmployerRepository extends JpaRepository<PaymentEmployerEntity,Integer> {
}
