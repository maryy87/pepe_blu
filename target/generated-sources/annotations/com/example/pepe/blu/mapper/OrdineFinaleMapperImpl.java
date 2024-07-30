package com.example.pepe.blu.mapper;

import com.example.pepe.blu.dto.OrdineFinaleResponse;
import com.example.pepe.blu.dto.request.OrdineFinaleRequest;
import com.example.pepe.blu.entities.BevandeEntity;
import com.example.pepe.blu.entities.EmployerEntity;
import com.example.pepe.blu.entities.OrdineEntity;
import com.example.pepe.blu.entities.OrdineFinaleEntity;
import com.example.pepe.blu.entities.PiattoEntity;
import com.example.pepe.blu.entities.TavoloEntity;
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
public class OrdineFinaleMapperImpl implements OrdineFinaleMapper {

    @Override
    public OrdineFinaleEntity mapOrdineFinaleRequestToOrdineFinaleEntity(OrdineFinaleRequest ordineFinaleRequest) {
        if ( ordineFinaleRequest == null ) {
            return null;
        }

        OrdineFinaleEntity ordineFinaleEntity = new OrdineFinaleEntity();

        ordineFinaleEntity.setIdOrdine( ordineFinaleRequestToOrdineEntity( ordineFinaleRequest ) );
        ordineFinaleEntity.setIdPiatto( ordineFinaleRequestToPiattoEntity( ordineFinaleRequest ) );
        ordineFinaleEntity.setIdEmployer( ordineFinaleRequestToEmployerEntity( ordineFinaleRequest ) );
        ordineFinaleEntity.setIdBevande( ordineFinaleRequestToBevandeEntity( ordineFinaleRequest ) );
        ordineFinaleEntity.setNumeroDelTavolo( ordineFinaleRequestToTavoloEntity( ordineFinaleRequest ) );

        return ordineFinaleEntity;
    }

    @Override
    public List<OrdineFinaleEntity> mapOrdineFinaleRequestListToOrdineFinaleEntityLIst(List<OrdineFinaleRequest> ordineFinaleRequest) {
        if ( ordineFinaleRequest == null ) {
            return null;
        }

        List<OrdineFinaleEntity> list = new ArrayList<OrdineFinaleEntity>( ordineFinaleRequest.size() );
        for ( OrdineFinaleRequest ordineFinaleRequest1 : ordineFinaleRequest ) {
            list.add( mapOrdineFinaleRequestToOrdineFinaleEntity( ordineFinaleRequest1 ) );
        }

        return list;
    }

    @Override
    public OrdineFinaleResponse mapOrdineFinaleEntirtyToOrdineFinaleResponse(OrdineFinaleEntity ordineFinaleEntity) {
        if ( ordineFinaleEntity == null ) {
            return null;
        }

        OrdineFinaleResponse ordineFinaleResponse = new OrdineFinaleResponse();

        ordineFinaleResponse.setIdOrdine( ordineFinaleEntityIdOrdineIdOrdine( ordineFinaleEntity ) );
        ordineFinaleResponse.setIdPiatto( ordineFinaleEntityIdPiattoIdPiatto( ordineFinaleEntity ) );
        ordineFinaleResponse.setIdEmployer( ordineFinaleEntityIdEmployerIdEmployer( ordineFinaleEntity ) );
        ordineFinaleResponse.setIdBevande( ordineFinaleEntityIdBevandeIdBevande( ordineFinaleEntity ) );
        ordineFinaleResponse.setNumeroDelTavolo( ordineFinaleEntityNumeroDelTavoloNumeroDelTavolo( ordineFinaleEntity ) );
        ordineFinaleResponse.setIdOrdineFinale( ordineFinaleEntity.getIdOrdineFinale() );
        ordineFinaleResponse.setDataOrdine( ordineFinaleEntity.getDataOrdine() );
        ordineFinaleResponse.setPrezzoOrdine( ordineFinaleEntity.getPrezzoOrdine() );

        return ordineFinaleResponse;
    }

