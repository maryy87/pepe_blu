package com.example.pepe.blu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tavolo")
public class TavoloEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numeroDelTavolo")
    private Integer numeroDelTavolo;

    @Column(name = "posizioneDelTavolo")
    private String posizioneDelTavolo;

    @Column(name = "numeriDiPosti")
    private Integer numeriDiPosti;


    @OneToMany(mappedBy = "tavoloEntity")
    private List<PrenotazioneEntity> prenotazioneEntity;


    @OneToMany(mappedBy = "numeroDelTavolo")
    private List<OrdineFinaleEntity> ordineFinaleEntityList;
}
