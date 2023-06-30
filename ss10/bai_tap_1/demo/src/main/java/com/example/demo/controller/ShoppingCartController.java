package com.example.demo.controller;

import com.example.demo.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller

public class ShoppingCartController {


    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
    @GetMapping("pay")
    public String payProduct(HttpSession session) {
        session.invalidate();
        return "redirect:/products";
    }
}