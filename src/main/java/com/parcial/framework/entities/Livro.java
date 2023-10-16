package com.parcial.framework.entities;

import com.parcial.framework.bridgeImpl.ImpostoICMS;
import com.parcial.framework.bridgeImpl.Produto;
import jakarta.persistence.*;


public class Livro extends Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String genero;

    public Livro(){}

    public Livro(int id, String nome, double preco, ImpostoICMS impostoICMS) {
        super( nome, preco, impostoICMS);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
