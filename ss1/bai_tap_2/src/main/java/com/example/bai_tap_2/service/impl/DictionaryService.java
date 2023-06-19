package com.example.bai_tap_2.service.impl;

import com.example.bai_tap_2.repository.IDictionaryRepository;
import com.example.bai_tap_2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {

    @Autowired
    private IDictionaryRepository dictionaryRepository;

    @Override
    public Map<String, String> getDictionary() {
        return dictionaryRepository.getDictionary();
    }

    @Override
    public String searchDictionary(String dictionary) {
        for (String s: dictionaryRepository.getDictionary().keySet()) {
            if (s.equals(dictionary)){
                return dictionaryRepository.getDictionary().get(s);
            }
        }
        return null;
    }
}
