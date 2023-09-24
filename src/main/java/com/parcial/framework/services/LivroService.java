package com.parcial.framework.services;

import com.parcial.framework.dao.LivroDao;
import com.parcial.framework.entities.Bebida;
import com.parcial.framework.entities.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroDao dao;

    public List<Livro> findAll(){
        return dao.findAll();
    }

    public Livro save(Livro livro){
        return dao.add(livro);
    }

    public void deleteById(int id){
        dao.deleteById(id);
    }

    public Livro findById(int id){
        return dao.findById(id);
    }

    public void update (Livro livro)  {
        dao.update(livro);
    }

}
