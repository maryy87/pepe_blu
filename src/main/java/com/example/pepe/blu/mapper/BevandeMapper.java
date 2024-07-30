package com.example.pepe.blu.mapper;

import com.example.pepe.blu.dto.request.BevandeRequest;
import com.example.pepe.blu.dto.BevandeResponse;
import com.example.pepe.blu.entities.BevandeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BevandeMapper {


    public BevandeEntity mapBevandeRequestToEntity(BevandeRequest bevandeRequest);
    public List<BevandeEntity> mapBevandeRequestListToEntityList(List<BevandeRequest> bevandeRequestList);
    public BevandeResponse mapBevandeEntityToResponse(BevandeEntity bevandeEntity);
    public List<BevandeResponse> mapBevandeEntityListToResponseList(List<BevandeEntity> bevandeEntityList);

}
