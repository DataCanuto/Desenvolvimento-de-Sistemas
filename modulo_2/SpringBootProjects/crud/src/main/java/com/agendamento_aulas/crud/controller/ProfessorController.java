package com.agendamento_aulas.crud.controller;

import com.agendamento_aulas.crud.model.Professor;
import com.agendamento_aulas.crud.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping
    public void salvar(@RequestBody Professor professor){
        professorRepository.save(professor);
    }

    @GetMapping
    public List<Professor> listar(){
        return professorRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        professorRepository.deleteById(id);
    }
}
