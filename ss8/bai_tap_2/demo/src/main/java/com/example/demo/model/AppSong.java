package com.example.demo.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppSong {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String song;
    private String artist;
    private String typeSong;
  private boolean idFlagDelete;
    public AppSong() {
    }

    public AppSong(Integer id, String song, String artist, String typeSong,boolean idFlagDelete) {
        this.id = id;
        this.song = song;
        this.artist = artist;
        this.typeSong = typeSong;
        this.idFlagDelete=idFlagDelete;
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

    public boolean isIdFlagDelete() {
        return idFlagDelete;
    }

    public void setIdFlagDelete(boolean idFlagDelete) {
        this.idFlagDelete = idFlagDelete;
    }
}
