package com.crud.petshop_project.controller;

import com.crud.petshop_project.model.Animal;
import com.crud.petshop_project.model.Endereco;
import com.crud.petshop_project.repository.AnimalRepo;
import com.crud.petshop_project.repository.EnderecoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AnimalController {
    @Autowired
    private AnimalRepo animalRepo;

    @PostMapping
    public void save(@RequestBody Animal animal){
        animalRepo.save(animal);
    }
    @GetMapping
    public List<Animal> listar(){
        return animalRepo.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        animalRepo.deleteById(id);
    }




}
