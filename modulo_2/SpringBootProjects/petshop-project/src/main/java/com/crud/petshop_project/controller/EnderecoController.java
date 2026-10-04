package com.crud.petshop_project.controller;

import com.crud.petshop_project.model.Endereco;
import com.crud.petshop_project.repository.EnderecoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoRepo enderecoRepo;

    @PostMapping
    public void save(@RequestBody Endereco endereco){
        enderecoRepo.save(endereco);
    }
    @GetMapping
    public List<Endereco> listar(){
        return enderecoRepo.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        enderecoRepo.deleteById(id);
    }
}
