package com.example.pepe.blu.mapper;

import com.example.pepe.blu.dto.request.PaymentEmployerRequest;
import com.example.pepe.blu.dto.PaymentEmployerResponse;
import com.example.pepe.blu.entities.PaymentEmployerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentEmployerMaperr {

    @Mapping(target = "employerEntity.idEmployer",source = "idEmployer")
    public PaymentEmployerEntity mapPaymentEmployerRequestToEntity(PaymentEmployerRequest paymentEmployerRequest);
    public List<PaymentEmployerEntity> mapPaymentEmployerRequestListToEntityLIst(List<PaymentEmployerRequest> paymentEmployerRequest);

    @Mapping(target = "idEmployer",source = "employerEntity.idEmployer")
    public PaymentEmployerResponse mapPaymentEmployerEntityToResponse(PaymentEmployerEntity paymentEmployerEntity);
    public List<PaymentEmployerResponse> mapPaymentEmployerEntityListToResponseList(List<PaymentEmployerEntity> paymentEmployerEntity);

}
