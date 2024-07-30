package com.example.pepe.blu.mapper;

import com.example.pepe.blu.dto.BevandeResponse;
import com.example.pepe.blu.dto.request.BevandeRequest;
import com.example.pepe.blu.entities.BevandeEntity;
import com.example.pepe.blu.util.TipoBevande;
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
public class BevandeMapperImpl implements BevandeMapper {

    @Override
    public BevandeEntity mapBevandeRequestToEntity(BevandeRequest bevandeRequest) {
        if ( bevandeRequest == null ) {
            return null;
        }

        BevandeEntity bevandeEntity = new BevandeEntity();

        bevandeEntity.setNomeBevande( bevandeRequest.getNomeBevande() );
        bevandeEntity.setPrezzoBevande( bevandeRequest.getPrezzoBevande() );
        if ( bevandeRequest.getTipoBevande() != null ) {
            bevandeEntity.setTipoBevande( bevandeRequest.getTipoBevande().name() );
        }
        bevandeEntity.setDisponibile( bevandeRequest.getDisponibile() );

        return bevandeEntity;
    }

    @Override
    public List<BevandeEntity> mapBevandeRequestListToEntityList(List<BevandeRequest> bevandeRequestList) {
        if ( bevandeRequestList == null ) {
            return null;
        }

        List<BevandeEntity> list = new ArrayList<BevandeEntity>( bevandeRequestList.size() );
        for ( BevandeRequest bevandeRequest : bevandeRequestList ) {
            list.add( mapBevandeRequestToEntity( bevandeRequest ) );
        }

        return list;
    }

    @Override
    public BevandeResponse mapBevandeEntityToResponse(BevandeEntity bevandeEntity) {
        if ( bevandeEntity == null ) {
            return null;
        }

        BevandeResponse bevandeResponse = new BevandeResponse();

        bevandeResponse.setIdBevande( bevandeEntity.getIdBevande() );
        bevandeResponse.setNomeBevande( bevandeEntity.getNomeBevande() );
        if ( bevandeEntity.getPrezzoBevande() != null ) {
            bevandeResponse.setPrezzoBevande( bevandeEntity.getPrezzoBevande() );
        }
        if ( bevandeEntity.getTipoBevande() != null ) {
            bevandeResponse.setTipoBevande( Enum.valueOf( TipoBevande.class, bevandeEntity.getTipoBevande() ) );
        }
        bevandeResponse.setDisponibile( bevandeEntity.getDisponibile() );

        return bevandeResponse;
    }

    @Override
    public List<BevandeResponse> mapBevandeEntityListToResponseList(List<BevandeEntity> bevandeEntityList) {
        if ( bevandeEntityList == null ) {
            return null;
        }

        List<BevandeResponse> list = new ArrayList<BevandeResponse>( bevandeEntityList.size() );
        for ( BevandeEntity bevandeEntity : bevandeEntityList ) {
            list.add( mapBevandeEntityToResponse( bevandeEntity ) );
        }

        return list;
    }
}
