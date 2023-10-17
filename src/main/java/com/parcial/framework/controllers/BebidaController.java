package com.parcial.framework.controllers;

import com.parcial.framework.bridgeImpl.ImpostoICMS;
import com.parcial.framework.entities.*;
import com.parcial.framework.services.BebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BebidaController {

    @Autowired
    private BebidaService service;

    @GetMapping("/bebidas")
    public List<Bebida> findAll(){
        return service.findAll();
    }

    @GetMapping("/bebidas/{id}")
    public Bebida findStudentById(@PathVariable int id){
        //Student student = service.findById(id);

        return service.findById(id);
    }



    @DeleteMapping("bebidas/{id}")
    public void deleteStudent(@PathVariable int id){
        service.deleteById(id);
    }

    @PutMapping("/bebidas")
    public void upadateStudent(@RequestBody Bebida bebida){
        service.update(bebida);

    }

    @PostMapping("/bebidas/{imposto}")
    public Bebida addBebida(@RequestBody Bebida bebida, @PathVariable int imposto) {
        bebida.setId(0);
        tipoDoImposto(bebida,imposto);
        Bebida dbBebida = service.save(bebida);
        return dbBebida;
    }

    public void tipoDoImposto(Bebida bebida, int i){
        if(i == 1){
            ImpostoICMS imp = new SpICMS();
            bebida.setImpostoICMS(imp);
        }
        else{
            ImpostoICMS imp = new ScICMS();
            bebida.setImpostoICMS(imp);
        }
    }

}
