package com.odde.bbuddy.charter.controller;

import com.odde.bbuddy.charter.domain.CharterCalculator;
import org.junit.Test;
import org.springframework.ui.Model;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CharterControllerTest {
    @Test
    public void get_result() {
        CharterCalculator calculator = mock(CharterCalculator.class);
        CharterController controller = new CharterController(calculator);
        int feeResult = 530;
        when(calculator.calculate()).thenReturn(feeResult);
        Model model = mock(Model.class);
        controller.feeResult(model);
        verify(model).addAttribute("result", feeResult);
    }
}