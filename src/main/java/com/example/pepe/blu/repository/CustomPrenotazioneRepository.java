package com.example.pepe.blu.repository;

import com.example.pepe.blu.filters.FiltroPrenotazioneRequest;
import com.example.pepe.blu.entities.PrenotazioneEntity;

import java.util.List;

public interface CustomPrenotazioneRepository {

    public List<PrenotazioneEntity> findByFiltro(FiltroPrenotazioneRequest filtroPrenotazioneRequestRequest);
}
