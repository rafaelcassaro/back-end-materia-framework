package com.parcial.framework.controllers;

import com.parcial.framework.bridgeImpl.ImpostoICMS;
import com.parcial.framework.bridgeImpl.Produto;
import com.parcial.framework.entities.*;
import com.parcial.framework.services.CelularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.DecimalFormat;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CelularController {

    private DecimalFormat formato = new DecimalFormat("#.##");

    @Autowired
    private CelularService service;

    @GetMapping("/celulares")
    public List<Celular> findAll(){
        return service.findAll();
    }

    @GetMapping("/celulares/{id}")
    public Celular findCelularById(@PathVariable int id){
        return service.findById(id);
    }

    @DeleteMapping("celulares/{id}")
    public void deleteCelular(@PathVariable int id){
        service.deleteById(id);
    }

    @PutMapping("/celulares/editar/{imposto}")
    public ResponseEntity<Produto> upadateCelular(@RequestBody Celular celular, @PathVariable int imposto){
        Celular object = service.findById(celular.getId());
        if(object.getId() == 0){
            return ResponseEntity.badRequest().body(object);
        }
        else{
            tipoDoImposto(celular,imposto);
            int id = celular.getId();


            service.update(celular);
            Celular result = service.findById(id);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
            return ResponseEntity.created(uri).body(result);
        }
    }

    @PostMapping("/celulares/add")
    public Celular addCelular(@RequestBody Celular celular) {
        //celular.setId(0);
       // tipoDoImposto(celular,imposto);
        celular.setImposto(1);
        celular.setTotal(1);
        service.save(celular);
        return celular;
    }

    public void tipoDoImposto(Celular celular, int i){
        if(i == 1){
            ImpostoICMS imp = new SpICMS();
            celular.setImpostoICMS(imp);
            celular.setTotal(celular.pegarImpostoICMS().aplicarImposto(celular.getPreco()));
            celular.setImposto(celular.getTotal()- celular.getPreco());
        }
        else{
            ImpostoICMS imp = new ScICMS();
            celular.setImpostoICMS(imp);
            celular.setTotal(celular.pegarImpostoICMS().aplicarImposto(celular.getPreco()));
            celular.setImposto(celular.getTotal()- celular.getPreco());
        }
    }

}
