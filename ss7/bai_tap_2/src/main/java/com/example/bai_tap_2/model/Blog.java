package com.example.bai_tap_2.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    @Column(columnDefinition = "longtext")
    private String content;
    private String nameBloger;
    private String img;
    private LocalDateTime timeStarBlog;
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;
    private boolean idFlagDelete;
    public Blog() {
    }

    public Blog(String title, String content, String nameBloger,  String img,LocalDateTime timeStarBlog,boolean idFlagDelete) {
        this.title = title;
        this.content = content;
        this.nameBloger = nameBloger;
        this.img=img;
        this.timeStarBlog = timeStarBlog;
        this.idFlagDelete=idFlagDelete;
    }

    public Blog(Integer id, String title, String content, String nameBloger, LocalDateTime timeStarBlog,boolean idFlagDelete) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.nameBloger = nameBloger;
        this.timeStarBlog = timeStarBlog;
        this.idFlagDelete=idFlagDelete;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNameBloger() {
        return nameBloger;
    }

    public void setNameBloger(String name_bloger) {
        this.nameBloger = name_bloger;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isIdFlagDelete() {
        return idFlagDelete;
    }

    public void setIdFlagDelete(boolean idFlagDelete) {
        this.idFlagDelete = idFlagDelete;
    }
}
