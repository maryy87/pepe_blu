package com.example.pepe.blu.repository;

import com.example.pepe.blu.entities.ArticoloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticoloRepository extends JpaRepository<ArticoloEntity,Integer> {
}
