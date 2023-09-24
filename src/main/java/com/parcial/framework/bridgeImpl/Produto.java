package com.parcial.framework.bridgeImpl;

import com.parcial.framework.entities.SpICMS;

public abstract class Produto {

    private int id;
    private String nome;
    private double preco;

    protected ImpostoICMS impostoICMS;

    public Produto(){}

    public Produto(int id, String nome, double preco, ImpostoICMS impostoICMS) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.impostoICMS = impostoICMS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco ;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setImpostoICMS(ImpostoICMS impostoICMS) {
        this.impostoICMS = impostoICMS;
    }

    public ImpostoICMS pegarImpostoICMS() {
        return impostoICMS;
    }
}
