package com.example.pepe.blu.dto.request;

import com.example.pepe.blu.util.Intolleranze;
import com.example.pepe.blu.util.TipoPiatto;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PiattoRequest implements Serializable {

        private String nomePiatto;

        private String descrizionePiatto;

        private Double prezzoPiatto;

        private TipoPiatto tipoPiatto;

        private Intolleranze intolleranze;

}
