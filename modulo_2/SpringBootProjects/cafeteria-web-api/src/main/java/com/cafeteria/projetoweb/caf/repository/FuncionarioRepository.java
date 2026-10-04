package com.cafeteria.projetoweb.caf.repository;

import com.cafeteria.projetoweb.caf.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Long>{
}
