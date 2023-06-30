package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("products")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;


    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop","products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action, Model model) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("+")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        } else if (action.equals("-")) {
            cart.decreaseProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/products";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.create(product);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới sản phẩm thành công");
        return "redirect:/products";
    }


}