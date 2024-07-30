package com.example.pepe.blu.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class DepartmentRequest implements Serializable {

        private String nomeDepartment;

        private Integer numeroDipendenti;

        private Integer budgetDepartment;
}
