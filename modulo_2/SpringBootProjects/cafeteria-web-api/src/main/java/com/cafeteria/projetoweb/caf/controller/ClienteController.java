package com.cafeteria.projetoweb.caf.controller;

import com.cafeteria.projetoweb.caf.model.Cliente;

import com.cafeteria.projetoweb.caf.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")

public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @PostMapping
    public void save(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
    }

    @GetMapping
    public List<Cliente> listar(){ return clienteRepository.findAll();}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        clienteRepository.deleteById(id);
    }



}


