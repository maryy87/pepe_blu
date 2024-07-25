package com.example.pepe.blu.repository;

import com.example.pepe.blu.entities.BevandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BevandeRepository extends JpaRepository<BevandeEntity,Integer> {
}
