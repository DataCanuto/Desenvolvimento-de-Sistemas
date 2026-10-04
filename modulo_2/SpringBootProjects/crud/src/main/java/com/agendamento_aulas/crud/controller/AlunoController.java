package com.agendamento_aulas.crud.controller;

import com.agendamento_aulas.crud.model.Aluno;
import com.agendamento_aulas.crud.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public void salvar(@RequestBody Aluno aluno){
        alunoRepository.save(aluno);
    }

    @GetMapping
    public List<Aluno> listar(){
        return alunoRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        alunoRepository.deleteById(id);
    }
}
