package com.example.pepe.blu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "paymentEmployer")
public class PaymentEmployerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPayment")
    private Integer idPayment;

    @ManyToOne
    @JoinColumn(name = "idEmployer")
    private EmployerEntity employerEntity;

    @Column(name = "dataDelPAgamento")
    private LocalDateTime dataDelPAgamento;

    @Column(name = "metodoDiPagamento")
    private String metodoDiPagamento;

    @Column(name = "importoNetto")
    private Double importoNetto;
}
