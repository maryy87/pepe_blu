package com.example.pepe.blu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prenotazione")
public class PrenotazioneEntity implements Serializable {

    @Id
    @Column(name = "idPrenotazione")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrenotazione;

    @Column(name = "nomeCliente")
    private String nomeCliente;

    @Column(name = "cognomeCliente")
    private String cognomeCliente;

    @Column(name = "numerodiTel")
    private Long numerodiTel;

    @Column(name = "orario")
    private LocalDateTime orario;

    @Column(name = "numeroDiPersone")
    private Integer numeroDiPersone;

    @ManyToOne
    @JoinColumn(name = "numeroDelTavolo")
    private TavoloEntity tavoloEntity;

    @Column(name = "dataPrenotazione")
    private LocalDateTime dataPrenotazione;

    @Column(name = "statoPrenotazione")
    private String statoPrenotazione;

}
