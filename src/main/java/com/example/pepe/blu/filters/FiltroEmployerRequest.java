package com.example.pepe.blu.filters;

import com.example.pepe.blu.util.Ruolo;
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
