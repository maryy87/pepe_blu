package com.example.pepe.blu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department")
public class DepartmentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDepartment")
    private  Integer idDepartment;

    @Column(name = "nomeDepartment")
    private String nomeDepartment;


    @Column(name = "numeroDipendenti")
    private Integer numeroDipendenti;

    @Column(name = "budgetDepartment")
    private Integer budgetDepartment;

    @OneToMany(mappedBy = "departmentEntity")
    private List<EmployerEntity> employerList;
}
