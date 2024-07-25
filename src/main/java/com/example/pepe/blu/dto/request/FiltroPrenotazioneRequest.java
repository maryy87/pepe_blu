package com.example.pepe.blu.dto.request;

import com.example.pepe.blu.util.StatoPrenotazione;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiltroPrenotazioneRequest implements Serializable {

    private String nomeCliente;

    private String cognomeCliente;

    private Long numerodiTel;

    private LocalDateTime orario;

    private LocalDateTime orarioMin;

    private LocalDateTime orarioMax;

    private Integer numeroDiPersone;

    private Integer numeroDelTavolo;

    private LocalDateTime dataPrenotazione;

    private StatoPrenotazione statoPrenotazione;
}
