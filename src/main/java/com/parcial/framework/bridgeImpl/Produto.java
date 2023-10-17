package com.parcial.framework.bridgeImpl;

import com.parcial.framework.entities.SpICMS;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// a interface imposto esta dentro dessa classe em forma de atributo
public abstract class Produto {

    private String nome;
    private double preco;

    //interface imposto
    protected ImpostoICMS impostoICMS;

    public Produto(){}

    public Produto( String nome, double preco, ImpostoICMS impostoICMS) {

        this.nome = nome;
        this.preco = preco;
        this.impostoICMS = impostoICMS;
    }

    public void setPreco(double preco) {

        this.preco = preco;
    }

    public ImpostoICMS pegarImpostoICMS() {

        return impostoICMS;
    }

    public void setImpostoICMS(ImpostoICMS impostoICMS) {
        this.impostoICMS = impostoICMS;
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




}
