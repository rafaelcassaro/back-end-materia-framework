package com.parcial.framework.services;


import com.parcial.framework.dao.CelularDao;
import com.parcial.framework.entities.Celular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CelularService {

    @Autowired
    private CelularDao dao;

    public List<Celular> findAll(){
        return dao.findAll();
    }

    public Celular save(Celular celular){
        return dao.add(celular);
    }

    public void deleteById(int id){
        dao.deleteById(id);
    }

    public Celular findById(int id){
        return dao.findById(id);
    }

    public void update (Celular celular)  {
        dao.update(celular);
    }


}
