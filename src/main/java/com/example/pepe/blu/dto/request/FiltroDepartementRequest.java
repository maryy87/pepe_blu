package com.example.pepe.blu.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiltroDepartementRequest implements Serializable {

    private String nomeDepartment;

    private Integer numeroDipendenti;

    private Integer numeroDipendentiMax;

    private Integer numeroDipendentiMin;

    private Integer budgetDepartment;

    private Integer budgetDepartmentMax;

    private Integer budgetDepartmentMin;
}
