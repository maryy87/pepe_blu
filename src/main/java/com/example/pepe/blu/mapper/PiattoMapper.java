package com.example.pepe.blu.mapper;


import com.example.pepe.blu.dto.request.PiattoRequest;
import com.example.pepe.blu.dto.response.ArticoloResponse;
import com.example.pepe.blu.dto.response.PiattoResponse;
import com.example.pepe.blu.entities.ArticoloEntity;
import com.example.pepe.blu.entities.PiattoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PiattoMapper {


    public PiattoEntity mapPiattoRequestToEntity(PiattoRequest piattoRequest);
    public List<PiattoEntity> mapPiattoRequestListToEntityList(List<PiattoRequest> piattoRequest);


    public PiattoResponse mapPiattoEntityToResponse(PiattoEntity piattoEntity);
    public List<PiattoResponse> mapPiattoEntityListToResponseList(List<PiattoEntity> piattoEntity);

}
