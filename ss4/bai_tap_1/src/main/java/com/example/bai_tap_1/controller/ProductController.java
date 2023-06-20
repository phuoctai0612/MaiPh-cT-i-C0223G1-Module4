package com.example.bai_tap_1.controller;

import com.example.bai_tap_1.model.Product;
import com.example.bai_tap_1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.jar.Attributes;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("")
    public String display(Model model){
        List<Product> productList=productService.findAll();
        model.addAttribute("productList",productList);
        return "/list";
    }
    @GetMapping("create")
    private String create(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id,RedirectAttributes redirectAttributes){
        productService.remove(id);
        redirectAttributes.addFlashAttribute("msg","Xóa thành công");
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id){

    }
    @PostMapping("/createProduct")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        product.setId(productService.findAll().get(productService.findAll().size()-1).getId()+1);
        productService.save(product);
        redirectAttributes.addFlashAttribute("msg","Thêm mới thành công");
        return "redirect:/";
    }

}
