package com.example.pepe.blu.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TavoloResponse implements Serializable {

    private Integer numeroDelTavolo;

    private String posizioneDelTavolo;

    private Integer numeriDiPosti;


}
