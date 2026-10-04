package com.cafeteria.projetoweb.caf.repository;

import com.cafeteria.projetoweb.caf.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {
}
