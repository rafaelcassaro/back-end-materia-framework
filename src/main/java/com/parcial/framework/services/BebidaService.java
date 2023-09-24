package com.parcial.framework.services;


import com.parcial.framework.dao.BebidaDao;
import com.parcial.framework.dao.Daos;
import com.parcial.framework.entities.Bebida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BebidaService {

    @Autowired
    private BebidaDao dao;

    public List<Bebida> findAll(){
        return dao.findAll();
    }

    public Bebida save(Bebida bebida){
        return dao.add(bebida);
    }

    public void deleteById(int id){
        dao.deleteById(id);
    }

    public Bebida findById(int id){
        return dao.findById(id);
    }

    public void update (Bebida bebida)  {
        dao.update(bebida);
    }


}
