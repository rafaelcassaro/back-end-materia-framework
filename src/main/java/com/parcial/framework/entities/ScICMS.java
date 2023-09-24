package com.parcial.framework.entities;

import com.parcial.framework.bridgeImpl.ImpostoICMS;

public class ScICMS implements ImpostoICMS {

    @Override
    public double aplicarImposto(double preco) {
        return preco * 1.17;
    }
}
