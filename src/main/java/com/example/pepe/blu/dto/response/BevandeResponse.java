package com.example.pepe.blu.dto.response;

import com.example.pepe.blu.util.TipoBevande;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BevandeResponse  implements Serializable {

    private int idBevande;

    private String nomeBevande;

    private double prezzoBevande;

    private TipoBevande tipoBevande;

    private Boolean disponibile;


}
