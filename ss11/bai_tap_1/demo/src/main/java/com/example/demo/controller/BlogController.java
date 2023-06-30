package com.example.demo.controller;


import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getList() {
        return new ResponseEntity<>(iBlogService.findBlogByIdFlagDeleteIsFalse(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        blog.setTimeStarBlog(LocalDateTime.now());
        iBlogService.createBlog(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable int id) {
        if (iBlogService.findBlogByID(id) != null) {
            iBlogService.findBlogByID(id).setIdFlagDelete(true);
            iBlogService.deleteBlog(iBlogService.findBlogByID(id));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> edit(@PathVariable int id, @RequestBody Blog blog) {
        Blog blog1 = iBlogService.findBlogByID(id);
        if (blog1 != null) {
            iBlogService.findBlogByID(id).setId(id);
            iBlogService.editBlog(blog);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{idCate}")
    private ResponseEntity<List<Blog>> search(@PathVariable int idCate) {
        List<Blog> list = new ArrayList<>();
        for (Blog b : iBlogService.findBlogByIdFlagDeleteIsFalse()) {
            if (b.getCategory().getId().equals(idCate)) {
                list.add(b);
            }
        }
        if (list.size()==0){
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
