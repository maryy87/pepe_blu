package com.example.pepe.blu.repository;

import com.example.pepe.blu.filters.FiltroDepartementRequest;
import com.example.pepe.blu.entities.DepartmentEntity;

import java.util.List;

public interface CustomDepartmentRepository {

    public List<DepartmentEntity> findDepartmentByFiltro(FiltroDepartementRequest filtroDepartementRequest);
}
