package com.cafeteria.projetoweb.caf.controller;

import com.cafeteria.projetoweb.caf.model.Funcionario;
import com.cafeteria.projetoweb.caf.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/funcionario")

public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @PostMapping
    public void save(@RequestBody Funcionario funcionario){
        funcionarioRepository.save(funcionario);
    }

    @GetMapping
    public List<Funcionario> listar(){ return funcionarioRepository.findAll();}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        funcionarioRepository.deleteById(id);
    }
}
