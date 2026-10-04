package com.cafeteria.projetoweb.caf.controller;

import com.cafeteria.projetoweb.caf.model.ItemPedido;
import com.cafeteria.projetoweb.caf.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itempedido")
public class ItemPedidoController {
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @PostMapping
    public void save(@RequestBody ItemPedido itemPedido){
        itemPedidoRepository.save(itemPedido);
    }
    @GetMapping
    public List<ItemPedido> listar(){
        return itemPedidoRepository.findAll();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        itemPedidoRepository.deleteById(id);
    }
}
