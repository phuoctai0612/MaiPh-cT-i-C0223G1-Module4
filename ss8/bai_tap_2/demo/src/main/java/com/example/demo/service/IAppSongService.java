package com.example.demo.service;

import com.example.demo.model.AppSong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAppSongService {
    Page<AppSong> findAllByIdFlagDeleteIsFalse(Pageable pageable);
    void create(AppSong appSong);
    void edit(AppSong appSong);
    void delete(AppSong appSong);
    AppSong findAppSongById(int id);
}
