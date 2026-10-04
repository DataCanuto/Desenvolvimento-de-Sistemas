package com.cafeteria.projetoweb.caf.repository;

import com.cafeteria.projetoweb.caf.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
