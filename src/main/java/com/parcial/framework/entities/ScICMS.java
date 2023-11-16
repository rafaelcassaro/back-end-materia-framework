package com.parcial.framework.entities;

import com.parcial.framework.bridgeImpl.ImpostoICMS;

//imposto de icms
public class ScICMS implements ImpostoICMS {

    @Override
    public double aplicarImposto(double preco) {
        return preco * 1.17;
    }
}
