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
@Table(name = "ordineFinale")
public class OrdineFinaleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOrdineFinale")
    private Integer idOrdineFinale;

    @ManyToOne
    @JoinColumn(name = "idOrdine")
    private OrdineEntity idOrdine;

    @ManyToOne
    @JoinColumn(name = "idPiatto")
    private PiattoEntity idPiatto;

    @ManyToOne
    @JoinColumn(name = "idEmployer")
    private EmployerEntity idEmployer;

    @ManyToOne
    @JoinColumn(name = "idBevande")
    private BevandeEntity idBevande;


    @ManyToOne
    @JoinColumn(name = "numeroDelTavolo")
    private TavoloEntity numeroDelTavolo;

    @Column(name = "dataOrdine")
    private LocalDateTime dataOrdine;

    @Column(name = "prezzoOrdine")
    private Double prezzoOrdine;
}
