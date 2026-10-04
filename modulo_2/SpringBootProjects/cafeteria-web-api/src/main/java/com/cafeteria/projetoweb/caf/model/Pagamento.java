package com.cafeteria.projetoweb.caf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHoraPagamento;
    private String formaPagamento;
    private String statusPagamento;
    @OneToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;


    @PrePersist
    public void definirDataHora() {
        this.dataHoraPagamento = LocalDateTime.now();
    }


}
