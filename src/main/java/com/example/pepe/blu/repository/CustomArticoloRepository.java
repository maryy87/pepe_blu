package com.example.pepe.blu.repository;

import com.example.pepe.blu.dto.request.FiltroArticoloRequest;
import com.example.pepe.blu.entities.ArticoloEntity;

import java.util.List;

public interface CustomArticoloRepository {

    List<ArticoloEntity> findArticoloFiltro(FiltroArticoloRequest filtroArticoloRequest);
}
