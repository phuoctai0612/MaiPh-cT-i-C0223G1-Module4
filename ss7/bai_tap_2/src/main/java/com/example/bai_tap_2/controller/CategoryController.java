package com.example.bai_tap_2.controller;

import com.example.bai_tap_2.model.Category;
import com.example.bai_tap_2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("cate")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String getList(Model model) {
        model.addAttribute("cate", categoryService.findBlogByIdFlagDeleteIsFalse());
        return "list_cate";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes, Model model) {
        if (categoryService.findBlogByID(id) != null) {
            categoryService.findBlogByID(id).setIdFlagDelete(true);
            categoryService.deleteBlog(categoryService.findBlogByID(id));
            model.addAttribute("msg", "Xóa thành công");
        } else {
            model.addAttribute("msg", "Không tìm thấy id này");
        }
        return "redirect:/cate";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("cate",new Category());
        return "create_cate";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Category category, RedirectAttributes redirectAttributes, Model model) {
            categoryService.createBlog(category);
            model.addAttribute("msg", "Thêm mới thành công");
        return "redirect:/cate";
    }

}
