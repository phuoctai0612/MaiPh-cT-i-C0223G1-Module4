package com.example.bai_tap_2.controller;

import com.example.bai_tap_2.model.Blog;
import com.example.bai_tap_2.model.Category;
import com.example.bai_tap_2.service.IBlogService;
import com.example.bai_tap_2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String getList(@PageableDefault (sort = "timeStarBlog",direction = Sort.Direction.ASC)Pageable pageable, Model model) {
        model.addAttribute("listCate",iCategoryService.findBlogByIdFlagDeleteIsFalse());
        Page<Blog> blogList = iBlogService.findBlogByIdFlagDeleteIsFalse(pageable);
        model.addAttribute("blogList", blogList);
        return "list";
    }

    @GetMapping("create")
    public String createBlog(Model model) {
        model.addAttribute("listCate",iCategoryService.findBlogByIdFlagDeleteIsFalse());
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @GetMapping("delete/{id}")
    public String deleteBlog(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (iBlogService.findBlogByID(id) != null) {
            iBlogService.findBlogByID(id).setIdFlagDelete(true);
            iBlogService.deleteBlog(iBlogService.findBlogByID(id));
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
        LocalDateTime localDateTime = LocalDateTime.now();
        blog.setTimeStarBlog(localDateTime);
        iBlogService.editBlog(blog);
        return "redirect:/blog";
    }

    @GetMapping("search")
    public String search(@PageableDefault() Pageable pageable,@RequestParam(required = false,defaultValue = "") String name,
                         @RequestParam(required = false,defaultValue = "") String category, Model model) {
        model.addAttribute("listCate",iCategoryService.findBlogByIdFlagDeleteIsFalse());
        model.addAttribute("blogList", iBlogService.getListSearch(name,category,pageable));
        return "list";
    }
}
