package com.example.thuc_hanh_2.controller;

import com.example.thuc_hanh_2.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerCalculator {
    @Autowired
    private ICalculatorService iCalculatorService;
        @GetMapping("")
    public String greeting() {
        return "index";
    }

    @PostMapping ("/calculator")
    public String getMoney(@RequestParam Double usd,@RequestParam Double tiGia, Model model) {

        model.addAttribute("usd", iCalculatorService.getMoney(usd,tiGia));
        return "index";
    }
}
