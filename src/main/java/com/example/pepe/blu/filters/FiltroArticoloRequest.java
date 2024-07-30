package com.example.pepe.blu.filters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiltroArticoloRequest implements Serializable {

    private String articolo;
    private String descizioneArticolo;
    private String categoriaArticolo;
    private Integer quantita;
    private Integer prezzoArticolo;
    private Integer prezzoArticoloMin;
    private Integer prezzoArticoloMax;
    private LocalDateTime dataAggiunta;
    private String fornitore;


}
