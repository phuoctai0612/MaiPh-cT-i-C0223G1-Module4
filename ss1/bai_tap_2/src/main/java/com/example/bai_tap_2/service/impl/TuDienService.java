package com.example.bai_tap_2.service.impl;

import com.example.bai_tap_2.repository.ITuDienRepository;
import com.example.bai_tap_2.repository.impl.TuDienRepository;
import com.example.bai_tap_2.service.ITuDienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TuDienService implements ITuDienService {
    @Autowired
    private ITuDienRepository tuDienRepository;

    @Override
    public Map<String, String> layTuDien() {
        return tuDienRepository.layTuDien();
    }
}
