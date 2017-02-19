package com.odde.bbuddy.charter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/charter")
public class CharterController {

    @GetMapping("/fee_result")
    public String feeResult(Model model) {
        model.addAttribute("result", 560);
        return "/charter/fee_result";
    }
}

