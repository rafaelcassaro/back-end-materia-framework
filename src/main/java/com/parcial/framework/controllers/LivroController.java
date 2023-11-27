package com.parcial.framework.controllers;

import com.parcial.framework.bridgeImpl.ImpostoICMS;
import com.parcial.framework.bridgeImpl.Produto;
import com.parcial.framework.entities.Livro;
import com.parcial.framework.entities.ScICMS;
import com.parcial.framework.entities.SpICMS;
import com.parcial.framework.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Produto> upadateLivro(@RequestBody Livro livro, @PathVariable int imposto){
        Livro object = service.findById(livro.getId());
        if(object.getId() == 0){
            return ResponseEntity.badRequest().body(object);
        }
        else{
            tipoDoImposto(livro,imposto);
            service.update(livro);
            Livro result = service.findById(object.getId());

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
            return ResponseEntity.created(uri).body(result);
        }
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
