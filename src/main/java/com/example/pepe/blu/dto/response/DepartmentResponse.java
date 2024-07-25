package com.example.pepe.blu.dto.response;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponse  implements Serializable {

    private Integer idDepartment;

    private String nomeDepartment;

    private Integer numeroDipendenti;

    private Integer budgetDepartment;

}
