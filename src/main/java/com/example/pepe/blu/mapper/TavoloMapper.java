package com.example.pepe.blu.mapper;

import com.example.pepe.blu.dto.request.ArticoloRequest;
import com.example.pepe.blu.dto.request.TavoloRequest;
import com.example.pepe.blu.dto.response.ArticoloResponse;
import com.example.pepe.blu.dto.response.TavoloResponse;
import com.example.pepe.blu.entities.ArticoloEntity;
import com.example.pepe.blu.entities.TavoloEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TavoloMapper {


    public TavoloEntity mapTavoloRequestToEntity(TavoloRequest tavoloRequest);
    public List<TavoloEntity> mapTavoloRequestListToEntityList(List<TavoloRequest> tavoloRequest);



    public TavoloResponse mapTavoloEntityToResponse(TavoloEntity tavoloEntity);
    public List<TavoloResponse> mapTavoloEntitListyToResponseList(List<TavoloEntity> tavoloEntity);

}
