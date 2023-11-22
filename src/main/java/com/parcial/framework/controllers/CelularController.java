package com.parcial.framework.controllers;

import com.parcial.framework.bridgeImpl.ImpostoICMS;
import com.parcial.framework.entities.*;
import com.parcial.framework.services.CelularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CelularController {

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
    public void upadateCelular(@RequestBody Celular celular, @PathVariable int imposto){
        tipoDoImposto(celular,imposto);
        service.update(celular);
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
