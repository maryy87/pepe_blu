package com.example.pepe.blu.mapper;

import com.example.pepe.blu.dto.PrenotazioneResponse;
import com.example.pepe.blu.dto.request.PrenotazioneRequest;
import com.example.pepe.blu.entities.PrenotazioneEntity;
import com.example.pepe.blu.entities.TavoloEntity;
import com.example.pepe.blu.util.StatoPrenotazione;
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
public class PrenotazioneMapperImpl implements PrenotazioneMapper {

    @Override
    public PrenotazioneEntity mapPrenotazioneRequestToEntity(PrenotazioneRequest prenotazioneRequest) {
        if ( prenotazioneRequest == null ) {
            return null;
        }

        PrenotazioneEntity prenotazioneEntity = new PrenotazioneEntity();

        prenotazioneEntity.setTavoloEntity( prenotazioneRequestToTavoloEntity( prenotazioneRequest ) );
        prenotazioneEntity.setNomeCliente( prenotazioneRequest.getNomeCliente() );
        prenotazioneEntity.setCognomeCliente( prenotazioneRequest.getCognomeCliente() );
        prenotazioneEntity.setNumerodiTel( prenotazioneRequest.getNumerodiTel() );
        prenotazioneEntity.setOrario( prenotazioneRequest.getOrario() );
        prenotazioneEntity.setNumeroDiPersone( prenotazioneRequest.getNumeroDiPersone() );
        prenotazioneEntity.setDataPrenotazione( prenotazioneRequest.getDataPrenotazione() );
        if ( prenotazioneRequest.getStatoPrenotazione() != null ) {
            prenotazioneEntity.setStatoPrenotazione( prenotazioneRequest.getStatoPrenotazione().name() );
        }

        return prenotazioneEntity;
    }

    @Override
    public List<PrenotazioneEntity> mapPrenotazioneRequestListToEntityList(List<PrenotazioneRequest> prenotazioneRequest) {
        if ( prenotazioneRequest == null ) {
            return null;
        }

        List<PrenotazioneEntity> list = new ArrayList<PrenotazioneEntity>( prenotazioneRequest.size() );
        for ( PrenotazioneRequest prenotazioneRequest1 : prenotazioneRequest ) {
            list.add( mapPrenotazioneRequestToEntity( prenotazioneRequest1 ) );
        }

        return list;
    }

    @Override
    public PrenotazioneResponse mapPrenotazioneEntityToResponse(PrenotazioneEntity prenotazioneEntity) {
        if ( prenotazioneEntity == null ) {
            return null;
        }

        PrenotazioneResponse prenotazioneResponse = new PrenotazioneResponse();

        prenotazioneResponse.setNumeroDelTavolo( prenotazioneEntityTavoloEntityNumeroDelTavolo( prenotazioneEntity ) );
        prenotazioneResponse.setIdPrenotazione( prenotazioneEntity.getIdPrenotazione() );
        prenotazioneResponse.setNomeCliente( prenotazioneEntity.getNomeCliente() );
        prenotazioneResponse.setCognomeCliente( prenotazioneEntity.getCognomeCliente() );
        prenotazioneResponse.setNumerodiTel( prenotazioneEntity.getNumerodiTel() );
        prenotazioneResponse.setOrario( prenotazioneEntity.getOrario() );
        prenotazioneResponse.setNumeroDiPersone( prenotazioneEntity.getNumeroDiPersone() );
        prenotazioneResponse.setDataPrenotazione( prenotazioneEntity.getDataPrenotazione() );
        if ( prenotazioneEntity.getStatoPrenotazione() != null ) {
            prenotazioneResponse.setStatoPrenotazione( Enum.valueOf( StatoPrenotazione.class, prenotazioneEntity.getStatoPrenotazione() ) );
        }

        return prenotazioneResponse;
    }

    @Override
    public List<PrenotazioneResponse> mapPrenotazioneEntityListToResponseList(List<PrenotazioneEntity> prenotazioneEntity) {
        if ( prenotazioneEntity == null ) {
            return null;
        }

        List<PrenotazioneResponse> list = new ArrayList<PrenotazioneResponse>( prenotazioneEntity.size() );
        for ( PrenotazioneEntity prenotazioneEntity1 : prenotazioneEntity ) {
            list.add( mapPrenotazioneEntityToResponse( prenotazioneEntity1 ) );
        }

        return list;
    }

    protected TavoloEntity prenotazioneRequestToTavoloEntity(PrenotazioneRequest prenotazioneRequest) {
        if ( prenotazioneRequest == null ) {
            return null;
        }

        TavoloEntity tavoloEntity = new TavoloEntity();

        tavoloEntity.setNumeroDelTavolo( prenotazioneRequest.getNumeroDelTavolo() );

        return tavoloEntity;
    }

    private Integer prenotazioneEntityTavoloEntityNumeroDelTavolo(PrenotazioneEntity prenotazioneEntity) {
        TavoloEntity tavoloEntity = prenotazioneEntity.getTavoloEntity();
        if ( tavoloEntity == null ) {
            return null;
        }
        return tavoloEntity.getNumeroDelTavolo();
    }
}
