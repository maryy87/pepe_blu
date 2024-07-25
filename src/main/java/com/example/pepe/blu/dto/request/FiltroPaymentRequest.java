package com.example.pepe.blu.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiltroPaymentRequest {


    private Integer idEmployer;

    private LocalDateTime dataDelPAgamento;

    private String metodoDiPagamento;

    private Double importoNetto;

    private Double importoNettoMin;

    private Double importoNettoMax;
}
