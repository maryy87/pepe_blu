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
public class ArticoloResponse implements Serializable {


    private Integer idArticolo;

    private String Articolo;

    private String descizioneArticolo;

    private String categoriaArticolo;

    private Integer quantita;

    private Integer prezzoArticolo;

    private LocalDateTime dataAggiunta;

    private String fornitore;
}
