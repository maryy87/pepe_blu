package com.example.pepe.blu.repository;

import com.example.pepe.blu.entities.PrenotazioneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<PrenotazioneEntity,Integer> {
}
