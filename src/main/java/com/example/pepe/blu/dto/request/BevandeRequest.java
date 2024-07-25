package com.example.pepe.blu.dto.request;

import com.example.pepe.blu.util.TipoBevande;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BevandeRequest implements Serializable {

        private String nomeBevande;

        private double prezzoBevande;

        private TipoBevande tipoBevande;

        private Boolean disponibile;


}
