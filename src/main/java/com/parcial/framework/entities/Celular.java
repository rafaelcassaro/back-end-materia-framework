package com.parcial.framework.entities;

import com.parcial.framework.bridgeImpl.Produto;


public class Celular extends Produto {

    private String marca;

    public Celular(){}

    public Celular(int id, String nome, double preco, double imposto, double total, String marca) {
        super(id, nome, preco, imposto, total);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


}
