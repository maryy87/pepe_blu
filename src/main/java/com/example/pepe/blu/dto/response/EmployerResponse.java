package com.example.pepe.blu.dto.response;

import com.example.pepe.blu.util.Ruolo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerResponse implements Serializable {

    private Integer idEmployer;

    private String nomeEmployer;

    private String cognomeEmployer;

    private Integer idDepartment;

    private String stato;

    private Ruolo ruolo;


}
