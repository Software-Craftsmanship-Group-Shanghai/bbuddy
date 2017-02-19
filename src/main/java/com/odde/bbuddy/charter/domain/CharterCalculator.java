package com.odde.bbuddy.charter.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharterCalculator {
    private final CalculatorConfig calculatorConfig;

    @Autowired
    public CharterCalculator(CalculatorConfig calculatorConfig) {

        this.calculatorConfig = calculatorConfig;
    }

    public int calculate() {
        return calculatorConfig.getCarFee()+calculatorConfig.getServiceFee();
    }
}
