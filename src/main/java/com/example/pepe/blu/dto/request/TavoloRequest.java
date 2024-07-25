package com.example.pepe.blu.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TavoloRequest implements Serializable {


        private String posizioneDelTavolo;

        private Integer numeriDiPosti;

}
