package com.cafeteria.projetoweb.caf.repository;

import com.cafeteria.projetoweb.caf.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository <Pedido, Long>{
}
