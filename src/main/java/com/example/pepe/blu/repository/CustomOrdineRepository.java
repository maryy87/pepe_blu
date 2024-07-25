package com.example.pepe.blu.repository;

import com.example.pepe.blu.dto.request.FiltroOrdineRequest;
import com.example.pepe.blu.entities.OrdineEntity;
import com.example.pepe.blu.entities.OrdineFinaleEntity;

import java.util.List;

public interface CustomOrdineRepository {

    public List<OrdineFinaleEntity> findOrdineByFiltro(FiltroOrdineRequest filtroOrdineRequest);
}
