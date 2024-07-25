package com.example.pepe.blu.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiltroOrdineRequest implements Serializable {

    private Integer idOrdine;

    private Integer idPiatto;

    private Integer idEmployer;

    private Integer idBevande;

    private Integer numeroDelTavolo;

    private LocalDateTime dataOrdine;

    private LocalDateTime dataOrdineMin;

    private LocalDateTime dataOrdineMax;

    private Double prezzoOrdine;

    private Double prezzoOrdineMax;

    private Double prezzoOrdineMin;
}
