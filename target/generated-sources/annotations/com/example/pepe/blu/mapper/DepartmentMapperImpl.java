package com.example.pepe.blu.mapper;

import com.example.pepe.blu.dto.DepartmentResponse;
import com.example.pepe.blu.dto.request.DepartmentRequest;
import com.example.pepe.blu.entities.DepartmentEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-30T10:47:12+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentEntity mapDepartmentRequestToEntity(DepartmentRequest departmentRequest) {
        if ( departmentRequest == null ) {
            return null;
        }

        DepartmentEntity departmentEntity = new DepartmentEntity();

        departmentEntity.setNomeDepartment( departmentRequest.getNomeDepartment() );
        departmentEntity.setNumeroDipendenti( departmentRequest.getNumeroDipendenti() );
        departmentEntity.setBudgetDepartment( departmentRequest.getBudgetDepartment() );

        return departmentEntity;
    }

    @Override
    public List<DepartmentEntity> mapDepartmentRequestListToEntityList(List<DepartmentRequest> departmentRequestList) {
        if ( departmentRequestList == null ) {
            return null;
        }

        List<DepartmentEntity> list = new ArrayList<DepartmentEntity>( departmentRequestList.size() );
        for ( DepartmentRequest departmentRequest : departmentRequestList ) {
            list.add( mapDepartmentRequestToEntity( departmentRequest ) );
        }

        return list;
    }

    @Override
    public DepartmentResponse mapDepartmentEntityToResponse(DepartmentEntity departmentEntity) {
        if ( departmentEntity == null ) {
            return null;
        }

        DepartmentResponse departmentResponse = new DepartmentResponse();

        departmentResponse.setIdDepartment( departmentEntity.getIdDepartment() );
        departmentResponse.setNomeDepartment( departmentEntity.getNomeDepartment() );
        departmentResponse.setNumeroDipendenti( departmentEntity.getNumeroDipendenti() );
        departmentResponse.setBudgetDepartment( departmentEntity.getBudgetDepartment() );

        return departmentResponse;
    }

    @Override
    public List<DepartmentResponse> mapDepartmentEntityListToResponseList(List<DepartmentEntity> departmentEntityList) {
        if ( departmentEntityList == null ) {
            return null;
        }

        List<DepartmentResponse> list = new ArrayList<DepartmentResponse>( departmentEntityList.size() );
        for ( DepartmentEntity departmentEntity : departmentEntityList ) {
            list.add( mapDepartmentEntityToResponse( departmentEntity ) );
        }

        return list;
    }
}
