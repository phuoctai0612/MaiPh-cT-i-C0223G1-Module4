package com.example.bai_tap_2.controller;

import com.example.bai_tap_2.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("")
    public String getParam() {
        return "index";
    }

    @PostMapping("/calculation")
    public String getParam(@RequestParam(required = false, value = "calculations") String calculations, @RequestParam(defaultValue = "a", value = "param1") Double param1, @RequestParam(defaultValue = "a", value = "param2") Double param2, Model model) {

        String result = iCalculatorService.calculator(calculations, param1, param2);
        model.addAttribute("result", result);
        return "index";
    }
}
