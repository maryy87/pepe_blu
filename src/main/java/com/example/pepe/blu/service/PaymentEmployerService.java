package com.example.pepe.blu.service;

import com.example.pepe.blu.filters.FiltroPaymentRequest;
import com.example.pepe.blu.repository.CustomPaymentRepository;
import com.example.pepe.blu.repository.PaymentEmployerRepository;
import com.example.pepe.blu.dto.request.PaymentEmployerRequest;
import com.example.pepe.blu.dto.PaymentEmployerResponse;
import com.example.pepe.blu.entities.PaymentEmployerEntity;
import com.example.pepe.blu.mapper.PaymentEmployerMaperr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentEmployerService {

    @Autowired
    private PaymentEmployerRepository paymentEmployerRepository;
    @Autowired
    private PaymentEmployerMaperr paymentEmployerMaperr;
    @Autowired
    private CustomPaymentRepository customPaymentRepository;


    public List<PaymentEmployerResponse> ricercaPayment(FiltroPaymentRequest filtroPaymentRequest) {
        if (filtroPaymentRequest != null) {
            List<PaymentEmployerResponse> paymentEmployerResponseList = paymentEmployerMaperr.mapPaymentEmployerEntityListToResponseList(customPaymentRepository.findPaymentBYFiltro(filtroPaymentRequest));
            return paymentEmployerResponseList;
        }
        return new ArrayList<>();
    }

    public PaymentEmployerResponse addPayment(PaymentEmployerRequest paymentEmployerRequest) {
        PaymentEmployerEntity paymentEmployerEntity = paymentEmployerMaperr.mapPaymentEmployerRequestToEntity(paymentEmployerRequest);
        if (paymentEmployerEntity != null) {
            paymentEmployerEntity.setDataDelPAgamento(LocalDateTime.now());
            PaymentEmployerEntity paymentEmployerEntity1 = paymentEmployerRepository.save(paymentEmployerEntity);
            return paymentEmployerMaperr.mapPaymentEmployerEntityToResponse(paymentEmployerEntity1);
        }
        return null;
    }


    public Boolean deletePayment(int id) {
        if (paymentEmployerRepository.findById(id).isPresent()) {
            paymentEmployerRepository.deleteById(id);
            if (paymentEmployerRepository.findById(id).isPresent()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public PaymentEmployerResponse ricercaPayment(int id) {
        Optional<PaymentEmployerEntity> paymentEmployerEntity = paymentEmployerRepository.findById(id);
        if (paymentEmployerEntity.isPresent()) {
            return paymentEmployerMaperr.mapPaymentEmployerEntityToResponse(paymentEmployerEntity.get());
        }
        return null;
    }


}
