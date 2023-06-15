package com.example.thuc_hanh_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerCalculator {
        @GetMapping("")
    public String greeting() {
        return "index";
    }

    @GetMapping("/calculator")
    public String getMoney(@RequestParam Double usd,@RequestParam Double tigia, Model model) {
        model.addAttribute("usd", usd*tigia);
        return "index";
    }
}
