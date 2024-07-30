package com.example.pepe.blu.mapper;

import com.example.pepe.blu.dto.PaymentEmployerResponse;
import com.example.pepe.blu.dto.request.PaymentEmployerRequest;
import com.example.pepe.blu.entities.EmployerEntity;
import com.example.pepe.blu.entities.PaymentEmployerEntity;
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
public class PaymentEmployerMaperrImpl implements PaymentEmployerMaperr {

    @Override
    public PaymentEmployerEntity mapPaymentEmployerRequestToEntity(PaymentEmployerRequest paymentEmployerRequest) {
        if ( paymentEmployerRequest == null ) {
            return null;
        }

        PaymentEmployerEntity paymentEmployerEntity = new PaymentEmployerEntity();

        paymentEmployerEntity.setEmployerEntity( paymentEmployerRequestToEmployerEntity( paymentEmployerRequest ) );
        paymentEmployerEntity.setDataDelPAgamento( paymentEmployerRequest.getDataDelPAgamento() );
        paymentEmployerEntity.setMetodoDiPagamento( paymentEmployerRequest.getMetodoDiPagamento() );
        paymentEmployerEntity.setImportoNetto( paymentEmployerRequest.getImportoNetto() );

        return paymentEmployerEntity;
    }

    @Override
    public List<PaymentEmployerEntity> mapPaymentEmployerRequestListToEntityLIst(List<PaymentEmployerRequest> paymentEmployerRequest) {
        if ( paymentEmployerRequest == null ) {
            return null;
        }

        List<PaymentEmployerEntity> list = new ArrayList<PaymentEmployerEntity>( paymentEmployerRequest.size() );
        for ( PaymentEmployerRequest paymentEmployerRequest1 : paymentEmployerRequest ) {
            list.add( mapPaymentEmployerRequestToEntity( paymentEmployerRequest1 ) );
        }

        return list;
    }

    @Override
    public PaymentEmployerResponse mapPaymentEmployerEntityToResponse(PaymentEmployerEntity paymentEmployerEntity) {
        if ( paymentEmployerEntity == null ) {
            return null;
        }

        PaymentEmployerResponse paymentEmployerResponse = new PaymentEmployerResponse();

        paymentEmployerResponse.setIdEmployer( paymentEmployerEntityEmployerEntityIdEmployer( paymentEmployerEntity ) );
        paymentEmployerResponse.setIdPayment( paymentEmployerEntity.getIdPayment() );
        paymentEmployerResponse.setDataDelPAgamento( paymentEmployerEntity.getDataDelPAgamento() );
        paymentEmployerResponse.setMetodoDiPagamento( paymentEmployerEntity.getMetodoDiPagamento() );
        paymentEmployerResponse.setImportoNetto( paymentEmployerEntity.getImportoNetto() );

        return paymentEmployerResponse;
    }

    @Override
    public List<PaymentEmployerResponse> mapPaymentEmployerEntityListToResponseList(List<PaymentEmployerEntity> paymentEmployerEntity) {
        if ( paymentEmployerEntity == null ) {
            return null;
        }

        List<PaymentEmployerResponse> list = new ArrayList<PaymentEmployerResponse>( paymentEmployerEntity.size() );
        for ( PaymentEmployerEntity paymentEmployerEntity1 : paymentEmployerEntity ) {
            list.add( mapPaymentEmployerEntityToResponse( paymentEmployerEntity1 ) );
        }

        return list;
    }

    protected EmployerEntity paymentEmployerRequestToEmployerEntity(PaymentEmployerRequest paymentEmployerRequest) {
        if ( paymentEmployerRequest == null ) {
            return null;
        }

        EmployerEntity employerEntity = new EmployerEntity();

        employerEntity.setIdEmployer( paymentEmployerRequest.getIdEmployer() );

        return employerEntity;
    }

    private Integer paymentEmployerEntityEmployerEntityIdEmployer(PaymentEmployerEntity paymentEmployerEntity) {
        EmployerEntity employerEntity = paymentEmployerEntity.getEmployerEntity();
        if ( employerEntity == null ) {
            return null;
        }
        return employerEntity.getIdEmployer();
    }
}
