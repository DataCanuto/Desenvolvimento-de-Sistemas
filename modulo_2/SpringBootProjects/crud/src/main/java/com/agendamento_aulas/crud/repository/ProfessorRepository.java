package com.agendamento_aulas.crud.repository;

import com.agendamento_aulas.crud.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
