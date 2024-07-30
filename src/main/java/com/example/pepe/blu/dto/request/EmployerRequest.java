package com.example.pepe.blu.dto.request;

import com.example.pepe.blu.util.Ruolo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployerRequest  implements Serializable {

        private String nomeEmployer;

        private String cognomeEmployer;

        private Integer idDepartment;

        private String stato;

        private Ruolo ruolo;



    }
