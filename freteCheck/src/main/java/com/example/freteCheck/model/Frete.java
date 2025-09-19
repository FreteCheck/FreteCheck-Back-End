package com.example.freteCheck.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Frete {

    private String id;
    private String origem;
    private String destino;
    private String descricao;
    private Double valor;
    private String status;
    private String motorista;
    private String telefone;
    private Double rating;
}

