package com.example.pepe.blu.dto;

import com.example.pepe.blu.util.Intolleranze;
import com.example.pepe.blu.util.TipoPiatto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PiattoResponse implements Serializable {

    private Integer idPiatto;

    private String nomePiatto;

    private String descrizionePiatto;

    private Double prezzoPiatto;

    private TipoPiatto tipoPiatto;

    private Intolleranze intolleranze;

}
