package com.example.pepe.blu.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticoloRequest implements Serializable {

        private String articolo;

        private String descizioneArticolo;

        private String categoriaArticolo;

        private Integer quantita;

        private Integer prezzoArticolo;

        private String fornitore;

}
