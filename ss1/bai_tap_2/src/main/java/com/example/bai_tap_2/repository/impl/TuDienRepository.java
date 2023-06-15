package com.example.bai_tap_2.repository.impl;

import com.example.bai_tap_2.repository.ITuDienRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
@Repository
public class TuDienRepository implements ITuDienRepository {
    public static HashMap<String, String> hashMap = new LinkedHashMap<>();
    static {
        hashMap.put("Thiên tài", "Genius");
        hashMap.put("Tấc nơ", "Bow inch");
        hashMap.put("Căng thẳng", "stress");
        hashMap.put("Target", "Mục tiêu");
        hashMap.put("Ngu", "Stupid");
    }

    @Override
    public Map<String, String> layTuDien() {
        return hashMap;
    }
}
