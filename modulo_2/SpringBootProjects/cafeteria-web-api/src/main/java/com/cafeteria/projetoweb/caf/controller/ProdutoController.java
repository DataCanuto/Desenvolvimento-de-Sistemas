package com.cafeteria.projetoweb.caf.controller;

import com.cafeteria.projetoweb.caf.model.Produto;
import com.cafeteria.projetoweb.caf.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/produto")

public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public void save(@RequestBody Produto produto){
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> listar(){ return produtoRepository.findAll();}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        produtoRepository.deleteById(id);
    }

}
