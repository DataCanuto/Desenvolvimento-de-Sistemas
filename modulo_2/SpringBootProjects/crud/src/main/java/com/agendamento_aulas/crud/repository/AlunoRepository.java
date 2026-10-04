package com.agendamento_aulas.crud.repository;

import com.agendamento_aulas.crud.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
