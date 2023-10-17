package com.parcial.framework.controllers;

import com.parcial.framework.bridgeImpl.ImpostoICMS;
import com.parcial.framework.entities.Bebida;
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
    public Livro findStudentById(@PathVariable int id){

        return service.findById(id);
    }


    @DeleteMapping("livros/{id}")
    public void deleteLivro(@PathVariable int id){
        service.deleteById(id);
    }

    @PutMapping("/livros")
    public void upadateLivro(@RequestBody Livro livro){
        service.update(livro);

    }

    @PostMapping("/livros/{imposto}")
    public Livro addLivro(@RequestBody Livro livro, @PathVariable int imposto) {
        livro.setId(0);
        tipoDoImposto(livro,imposto);
        Livro dbLivro = service.save(livro);
        return dbLivro;
    }

    public void tipoDoImposto(Livro livro, int i){
        if(i == 1){
            ImpostoICMS imp = new SpICMS();
            livro.setImpostoICMS(imp);
        }
        else{
            ImpostoICMS imp = new ScICMS();
            livro.setImpostoICMS(imp);
        }
    }


}
