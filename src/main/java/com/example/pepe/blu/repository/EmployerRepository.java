package com.example.pepe.blu.repository;

import com.example.pepe.blu.entities.EmployerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<EmployerEntity,Integer> {
}
