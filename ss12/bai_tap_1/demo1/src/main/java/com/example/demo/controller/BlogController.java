package com.example.demo.controller;


import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getList() {
        return new ResponseEntity<>(iBlogService.findBlogByIdFlagDeleteIsFalse(), HttpStatus.OK);
    }

    @GetMapping("{title}")
    private ResponseEntity<List<Blog>> search(@PathVariable String title) {
        List<Blog> list = new ArrayList<>();
        for (Blog b : iBlogService.findBlogByIdFlagDeleteIsFalse()) {
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                list.add(b);
            }
        }
        if (list.size() == 0) {
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        blog.setTimeStarBlog(LocalDateTime.now());
        iBlogService.createBlog(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/load-more/{count}")
    private ResponseEntity<List<Blog>> pageLimit(@PathVariable int count) {
        return new ResponseEntity<>(this.iBlogService.getBlogLimit(count),HttpStatus.OK);
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


}
