package com.odde.bbuddy.charter.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CharterCalculatorTest {
    @Test
    public void calculateTest(){
        CalculatorConfig calculatorConfig = mock(CalculatorConfig.class);
        when(calculatorConfig.getServiceFee()).thenReturn(530);
        when(calculatorConfig.getCarFee()).thenReturn(30);
        CharterCalculator calculator = new CharterCalculator(calculatorConfig);

        assertThat(calculator.calculate()).isEqualTo(560);
    }
}