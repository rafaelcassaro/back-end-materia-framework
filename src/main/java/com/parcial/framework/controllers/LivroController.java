package com.parcial.framework.controllers;

import com.parcial.framework.bridgeImpl.ImpostoICMS;
import com.parcial.framework.bridgeImpl.Produto;
import com.parcial.framework.entities.Livro;
import com.parcial.framework.entities.ScICMS;
import com.parcial.framework.entities.SpICMS;
import com.parcial.framework.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping("/livros")
    public List<Livro> findAll(){

        return service.findAll();
    }

    @GetMapping("/livros/{id}")
    public Livro findLivroById(@PathVariable int id){

        return service.findById(id);
    }


    @DeleteMapping("livros/{id}")
    public void deleteLivro(@PathVariable int id){
        service.deleteById(id);
    }

    @PutMapping("/livros/editar/{imposto}")
    public Produto upadateLivro(@RequestBody Livro livro, @PathVariable int imposto){
        tipoDoImposto(livro,imposto);
        service.update(livro);
        int id = livro.getId();
        Livro result = service.findById(id);
        return result;
    }

    @PostMapping("/livros/add")
    public Livro addLivro(@RequestBody Livro livro) {
        livro.setImposto(1);
        livro.setTotal(1);
        service.save(livro);
        return livro;
    }

    public void tipoDoImposto(Livro livro, int i){
        if(i == 1){
            ImpostoICMS imp = new SpICMS();
            livro.setImpostoICMS(imp);
            livro.setTotal(livro.pegarImpostoICMS().aplicarImposto(livro.getPreco()));
            livro.setImposto(livro.getTotal()- livro.getPreco());
        }
        else{
            ImpostoICMS imp = new ScICMS();
            livro.setImpostoICMS(imp);
            livro.setTotal(livro.pegarImpostoICMS().aplicarImposto(livro.getPreco()));
            livro.setImposto(livro.getTotal()- livro.getPreco());
        }
    }


}
