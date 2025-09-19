package com.example.freteCheck.model;

import lombok.Data;

@Data
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

