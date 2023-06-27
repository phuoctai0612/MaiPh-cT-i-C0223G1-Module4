package com.example.demo.dto;

import javax.validation.constraints.Pattern;

public class AppSongDto {
    private Integer id;
    @Pattern(regexp = "^(([a-zA-z0-9]){1,10}\\s([a-zA-z0-9]){1,10}){1,40}$",message = "Phải có 1 đến 800 kí tự và không được chứa kí tự đặc biệt")
    private String song;
    @Pattern(regexp = "^^(([a-zA-z0-9]){1,10}\\s([a-zA-z0-9]){1,10}){1,15}$",message = "Phải có 1 đến 300 kí tự và không được chứa kí tự đặc biệt")
    private String artist;
    @Pattern(regexp = "^([a-zA-z0-9]{1,1000},)*[a-zA-z0-9]{1,1000}$",message = "Phải có kí tự")
    private String typeSong;

    public AppSongDto() {
    }

    public AppSongDto(Integer id,String song, String artist, String typeSong) {
        this.id=id;
        this.song = song;
        this.artist = artist;
        this.typeSong = typeSong;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTypeSong() {
        return typeSong;
    }

    public void setTypeSong(String typeSong) {
        this.typeSong = typeSong;
    }
}
