package com.example.pepe.blu.repository;

import com.example.pepe.blu.dto.request.FiltroPiattoRequest;
import com.example.pepe.blu.entities.PiattoEntity;

import java.util.List;

public interface CustomPiattoRepository {

    public List<PiattoEntity> findPiattoByFiltro (FiltroPiattoRequest filtroPiattoRequest);
}
