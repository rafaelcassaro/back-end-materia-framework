package com.parcial.framework.entities;

import com.parcial.framework.bridgeImpl.ImpostoICMS;
import com.parcial.framework.bridgeImpl.Produto;

public class Bebida extends Produto {

    private String validade;

    public Bebida(){}

    public Bebida(int id, String nome, double preco, ImpostoICMS impostoICMS, String validade) {
        super(id, nome, preco, impostoICMS);
        this.validade = validade;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
}
