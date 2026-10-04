package com.agendamento_aulas.crud.controller;

import com.agendamento_aulas.crud.model.Aula;
import com.agendamento_aulas.crud.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aula")
public class AulaController {
    @Autowired
    private AulaRepository aulaRepository;

    @PostMapping
    public void salvar(@RequestBody Aula aula){
        aulaRepository.save(aula);
    }
    @GetMapping
    public List<Aula> listar(){
        return aulaRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        aulaRepository.deleteById(id);
    }

}
