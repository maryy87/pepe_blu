package com.example.pepe.blu.dto.request;

import com.example.pepe.blu.entities.DepartmentEntity;
import com.example.pepe.blu.util.Ruolo;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiltroEmployerRequest implements Serializable {

    private String nomeEmployer;

    private String cognomeEmployer;

    private String nomeDipartimento;

    private String stato;

    private Ruolo ruolo;


}
