package com.example.pepe.blu.repository;

import com.example.pepe.blu.entities.OrdineFinaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdineFinaleRepository extends JpaRepository<OrdineFinaleEntity,Integer> {
}
