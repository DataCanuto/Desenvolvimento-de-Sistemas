package com.agendamento_aulas.crud.repository;

import com.agendamento_aulas.crud.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AulaRepository extends JpaRepository<Aula, Long> {
}
