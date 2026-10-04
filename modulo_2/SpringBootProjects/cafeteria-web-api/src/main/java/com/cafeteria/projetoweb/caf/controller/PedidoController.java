package com.cafeteria.projetoweb.caf.controller;

import com.cafeteria.projetoweb.caf.model.Pedido;
import com.cafeteria.projetoweb.caf.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")

public class PedidoController {
    @Autowired
    private PedidosRepository pedidosRepository;

    @PostMapping
    public void save(@RequestBody Pedido pedido){
        pedidosRepository.save(pedido);
    }

    @GetMapping
    public List<Pedido> listar(){
        return pedidosRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        pedidosRepository.deleteById(id);
    }
}
