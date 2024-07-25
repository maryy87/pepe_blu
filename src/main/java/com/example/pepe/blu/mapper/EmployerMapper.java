package com.example.pepe.blu.mapper;

import com.example.pepe.blu.dto.request.DepartmentRequest;
import com.example.pepe.blu.dto.request.EmployerRequest;
import com.example.pepe.blu.dto.response.DepartmentResponse;
import com.example.pepe.blu.dto.response.EmployerResponse;
import com.example.pepe.blu.entities.DepartmentEntity;
import com.example.pepe.blu.entities.EmployerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployerMapper {

    @Mapping(target = "departmentEntity.idDepartment",source = "idDepartment")
    public EmployerEntity mapEmployerRequestToEntity(EmployerRequest employerRequest);
    public List<EmployerEntity> mapEmployerRequestListToEntityList(List<EmployerRequest> employerRequestList);


    @Mapping(target = "idDepartment",source = "departmentEntity.idDepartment")
    public EmployerResponse mapEmployerEntityToResponse(EmployerEntity employerEntity);
    public List<EmployerResponse> mapEmployerEntityListToResponseLIst(List<EmployerEntity> employerEntityList);

}
