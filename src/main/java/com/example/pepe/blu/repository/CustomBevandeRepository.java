package com.example.pepe.blu.repository;

import com.example.pepe.blu.dto.request.FiltroBevandeRequest;
import com.example.pepe.blu.entities.BevandeEntity;

import java.util.List;

public interface CustomBevandeRepository {

    public List<BevandeEntity> findBevandeFiltro(FiltroBevandeRequest filtroBevandeRequest);
}
