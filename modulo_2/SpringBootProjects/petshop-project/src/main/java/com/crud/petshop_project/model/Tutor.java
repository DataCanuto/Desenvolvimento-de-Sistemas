package com.crud.petshop_project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="o campo nome deve ser preenchido")
    private String nome;
    @NotBlank(message="o campo cpf deve ser preenchido")
    private String cpf;
    @NotBlank(message="o campo telefone deve ser preenchido")
    private String telefone;
    @Email
    @NotBlank(message="o campo email deve ser preenchido")
    private String email;
    @OneToOne
    @JoinColumn(name="endereco_id")
    private Endereco endereco;
    @OneToMany
    @JoinColumn(name="animal_id")
    private List<Animal> animais;

}
