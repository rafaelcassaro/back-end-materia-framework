package com.parcial.framework.entities;

import com.parcial.framework.bridgeImpl.ImpostoICMS;
import com.parcial.framework.bridgeImpl.Produto;

public class Livro extends Produto {

    private String genero;

    public Livro(){}

    public Livro(int id, String nome, double preco, ImpostoICMS impostoICMS) {
        super(id, nome, preco, impostoICMS);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }






}
