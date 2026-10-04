package com.senai.cimatec.controller;

import com.senai.cimatec.model.Usuario;
import com.senai.cimatec.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void salvar(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
    }

    @GetMapping
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }
}
