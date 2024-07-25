package com.example.pepe.blu.mapper;

import com.example.pepe.blu.dto.request.ArticoloRequest;
import com.example.pepe.blu.dto.request.PrenotazioneRequest;
import com.example.pepe.blu.dto.response.ArticoloResponse;
import com.example.pepe.blu.dto.response.PrenotazioneResponse;
import com.example.pepe.blu.entities.ArticoloEntity;
import com.example.pepe.blu.entities.PrenotazioneEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrenotazioneMapper {

    @Mapping(target = "tavoloEntity.numeroDelTavolo",source = "numeroDelTavolo")
    public PrenotazioneEntity mapPrenotazioneRequestToEntity(PrenotazioneRequest prenotazioneRequest);
    public List<PrenotazioneEntity> mapPrenotazioneRequestListToEntityList(List<PrenotazioneRequest> prenotazioneRequest);


    @Mapping(target = "numeroDelTavolo",source = "tavoloEntity.numeroDelTavolo")
    public PrenotazioneResponse mapPrenotazioneEntityToResponse(PrenotazioneEntity prenotazioneEntity);
    public List<PrenotazioneResponse> mapPrenotazioneEntityListToResponseList(List<PrenotazioneEntity> prenotazioneEntity);

}
