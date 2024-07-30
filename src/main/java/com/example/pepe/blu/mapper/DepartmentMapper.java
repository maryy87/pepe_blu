package com.example.pepe.blu.mapper;

import com.example.pepe.blu.dto.request.DepartmentRequest;
import com.example.pepe.blu.dto.DepartmentResponse;
import com.example.pepe.blu.entities.DepartmentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    public DepartmentEntity mapDepartmentRequestToEntity(DepartmentRequest departmentRequest);
    public List<DepartmentEntity> mapDepartmentRequestListToEntityList(List<DepartmentRequest> departmentRequestList);

    public DepartmentResponse mapDepartmentEntityToResponse(DepartmentEntity departmentEntity);
    public List<DepartmentResponse> mapDepartmentEntityListToResponseList(List<DepartmentEntity> departmentEntityList);

}
