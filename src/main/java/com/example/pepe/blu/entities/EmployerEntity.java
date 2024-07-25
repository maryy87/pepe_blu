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
@Table(name = "employer")
public class EmployerEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmployer")
    private Integer idEmployer;

    @Column(name = "nomeEmployer")
    private String nomeEmployer;

    @Column(name = "cognomeEmployer")
    private String cognomeEmployer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDepartment")
    private DepartmentEntity departmentEntity;


    @Column(name = "stato")
    private String stato;

    @Column(name = "ruolo")
    private String ruolo;


    @OneToMany(mappedBy = "employerEntity")
    private List<PaymentEmployerEntity> paymentEmployerEntityList;


    @OneToMany(mappedBy = "idEmployer")
    private List<OrdineFinaleEntity> ordineFinaleEntityList;
}
