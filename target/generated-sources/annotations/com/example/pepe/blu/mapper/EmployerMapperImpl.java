package com.example.pepe.blu.mapper;

import com.example.pepe.blu.dto.EmployerResponse;
import com.example.pepe.blu.dto.request.EmployerRequest;
import com.example.pepe.blu.entities.DepartmentEntity;
import com.example.pepe.blu.entities.EmployerEntity;
import com.example.pepe.blu.util.Ruolo;
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
public class EmployerMapperImpl implements EmployerMapper {

    @Override
    public EmployerEntity mapEmployerRequestToEntity(EmployerRequest employerRequest) {
        if ( employerRequest == null ) {
            return null;
        }

        EmployerEntity employerEntity = new EmployerEntity();

        employerEntity.setDepartmentEntity( employerRequestToDepartmentEntity( employerRequest ) );
        employerEntity.setNomeEmployer( employerRequest.getNomeEmployer() );
        employerEntity.setCognomeEmployer( employerRequest.getCognomeEmployer() );
        employerEntity.setStato( employerRequest.getStato() );
        if ( employerRequest.getRuolo() != null ) {
            employerEntity.setRuolo( employerRequest.getRuolo().name() );
        }

        return employerEntity;
    }

    @Override
    public List<EmployerEntity> mapEmployerRequestListToEntityList(List<EmployerRequest> employerRequestList) {
        if ( employerRequestList == null ) {
            return null;
        }

        List<EmployerEntity> list = new ArrayList<EmployerEntity>( employerRequestList.size() );
        for ( EmployerRequest employerRequest : employerRequestList ) {
            list.add( mapEmployerRequestToEntity( employerRequest ) );
        }

        return list;
    }

    @Override
    public EmployerResponse mapEmployerEntityToResponse(EmployerEntity employerEntity) {
        if ( employerEntity == null ) {
            return null;
        }

        EmployerResponse employerResponse = new EmployerResponse();

        employerResponse.setIdDepartment( employerEntityDepartmentEntityIdDepartment( employerEntity ) );
        employerResponse.setIdEmployer( employerEntity.getIdEmployer() );
        employerResponse.setNomeEmployer( employerEntity.getNomeEmployer() );
        employerResponse.setCognomeEmployer( employerEntity.getCognomeEmployer() );
        employerResponse.setStato( employerEntity.getStato() );
        if ( employerEntity.getRuolo() != null ) {
            employerResponse.setRuolo( Enum.valueOf( Ruolo.class, employerEntity.getRuolo() ) );
        }

        return employerResponse;
    }

    @Override
    public List<EmployerResponse> mapEmployerEntityListToResponseLIst(List<EmployerEntity> employerEntityList) {
        if ( employerEntityList == null ) {
            return null;
        }

        List<EmployerResponse> list = new ArrayList<EmployerResponse>( employerEntityList.size() );
        for ( EmployerEntity employerEntity : employerEntityList ) {
            list.add( mapEmployerEntityToResponse( employerEntity ) );
        }

        return list;
    }

    protected DepartmentEntity employerRequestToDepartmentEntity(EmployerRequest employerRequest) {
        if ( employerRequest == null ) {
            return null;
        }

        DepartmentEntity departmentEntity = new DepartmentEntity();

        departmentEntity.setIdDepartment( employerRequest.getIdDepartment() );

        return departmentEntity;
    }

    private Integer employerEntityDepartmentEntityIdDepartment(EmployerEntity employerEntity) {
        DepartmentEntity departmentEntity = employerEntity.getDepartmentEntity();
        if ( departmentEntity == null ) {
            return null;
        }
        return departmentEntity.getIdDepartment();
    }
}
