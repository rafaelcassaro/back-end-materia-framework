package com.parcial.framework.services;

import com.parcial.framework.bridgeImpl.Produto;
import com.parcial.framework.dao.LivroDao;
import com.parcial.framework.entities.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class LivroService {

    private DecimalFormat formato = new DecimalFormat("#.##");

    @Autowired
    private LivroDao dao;


    public List<Livro> findAll(){
        return dao.findAll();
    }

    private void updatePrecoNumberFormat(Produto produto){
        String numeroFormatado = formato.format(produto.getPreco());
        String numeroStringPonto = numeroFormatado.replace(",", ".");
        double valorFinal = Double.parseDouble(numeroStringPonto);
        produto.setPreco(valorFinal);
    }
    private void updateImpostoNumberFormat(Produto produto){
        String numeroFormatado = formato.format(produto.getImposto());
        String numeroStringPonto = numeroFormatado.replace(",", ".");
        double valorFinal = Double.parseDouble(numeroStringPonto);
        produto.setImposto(valorFinal);
    }
    private void updateTotalNumberFormat(Produto produto){
        String numeroFormatado = formato.format(produto.getTotal());
        String numeroStringPonto = numeroFormatado.replace(",", ".");
        double valorFinal = Double.parseDouble(numeroStringPonto);
        produto.setTotal(valorFinal);
    }

    public Livro save(Livro livro){
        updateImpostoNumberFormat(livro);
        updateTotalNumberFormat(livro);
        updatePrecoNumberFormat(livro);
        return dao.add(livro);
    }

    public void deleteById(int id){
        dao.deleteById(id);
    }

    public Livro findById(int id){
        return dao.findById(id);
    }

    public void update (Livro livro)  {
        updateImpostoNumberFormat(livro);
        updateTotalNumberFormat(livro);
        updatePrecoNumberFormat(livro);
        dao.update(livro);
    }

}
