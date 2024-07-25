package com.example.pepe.blu.dto.response;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEmployerResponse implements Serializable {

    private Integer idPayment;

    private Integer IdEmployer;

    private LocalDateTime dataDelPAgamento;

    private String metodoDiPagamento;

    private Double importoNetto;
}
