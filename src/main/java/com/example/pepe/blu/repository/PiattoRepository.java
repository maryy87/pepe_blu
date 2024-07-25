package com.example.pepe.blu.repository;

import com.example.pepe.blu.entities.PiattoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PiattoRepository extends JpaRepository<PiattoEntity,Integer> {
}
