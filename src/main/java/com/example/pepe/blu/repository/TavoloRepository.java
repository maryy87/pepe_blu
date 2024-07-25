package com.example.pepe.blu.repository;

import com.example.pepe.blu.entities.TavoloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TavoloRepository extends JpaRepository<TavoloEntity,Integer> {
}
