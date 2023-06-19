package com.example.bai_tap_2.repository.impl;

import com.example.bai_tap_2.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;
@Repository
public class DictionaryRepository implements IDictionaryRepository {
    public static Map<String, String> hashMap = new LinkedHashMap<>();
    static {
        hashMap.put("Thiên tài", "Genius");
        hashMap.put("Tấc nơ", "Bow inch");
        hashMap.put("Căng thẳng", "stress");
        hashMap.put("Target", "Mục tiêu");
        hashMap.put("Ngu", "Stupid");
    }

    @Override
    public Map<String, String> getDictionary() {
        return hashMap;
    }
}
