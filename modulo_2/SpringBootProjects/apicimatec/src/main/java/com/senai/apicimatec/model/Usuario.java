package com.senai.apicimatec.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "campo obrigatório")
    private String nome;
    @NotBlank(message = "campo obrigatório")
    @Email(message = "email inválido")
    private String email;
    @Min(value = 18, message = "idade minima: 18 anos")
    private int idade;

}
