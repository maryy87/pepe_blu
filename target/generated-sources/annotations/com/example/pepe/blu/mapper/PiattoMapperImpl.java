package com.example.pepe.blu.mapper;

import com.example.pepe.blu.dto.PiattoResponse;
import com.example.pepe.blu.dto.request.PiattoRequest;
import com.example.pepe.blu.entities.PiattoEntity;
import com.example.pepe.blu.util.Intolleranze;
import com.example.pepe.blu.util.TipoPiatto;
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
public class PiattoMapperImpl implements PiattoMapper {

    @Override
    public PiattoEntity mapPiattoRequestToEntity(PiattoRequest piattoRequest) {
        if ( piattoRequest == null ) {
            return null;
        }

        PiattoEntity piattoEntity = new PiattoEntity();

        piattoEntity.setNomePiatto( piattoRequest.getNomePiatto() );
        piattoEntity.setDescrizionePiatto( piattoRequest.getDescrizionePiatto() );
        piattoEntity.setPrezzoPiatto( piattoRequest.getPrezzoPiatto() );
        if ( piattoRequest.getTipoPiatto() != null ) {
            piattoEntity.setTipoPiatto( piattoRequest.getTipoPiatto().name() );
        }
        if ( piattoRequest.getIntolleranze() != null ) {
            piattoEntity.setIntolleranze( piattoRequest.getIntolleranze().name() );
        }

        return piattoEntity;
    }

    @Override
    public List<PiattoEntity> mapPiattoRequestListToEntityList(List<PiattoRequest> piattoRequest) {
        if ( piattoRequest == null ) {
            return null;
        }

        List<PiattoEntity> list = new ArrayList<PiattoEntity>( piattoRequest.size() );
        for ( PiattoRequest piattoRequest1 : piattoRequest ) {
            list.add( mapPiattoRequestToEntity( piattoRequest1 ) );
        }

        return list;
    }

    @Override
    public PiattoResponse mapPiattoEntityToResponse(PiattoEntity piattoEntity) {
        if ( piattoEntity == null ) {
            return null;
        }

        PiattoResponse piattoResponse = new PiattoResponse();

        piattoResponse.setIdPiatto( piattoEntity.getIdPiatto() );
        piattoResponse.setNomePiatto( piattoEntity.getNomePiatto() );
        piattoResponse.setDescrizionePiatto( piattoEntity.getDescrizionePiatto() );
        piattoResponse.setPrezzoPiatto( piattoEntity.getPrezzoPiatto() );
        if ( piattoEntity.getTipoPiatto() != null ) {
            piattoResponse.setTipoPiatto( Enum.valueOf( TipoPiatto.class, piattoEntity.getTipoPiatto() ) );
        }
        if ( piattoEntity.getIntolleranze() != null ) {
            piattoResponse.setIntolleranze( Enum.valueOf( Intolleranze.class, piattoEntity.getIntolleranze() ) );
        }

        return piattoResponse;
    }

    @Override
    public List<PiattoResponse> mapPiattoEntityListToResponseList(List<PiattoEntity> piattoEntity) {
        if ( piattoEntity == null ) {
            return null;
        }

        List<PiattoResponse> list = new ArrayList<PiattoResponse>( piattoEntity.size() );
        for ( PiattoEntity piattoEntity1 : piattoEntity ) {
            list.add( mapPiattoEntityToResponse( piattoEntity1 ) );
        }

        return list;
    }
}
