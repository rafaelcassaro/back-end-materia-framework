package com.parcial.framework.services;


import com.parcial.framework.bridgeImpl.Produto;
import com.parcial.framework.dao.CelularDao;
import com.parcial.framework.entities.Celular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class CelularService {
    private DecimalFormat formato = new DecimalFormat("#.##");

    @Autowired
    private CelularDao dao;

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

    public List<Celular> findAll(){
        return dao.findAll();
    }

    public Celular save(Celular celular){
        updateImpostoNumberFormat(celular);
        updateTotalNumberFormat(celular);
        updatePrecoNumberFormat(celular);
        return dao.add(celular);
    }

    public void deleteById(int id){
        dao.deleteById(id);
    }

    public Celular findById(int id){
        return dao.findById(id);
    }

    public void update (Celular celular)  {
        updateImpostoNumberFormat(celular);
        updateTotalNumberFormat(celular);
        updatePrecoNumberFormat(celular);
        dao.update(celular);
    }


}
