package com.cafeteria.projetoweb.caf.controller;


import com.cafeteria.projetoweb.caf.model.Gerente;
import com.cafeteria.projetoweb.caf.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerente")
public class GerenteController {
    @Autowired
    private GerenteRepository gerenteRepository;
    @PostMapping
    public void save(@RequestBody Gerente gerente){
        gerenteRepository.save(gerente);
    }
    @GetMapping
    public List<Gerente> listar(){ return gerenteRepository.findAll();}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        gerenteRepository.deleteById(id);
    }
}


