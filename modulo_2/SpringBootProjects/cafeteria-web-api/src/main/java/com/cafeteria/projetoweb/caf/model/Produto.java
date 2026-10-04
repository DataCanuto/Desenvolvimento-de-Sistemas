package com.cafeteria.projetoweb.caf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome Obrigatorio")
    private String nome;
    @NotBlank(message = "Descrição")
    private String descricao;
    //@NotBlank(message = "Informe o Preço")
    private Double preco;
    @NotBlank(message = "Informe a Categoria")
    private String categoria;
    private Boolean disponivel;
}
