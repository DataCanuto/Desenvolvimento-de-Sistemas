package com.senai.cimatec.controller;

import com.senai.cimatec.model.Paciente;
import com.senai.cimatec.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    public void salvar(@RequestBody Paciente paciente){
        pacienteRepository.save(paciente);
    }

    @GetMapping
    public List<Paciente> listar(){
        return pacienteRepository.findAll();
    }
}
