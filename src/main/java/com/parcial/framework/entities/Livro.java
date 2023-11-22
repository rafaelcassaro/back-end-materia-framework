package com.parcial.framework.entities;

import com.parcial.framework.bridgeImpl.ImpostoICMS;
import com.parcial.framework.bridgeImpl.Produto;
import jakarta.persistence.*;


public class Livro extends Produto {

    private String genero;

    public Livro(){}

    public Livro(int id, String nome, double preco, double imposto, double total, String categoria, String genero) {
        super(id, nome, preco, imposto, total, categoria);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
