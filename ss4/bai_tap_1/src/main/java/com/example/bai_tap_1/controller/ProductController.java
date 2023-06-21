package com.example.bai_tap_1.controller;

import com.example.bai_tap_1.model.Product;
import com.example.bai_tap_1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String display(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "/list";
    }

    @GetMapping("create")
    private String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        Product product= productService.findById(id);
        if (product==null){
            redirectAttributes.addFlashAttribute("msg", "Xóa thất bại");
        }else {
            productService.remove(id);
            redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        }
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        if(product == null){
            model.addAttribute("msg","Không tìm thấy id này");
            return "list";
        }else {
            model.addAttribute("product", productService.findById(id));
        }
        return "/edit";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        Product product= productService.findById(id);
        if (product==null){
            model.addAttribute("msg","Không tìm thấy id này");
            return "list";
        }else {
            model.addAttribute("product", productService.findById(id));
        }

        return "/view";
    }

    @GetMapping("/searchProduct")
    public String searchProduct(@RequestParam String search, Model model) {
        List<Product> list = productService.findList(search);
        model.addAttribute("productList", list);
        return "/list";
    }

    @PostMapping("/createProduct")
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        product.setId(productService.findAll().get(productService.findAll().size() - 1).getId() + 1);
        productService.save(product);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/";
    }

    @PostMapping("/editProduct")
    public String editProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("msg", "Sửa thành công");
        return "redirect:/";
    }

}
