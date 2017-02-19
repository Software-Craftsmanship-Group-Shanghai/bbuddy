package com.odde.bbuddy.charter.controller;

import com.odde.bbuddy.charter.domain.CharterCalculator;
import org.junit.Test;
import org.springframework.ui.Model;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CharterControllerTest {

    private CharterCalculator calculator = mock(CharterCalculator.class);
    private CharterController controller = new CharterController(calculator);
    private Model model = mock(Model.class);

    @Test
    public void get_result() {
        givenCalculatedFeeIs(530);

        controller.feeResult(model);

        verify(model).addAttribute("result", 530);
    }

    private void givenCalculatedFeeIs(int fee) {
        when(calculator.calculate()).thenReturn(fee);
    }
}