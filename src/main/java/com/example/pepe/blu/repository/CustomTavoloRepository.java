package com.example.pepe.blu.repository;

import com.example.pepe.blu.filters.FiltroTavoloRequest;
import com.example.pepe.blu.entities.TavoloEntity;

import java.util.List;

public interface CustomTavoloRepository {

    public List<TavoloEntity> findTavoloByFiltro(FiltroTavoloRequest filtroTavoloRequest);
}
