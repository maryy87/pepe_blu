package com.example.pepe.blu.dto;

import com.example.pepe.blu.entities.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdineFinaleResponse implements Serializable{

        private Integer idOrdineFinale;

        private Integer idOrdine;

        private Integer idPiatto;

        private Integer idEmployer;

        private Integer idBevande;

        private Integer numeroDelTavolo;

        private LocalDateTime dataOrdine;

        private Double prezzoOrdine;
}
