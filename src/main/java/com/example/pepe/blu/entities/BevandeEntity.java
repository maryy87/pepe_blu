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
@Table(name = "bevande")
public class BevandeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBevande")
    private int idBevande;

    @Column(name = "nomeBevande")
    private String nomeBevande;

    @Column(name = "prezzoBevande")
    private Double prezzoBevande;

    @Column(name = "tipoBevande")
    private String tipoBevande;

    @Column(name = "disponibile")
    private Boolean disponibile;


    @OneToMany(mappedBy = "idBevande")
    private List<OrdineFinaleEntity> ordineFinaleEntityList;
}
