package com.example.pepe.blu.mapper;

import com.example.pepe.blu.dto.TavoloResponse;
import com.example.pepe.blu.dto.request.TavoloRequest;
import com.example.pepe.blu.entities.TavoloEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-30T10:47:13+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class TavoloMapperImpl implements TavoloMapper {

    @Override
    public TavoloEntity mapTavoloRequestToEntity(TavoloRequest tavoloRequest) {
        if ( tavoloRequest == null ) {
            return null;
        }

        TavoloEntity tavoloEntity = new TavoloEntity();

        tavoloEntity.setPosizioneDelTavolo( tavoloRequest.getPosizioneDelTavolo() );
        tavoloEntity.setNumeriDiPosti( tavoloRequest.getNumeriDiPosti() );

        return tavoloEntity;
    }

    @Override
    public List<TavoloEntity> mapTavoloRequestListToEntityList(List<TavoloRequest> tavoloRequest) {
        if ( tavoloRequest == null ) {
            return null;
        }

        List<TavoloEntity> list = new ArrayList<TavoloEntity>( tavoloRequest.size() );
        for ( TavoloRequest tavoloRequest1 : tavoloRequest ) {
            list.add( mapTavoloRequestToEntity( tavoloRequest1 ) );
        }

        return list;
    }

    @Override
    public TavoloResponse mapTavoloEntityToResponse(TavoloEntity tavoloEntity) {
        if ( tavoloEntity == null ) {
            return null;
        }

        TavoloResponse tavoloResponse = new TavoloResponse();

        tavoloResponse.setNumeroDelTavolo( tavoloEntity.getNumeroDelTavolo() );
        tavoloResponse.setPosizioneDelTavolo( tavoloEntity.getPosizioneDelTavolo() );
        tavoloResponse.setNumeriDiPosti( tavoloEntity.getNumeriDiPosti() );

        return tavoloResponse;
    }

    @Override
    public List<TavoloResponse> mapTavoloEntitListyToResponseList(List<TavoloEntity> tavoloEntity) {
        if ( tavoloEntity == null ) {
            return null;
        }

        List<TavoloResponse> list = new ArrayList<TavoloResponse>( tavoloEntity.size() );
        for ( TavoloEntity tavoloEntity1 : tavoloEntity ) {
            list.add( mapTavoloEntityToResponse( tavoloEntity1 ) );
        }

        return list;
    }
}
