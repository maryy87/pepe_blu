package com.example.pepe.blu.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdineFinaleRequest implements  Serializable{

        private Integer idOrdine;

        private Integer idPiatto;

        private Integer idEmployer;

        private Integer idBevande;

        private Integer numeroDelTavolo;

}
