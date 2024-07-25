package com.example.pepe.blu.dto.request;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEmployerRequest implements Serializable {

        private Integer idEmployer;

        private LocalDateTime dataDelPAgamento;

        private String metodoDiPagamento;

        private Double importoNetto;

}
