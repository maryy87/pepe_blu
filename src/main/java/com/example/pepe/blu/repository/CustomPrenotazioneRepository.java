package com.example.pepe.blu.repository;

import com.example.pepe.blu.dto.request.FiltroPiattoRequest;
import com.example.pepe.blu.dto.request.FiltroPrenotazioneRequest;
import com.example.pepe.blu.entities.PrenotazioneEntity;

import java.util.List;

public interface CustomPrenotazioneRepository {

    public List<PrenotazioneEntity> findByFiltro(FiltroPrenotazioneRequest filtroPrenotazioneRequestRequest);
}
