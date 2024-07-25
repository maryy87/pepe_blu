package com.example.pepe.blu.repository;

import com.example.pepe.blu.dto.request.FiltroEmployerRequest;
import com.example.pepe.blu.entities.EmployerEntity;

import java.util.List;

public interface CustomEmployerRepository {

    public List<EmployerEntity> findByFiltro(FiltroEmployerRequest filtroEmployerRequest);
}
