package com.example.pepe.blu.dto.request;

import com.example.pepe.blu.util.TipoBevande;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiltroBevandeRequest implements Serializable {


    private String nomeBevande;

    private Double prezzoBevande;

    private Double prezzoBevandeMax;

    private Double prezzoBevandeMin;

    private TipoBevande tipoBevande;

    private Boolean disponibile;
}
