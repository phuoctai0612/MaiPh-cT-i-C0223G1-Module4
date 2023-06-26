package com.example.demo.dto;

import javax.validation.constraints.Pattern;

public class AppSongDto {
    @Pattern(regexp = "^(a-zA-z0-9){1,800}$")
    private String song;
    @Pattern(regexp = "^(a-zA-z0-9){1,300}$")
    private String artist;
    @Pattern(regexp = "^(a-zA-z0-9,){1,1000}(a-zA-z0-9)$")
    private String typeSong;

    public AppSongDto() {
    }

    public AppSongDto(String song, String artist, String typeSong) {
        this.song = song;
        this.artist = artist;
        this.typeSong = typeSong;
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
