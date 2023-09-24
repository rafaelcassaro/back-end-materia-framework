package com.parcial.framework.entities;

import com.parcial.framework.bridgeImpl.ImpostoICMS;

public class SpICMS implements ImpostoICMS {

    @Override
    public double aplicarImposto(double preco) {
        return preco * 1.2;
    }
}
