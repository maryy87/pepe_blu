package com.example.pepe.blu.mapper;

import com.example.pepe.blu.dto.ArticoloResponse;
import com.example.pepe.blu.dto.request.ArticoloRequest;
import com.example.pepe.blu.entities.ArticoloEntity;
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
public class ArticoloMapperImpl implements ArticoloMapper {

    @Override
    public ArticoloEntity mapArticoloRequestToEntity(ArticoloRequest articoloRequest) {
        if ( articoloRequest == null ) {
            return null;
        }

        ArticoloEntity articoloEntity = new ArticoloEntity();

        articoloEntity.setArticolo( articoloRequest.getArticolo() );
        articoloEntity.setDescizioneArticolo( articoloRequest.getDescizioneArticolo() );
        articoloEntity.setCategoriaArticolo( articoloRequest.getCategoriaArticolo() );
        articoloEntity.setQuantita( articoloRequest.getQuantita() );
        articoloEntity.setPrezzoArticolo( articoloRequest.getPrezzoArticolo() );
        articoloEntity.setFornitore( articoloRequest.getFornitore() );

        return articoloEntity;
    }

    @Override
    public List<ArticoloEntity> mapArticoloRequestListToEntityList(List<ArticoloRequest> articoloRequestList) {
        if ( articoloRequestList == null ) {
            return null;
        }

        List<ArticoloEntity> list = new ArrayList<ArticoloEntity>( articoloRequestList.size() );
        for ( ArticoloRequest articoloRequest : articoloRequestList ) {
            list.add( mapArticoloRequestToEntity( articoloRequest ) );
        }

        return list;
    }

    @Override
    public ArticoloResponse mapArticoloEntityToArticoloResponse(ArticoloEntity articoloEntity) {
        if ( articoloEntity == null ) {
            return null;
        }

        ArticoloResponse articoloResponse = new ArticoloResponse();

        articoloResponse.setIdArticolo( articoloEntity.getIdArticolo() );
        articoloResponse.setArticolo( articoloEntity.getArticolo() );
        articoloResponse.setDescizioneArticolo( articoloEntity.getDescizioneArticolo() );
        articoloResponse.setCategoriaArticolo( articoloEntity.getCategoriaArticolo() );
        articoloResponse.setQuantita( articoloEntity.getQuantita() );
        articoloResponse.setPrezzoArticolo( articoloEntity.getPrezzoArticolo() );
        articoloResponse.setDataAggiunta( articoloEntity.getDataAggiunta() );
        articoloResponse.setFornitore( articoloEntity.getFornitore() );

        return articoloResponse;
    }

    @Override
    public List<ArticoloResponse> mapArticoloEntityListToArticoloResponseList(List<ArticoloEntity> articoloEntityList) {
        if ( articoloEntityList == null ) {
            return null;
        }

        List<ArticoloResponse> list = new ArrayList<ArticoloResponse>( articoloEntityList.size() );
        for ( ArticoloEntity articoloEntity : articoloEntityList ) {
            list.add( mapArticoloEntityToArticoloResponse( articoloEntity ) );
        }

        return list;
    }
}
