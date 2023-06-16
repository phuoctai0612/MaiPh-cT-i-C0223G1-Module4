package com.example.thuc_hanh_1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class SandwichController {
    @GetMapping("")
    public String getListSpice(Model model){
       return "index";
    }
    @PostMapping("getSpice")
    public String getSelectSpice(Model model, @RequestParam(required = false ,value = "spice") String[] spice){
        if (spice!=null){
            model.addAttribute("listSpice",Arrays.toString(spice));
        }else {
            model.addAttribute("message","Bạn ăn lạt à?");
        }
        return "index";
    }

}
