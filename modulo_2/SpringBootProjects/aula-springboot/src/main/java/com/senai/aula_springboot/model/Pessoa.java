package com.senai.aula_springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passaporte_id")
    private Passaporte passaporte;

}
