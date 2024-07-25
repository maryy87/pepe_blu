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
@Table(name = "articolo")
public class ArticoloEntity implements Serializable {

    @Id
    @Column(name ="idArticolo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArticolo;

    @Column(name = "Articolo")
    private String articolo;

    @Column(name = "descizioneArticolo")
    private String descizioneArticolo;

    @Column(name = "categoriaArticolo")
    private String categoriaArticolo;

    @Column(name = "quantita")
    private Integer quantita;

    @Column(name = "prezzoArticolo")
    private Integer prezzoArticolo;

    @Column(name = "dataAggiunta")
    private LocalDateTime dataAggiunta;

    @Column(name = "fornitore")
    private String fornitore;

}
