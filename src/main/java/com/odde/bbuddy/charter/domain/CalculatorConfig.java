package com.odde.bbuddy.charter.domain;

import org.springframework.stereotype.Component;

@Component
public class CalculatorConfig {


    public int getServiceFee() {
        return 530;
    }

    public int getCarFee() {
        return 30;
    }
}
