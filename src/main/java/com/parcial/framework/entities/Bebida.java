package com.parcial.framework.entities;

import com.parcial.framework.bridgeImpl.ImpostoICMS;
import com.parcial.framework.bridgeImpl.Produto;
import jakarta.persistence.*;


public class Bebida extends Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String validade;

    public Bebida(){}

    public Bebida(int id, String nome, double preco, ImpostoICMS impostoICMS, String validade) {
        super( nome, preco, impostoICMS);
        this.id = id;
        this.validade = validade;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
