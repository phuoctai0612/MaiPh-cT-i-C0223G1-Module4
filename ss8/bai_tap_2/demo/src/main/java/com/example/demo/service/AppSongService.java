package com.example.demo.service;

import com.example.demo.model.AppSong;
import com.example.demo.repository.IAppSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppSongService implements IAppSongService{
    @Autowired
    private IAppSongRepository iAppSongRepository;
    @Override
    public Page<AppSong> findAllByIdFlagDeleteIsFalse(Pageable pageable) {
        return iAppSongRepository.findAllByIdFlagDeleteIsFalse(pageable);
    }

    @Override
    public void create(AppSong appSong) {
        iAppSongRepository.save(appSong);

    }

    @Override
    public void edit(AppSong appSong) {
       iAppSongRepository.save(appSong);
    }

    @Override
    public void delete(AppSong appSong) {
      iAppSongRepository.save(appSong);
    }

    @Override
    public AppSong findAppSongById(int id) {
        return iAppSongRepository.findById(id).orElse(null);
    }
}
