package com.example.pepe.blu.filters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiltroTavoloRequest implements Serializable {


    private String posizioneDelTavolo;

    private Integer numeriDiPosti;

    private Integer numeriDiPostiMin;

    private Integer numeriDiPostiMax;

}
