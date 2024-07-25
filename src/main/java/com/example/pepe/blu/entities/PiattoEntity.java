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
@Table(name = "piatto")
public class PiattoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPiatto")
    private Integer idPiatto;

    @Column(name = "nomePiatto")
    private String nomePiatto;

    @Column(name = "descrizionePiatto")
    private String descrizionePiatto;

    @Column(name = "prezzoPiatto")
    private Double prezzoPiatto;

    @Column(name = "tipoPiatto")
    private String tipoPiatto;

    @Column(name = "intolleranze")
    private String intolleranze;

    @OneToMany(mappedBy = "idPiatto")
    private List<OrdineFinaleEntity> ordineFinaleEntityList;



}
