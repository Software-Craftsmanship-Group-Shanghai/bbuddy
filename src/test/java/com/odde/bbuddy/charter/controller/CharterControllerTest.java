package com.odde.bbuddy.charter.controller;

import org.junit.Test;
import org.springframework.ui.Model;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CharterControllerTest {
    @Test
    public void get_result() {
        CharterController controller = new CharterController();
        Model model = mock(Model.class);
        controller.feeResult(model);
        verify(model).addAttribute("result", 560);
    }
}