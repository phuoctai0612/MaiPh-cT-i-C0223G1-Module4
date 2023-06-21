package com.example.bai_tap_1.controller;

import com.example.bai_tap_1.model.Product;
import com.example.bai_tap_1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String getList(Model model) {
        model.addAttribute("productList", iProductService.findAll());
        return "/list";
    }

    @GetMapping("/saveProduct")
    public String save(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product, RedirectAttributes model) {
        iProductService.save(product);
        model.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes model) {
        Product product = iProductService.findById(id);
        if (product == null) {
            model.addFlashAttribute("msg", "Xóa thất bại");
        } else {
            iProductService.remove(product);
            model.addFlashAttribute("msg", "Xóa thành công");
        }
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model,RedirectAttributes redirectAttributes) {
        Product product = iProductService.findById(id);
        if (product == null) {
            redirectAttributes.addAttribute("msg", "Không có id này");
            return "redirect:/product";
        } else {
            model.addAttribute("product", product);
        }
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product, RedirectAttributes requestAttribute) {
        iProductService.update(product);
        requestAttribute.addFlashAttribute("msg", "Sửa thành công");
        return "redirect:/product";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Product product = iProductService.findById(id);
        if (product == null) {
            redirectAttributes.addFlashAttribute("msg", "Không có id này");
            return "redirect:/product";
        } else {
            model.addAttribute("product", product);
        }
        return "/view";
    }

    @GetMapping("/searchProduct")
    public String search(@RequestParam String search, Model model) {
        List<Product> productList = iProductService.findList(search);
        model.addAttribute("productList", productList);
        return "/list";
    }
}
