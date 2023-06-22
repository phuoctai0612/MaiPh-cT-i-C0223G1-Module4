package com.example.bai_tap_1.controller;

import com.example.bai_tap_1.model.Blog;
import com.example.bai_tap_1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public String getList(Model model) {
        List<Blog> blogList = iBlogService.getAllBlog();
        model.addAttribute("blogList", blogList);
        return "list";
    }

    @GetMapping("create")
    public String createBlog(Model model) {

        model.addAttribute("blog", new Blog());
        return "create";
    }

    @GetMapping("delete/{id}")
    public String deleteBlog(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (iBlogService.findBlogByID(id) != null) {
            iBlogService.deleteBlog(id);
            redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Không tìm thấy id này");
        }
        return "redirect:/blog";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        LocalDateTime localDateTime = LocalDateTime.now();
        blog.setTimeStarBlog(localDateTime);
        iBlogService.createBlog(blog);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/blog";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Blog blog = iBlogService.findBlogByID(id);
        if (blog != null) {
            model.addAttribute("blog", blog);
            return "edit";
        } else {
            redirectAttributes.addFlashAttribute("msg", "Không tìm thấy id này");
            return "redirect:/blog";
        }
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute Blog blog) {
        iBlogService.editBlog(blog);
        return "redirect:/blog";
    }

    @GetMapping("search")
    public String search(@RequestParam(required = false,defaultValue = "") String name, Model model) {
        model.addAttribute("blogList", iBlogService.getListSearch(name));
        return "list";
    }
}
