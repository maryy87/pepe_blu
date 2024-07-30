package com.example.pepe.blu.mapper;

import com.example.pepe.blu.dto.request.OrdineFinaleRequest;
import com.example.pepe.blu.dto.OrdineFinaleResponse;
import com.example.pepe.blu.entities.OrdineFinaleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrdineFinaleMapper {


    @Mapping(target ="idOrdine.idOrdine" ,source = "idOrdine")
    @Mapping(target ="idPiatto.idPiatto" ,source = "idPiatto")
    @Mapping(target ="idEmployer.idEmployer" ,source = "idEmployer")
    @Mapping(target ="idBevande.idBevande" ,source = "idBevande")
    @Mapping(target ="numeroDelTavolo.numeroDelTavolo" ,source = "numeroDelTavolo")
    public OrdineFinaleEntity mapOrdineFinaleRequestToOrdineFinaleEntity(OrdineFinaleRequest ordineFinaleRequest);
    public List<OrdineFinaleEntity> mapOrdineFinaleRequestListToOrdineFinaleEntityLIst(List<OrdineFinaleRequest> ordineFinaleRequest);


    @Mapping(target ="idOrdine" ,source = "idOrdine.idOrdine")
    @Mapping(target ="idPiatto" ,source = "idPiatto.idPiatto")
    @Mapping(target ="idEmployer" ,source = "idEmployer.idEmployer")
    @Mapping(target ="idBevande" ,source = "idBevande.idBevande")
    @Mapping(target ="numeroDelTavolo" ,source = "numeroDelTavolo.numeroDelTavolo")
    public OrdineFinaleResponse mapOrdineFinaleEntirtyToOrdineFinaleResponse(OrdineFinaleEntity ordineFinaleEntity);
    public List<OrdineFinaleResponse> mapOrdineFinaleEntirtyListToOrdineFinaleResponseList(List<OrdineFinaleEntity> ordineFinaleEntity);

}
