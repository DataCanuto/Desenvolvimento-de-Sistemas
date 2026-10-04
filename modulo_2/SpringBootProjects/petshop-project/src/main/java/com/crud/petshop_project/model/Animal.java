package com.crud.petshop_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="o campo nome deve ser preenchido")
    private String nome;
    @NotBlank(message="o campo especie deve ser preenchido")
    private String especie;
    @NotBlank(message="o campo raca deve ser preenchido")
    private String raca;
    private int idade;
}
