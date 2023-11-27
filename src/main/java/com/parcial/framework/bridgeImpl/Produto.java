package com.parcial.framework.bridgeImpl;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.text.DecimalFormat;

// a interface imposto esta dentro dessa classe em forma de atributo
public abstract class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private double preco;
    private double imposto;
    private double total;
    private String categoria;
    private DecimalFormat formato = new DecimalFormat("#.##");


    //interface imposto
    protected ImpostoICMS impostoICMS;

    public Produto() {
    }

    public Produto(int id, String nome, double preco, double imposto, double total, String categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.imposto = imposto;
        this.total = total;
        this.categoria = categoria;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
        String numeroFormatado = formato.format(preco);
        String numeroStringPonto = numeroFormatado.replace(",", ".");
        double valorFinal = Double.parseDouble(numeroStringPonto);
        return valorFinal;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
