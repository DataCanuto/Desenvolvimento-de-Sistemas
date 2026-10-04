package com.crud.petshop_project.repository;

import com.crud.petshop_project.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepo extends JpaRepository<Endereco, Long> {
}
