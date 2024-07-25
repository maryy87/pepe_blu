package com.example.pepe.blu.controller;

import com.example.pepe.blu.dto.request.FiltroPaymentRequest;
import com.example.pepe.blu.dto.request.PaymentEmployerRequest;
import com.example.pepe.blu.dto.response.PaymentEmployerResponse;
import com.example.pepe.blu.service.PaymentEmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/paymentEmployer")
public class PaymentEmployerController {

    @Autowired
    private PaymentEmployerService paymentEmployerService;

    @PostMapping("/ricercaGeneralePayment")
    public ResponseEntity<List<PaymentEmployerResponse>> ricercaGeneralePayment(@RequestBody FiltroPaymentRequest filtroPaymentRequest) {
        List<PaymentEmployerResponse> paymentEmployerResponseList = paymentEmployerService.ricercaPayment(filtroPaymentRequest);
        if (paymentEmployerResponseList != null) {
            return ResponseEntity.ok(paymentEmployerResponseList);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/addPayment")
    public ResponseEntity<PaymentEmployerResponse> addPayment(@RequestBody PaymentEmployerRequest paymentEmployerRequest) {
        PaymentEmployerResponse paymentEmployerResponse = paymentEmployerService.addPayment(paymentEmployerRequest);
        if (paymentEmployerResponse != null) {
            return ResponseEntity.ok(paymentEmployerResponse);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/deletePayment/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable int id) {
        Boolean b = paymentEmployerService.deletePayment(id);
        if (b) {
            return ResponseEntity.ok("payment rimosso");
        }
        return ResponseEntity.ofNullable("payment non esiste");
    }

    @GetMapping("/ricercaPayment/{id}")
    public ResponseEntity<PaymentEmployerResponse> ricercaPayment(@PathVariable int id) {
        PaymentEmployerResponse paymentEmployerResponse = paymentEmployerService.ricercaPayment(id);
        if (paymentEmployerResponse != null) {
            return ResponseEntity.ok(paymentEmployerResponse);
        }
        return ResponseEntity.notFound().build();

    }
}
