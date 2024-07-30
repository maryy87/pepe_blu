package com.example.pepe.blu.repository;

import com.example.pepe.blu.filters.FiltroOrdineRequest;
import com.example.pepe.blu.entities.OrdineFinaleEntity;

import java.util.List;

public interface CustomOrdineRepository {

    public List<OrdineFinaleEntity> findOrdineByFiltro(FiltroOrdineRequest filtroOrdineRequest);
}
