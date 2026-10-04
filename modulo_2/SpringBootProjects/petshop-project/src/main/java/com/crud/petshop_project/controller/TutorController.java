package com.crud.petshop_project.controller;

import com.crud.petshop_project.model.Endereco;
import com.crud.petshop_project.model.Tutor;
import com.crud.petshop_project.repository.EnderecoRepo;
import com.crud.petshop_project.repository.TutorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TutorController {
    @Autowired
    private TutorRepo tutorRepo;

    @PostMapping
    public void save(@RequestBody Tutor tutor){
        tutorRepo.save(tutor);
    }
    @GetMapping
    public List<Tutor> listar(){
        return tutorRepo.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        tutorRepo.deleteById(id);
    }
}
