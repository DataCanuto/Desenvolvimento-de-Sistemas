package com.cafeteria.projetoweb.caf.controller;
import com.cafeteria.projetoweb.caf.model.Pagamento;
import com.cafeteria.projetoweb.caf.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento")

public class PagamentoController {
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @PostMapping
    public void save(@RequestBody Pagamento pagamento){
        pagamentoRepository.save(pagamento);
    }

    @GetMapping
    public List<Pagamento> listar(){ return pagamentoRepository.findAll();}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        pagamentoRepository.deleteById(id);
    }

}
