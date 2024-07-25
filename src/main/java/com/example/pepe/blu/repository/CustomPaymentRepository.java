package com.example.pepe.blu.repository;

import com.example.pepe.blu.dto.request.FiltroPaymentRequest;
import com.example.pepe.blu.entities.PaymentEmployerEntity;

import java.util.List;

public interface CustomPaymentRepository {

    public List<PaymentEmployerEntity> findPaymentBYFiltro(FiltroPaymentRequest filtroPaymentRequest);
}
