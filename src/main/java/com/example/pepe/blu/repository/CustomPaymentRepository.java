package com.example.pepe.blu.repository;

import com.example.pepe.blu.filters.FiltroPaymentRequest;
import com.example.pepe.blu.entities.PaymentEmployerEntity;

import java.util.List;

public interface CustomPaymentRepository {

    public List<PaymentEmployerEntity> findPaymentBYFiltro(FiltroPaymentRequest filtroPaymentRequest);
}
