package com.example.demo.repository;

import com.example.demo.model.AppSong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppSongRepository extends JpaRepository<AppSong, Integer> {
    Page<AppSong> findAllByIdFlagDeleteIsFalse(Pageable pageable);
}
