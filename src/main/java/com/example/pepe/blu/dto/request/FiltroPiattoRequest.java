package com.example.pepe.blu.dto.request;

import com.example.pepe.blu.util.Intolleranze;
import com.example.pepe.blu.util.TipoPiatto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiltroPiattoRequest implements Serializable {

    private String nomePiatto;

    private String descrizionePiatto;

    private Double prezzoPiatto;

    private Double prezzoPiattoMin;

    private Double prezzoPiattoMax;

    private TipoPiatto tipoPiatto;

    private Intolleranze intolleranze;
}
