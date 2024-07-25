package com.example.pepe.blu.mapper;

import com.example.pepe.blu.dto.request.ArticoloRequest;
import com.example.pepe.blu.dto.response.ArticoloResponse;
import com.example.pepe.blu.entities.ArticoloEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticoloMapper {

    public ArticoloEntity mapArticoloRequestToEntity(ArticoloRequest articoloRequest);
    public List<ArticoloEntity> mapArticoloRequestListToEntityList(List<ArticoloRequest> articoloRequestList);

    public ArticoloResponse mapArticoloEntityToArticoloResponse(ArticoloEntity articoloEntity);

    public List<ArticoloResponse> mapArticoloEntityListToArticoloResponseList(List<ArticoloEntity> articoloEntityList);


}
