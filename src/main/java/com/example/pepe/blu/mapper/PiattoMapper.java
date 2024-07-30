package com.example.pepe.blu.mapper;


import com.example.pepe.blu.dto.request.PiattoRequest;
import com.example.pepe.blu.dto.PiattoResponse;
import com.example.pepe.blu.entities.PiattoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PiattoMapper {


    public PiattoEntity mapPiattoRequestToEntity(PiattoRequest piattoRequest);
    public List<PiattoEntity> mapPiattoRequestListToEntityList(List<PiattoRequest> piattoRequest);


    public PiattoResponse mapPiattoEntityToResponse(PiattoEntity piattoEntity);
    public List<PiattoResponse> mapPiattoEntityListToResponseList(List<PiattoEntity> piattoEntity);

}
