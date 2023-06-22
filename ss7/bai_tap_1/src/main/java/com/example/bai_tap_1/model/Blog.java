package com.example.bai_tap_1.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String content;
    private String nameBloger;
    private LocalDateTime timeStarBlog;

    public Blog() {
    }

    public Blog(String title, String content, String nameBloger, LocalDateTime timeStarBlog) {
        this.title = title;
        this.content = content;
        this.nameBloger = nameBloger;
        this.timeStarBlog = timeStarBlog;

    }

    public Blog(Integer id, String title, String content, String nameBloger, LocalDateTime timeStarBlog) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.nameBloger = nameBloger;
        this.timeStarBlog = timeStarBlog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimeStarBlog() {
        return timeStarBlog;
    }

    public void setTimeStarBlog(LocalDateTime timeStarBlog) {
        this.timeStarBlog = timeStarBlog;
    }

    public String getNameBloger() {
        return nameBloger;
    }

    public void setNameBloger(String name_bloger) {
        this.nameBloger = name_bloger;
    }
}
