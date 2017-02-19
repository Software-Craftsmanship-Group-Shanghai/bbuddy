package com.odde.bbuddy.charter.domain;

import com.odde.bbuddy.charter.repo.CarConfig;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CharterCalculatorTest {
    @Test
    public void calculateTest(){
        CarConfigRepository carConfigRepository = mock(CarConfigRepository.class);

        CarConfig config = new CarConfig();
        config.setCarFee(30);
        config.setServiceFee(530);

        when(carConfigRepository.findAll()).thenReturn(Arrays.asList(config));

        CharterCalculator calculator = new CharterCalculator(carConfigRepository);

        assertThat(calculator.calculate()).isEqualTo(560);
    }
}