    @Override
    public List<OrdineFinaleResponse> mapOrdineFinaleEntirtyListToOrdineFinaleResponseList(List<OrdineFinaleEntity> ordineFinaleEntity) {
        if ( ordineFinaleEntity == null ) {
            return null;
        }

        List<OrdineFinaleResponse> list = new ArrayList<OrdineFinaleResponse>( ordineFinaleEntity.size() );
        for ( OrdineFinaleEntity ordineFinaleEntity1 : ordineFinaleEntity ) {
            list.add( mapOrdineFinaleEntirtyToOrdineFinaleResponse( ordineFinaleEntity1 ) );
        }

        return list;
    }

    protected OrdineEntity ordineFinaleRequestToOrdineEntity(OrdineFinaleRequest ordineFinaleRequest) {
        if ( ordineFinaleRequest == null ) {
            return null;
        }

        OrdineEntity ordineEntity = new OrdineEntity();

        ordineEntity.setIdOrdine( ordineFinaleRequest.getIdOrdine() );

        return ordineEntity;
    }

    protected PiattoEntity ordineFinaleRequestToPiattoEntity(OrdineFinaleRequest ordineFinaleRequest) {
        if ( ordineFinaleRequest == null ) {
            return null;
        }

        PiattoEntity piattoEntity = new PiattoEntity();

        piattoEntity.setIdPiatto( ordineFinaleRequest.getIdPiatto() );

        return piattoEntity;
    }

    protected EmployerEntity ordineFinaleRequestToEmployerEntity(OrdineFinaleRequest ordineFinaleRequest) {
        if ( ordineFinaleRequest == null ) {
            return null;
        }

        EmployerEntity employerEntity = new EmployerEntity();

        employerEntity.setIdEmployer( ordineFinaleRequest.getIdEmployer() );

        return employerEntity;
    }

    protected BevandeEntity ordineFinaleRequestToBevandeEntity(OrdineFinaleRequest ordineFinaleRequest) {
        if ( ordineFinaleRequest == null ) {
            return null;
        }

        BevandeEntity bevandeEntity = new BevandeEntity();

        if ( ordineFinaleRequest.getIdBevande() != null ) {
            bevandeEntity.setIdBevande( ordineFinaleRequest.getIdBevande() );
        }

        return bevandeEntity;
    }

    protected TavoloEntity ordineFinaleRequestToTavoloEntity(OrdineFinaleRequest ordineFinaleRequest) {
        if ( ordineFinaleRequest == null ) {
            return null;
        }

        TavoloEntity tavoloEntity = new TavoloEntity();

        tavoloEntity.setNumeroDelTavolo( ordineFinaleRequest.getNumeroDelTavolo() );

        return tavoloEntity;
    }

    private Integer ordineFinaleEntityIdOrdineIdOrdine(OrdineFinaleEntity ordineFinaleEntity) {
        OrdineEntity idOrdine = ordineFinaleEntity.getIdOrdine();
        if ( idOrdine == null ) {
            return null;
        }
        return idOrdine.getIdOrdine();
    }

    private Integer ordineFinaleEntityIdPiattoIdPiatto(OrdineFinaleEntity ordineFinaleEntity) {
        PiattoEntity idPiatto = ordineFinaleEntity.getIdPiatto();
        if ( idPiatto == null ) {
            return null;
        }
        return idPiatto.getIdPiatto();
    }

    private Integer ordineFinaleEntityIdEmployerIdEmployer(OrdineFinaleEntity ordineFinaleEntity) {
        EmployerEntity idEmployer = ordineFinaleEntity.getIdEmployer();
        if ( idEmployer == null ) {
            return null;
        }
        return idEmployer.getIdEmployer();
    }

    private Integer ordineFinaleEntityIdBevandeIdBevande(OrdineFinaleEntity ordineFinaleEntity) {
        BevandeEntity idBevande = ordineFinaleEntity.getIdBevande();
        if ( idBevande == null ) {
            return null;
        }
        return idBevande.getIdBevande();
    }

    private Integer ordineFinaleEntityNumeroDelTavoloNumeroDelTavolo(OrdineFinaleEntity ordineFinaleEntity) {
        TavoloEntity numeroDelTavolo = ordineFinaleEntity.getNumeroDelTavolo();
        if ( numeroDelTavolo == null ) {
            return null;
        }
        return numeroDelTavolo.getNumeroDelTavolo();
    }
}
