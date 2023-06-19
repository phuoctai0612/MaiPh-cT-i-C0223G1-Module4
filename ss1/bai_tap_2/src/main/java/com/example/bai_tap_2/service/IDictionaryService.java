package com.example.bai_tap_2.service;

import java.util.Map;

public interface IDictionaryService {
    Map<String,String> getDictionary();
    String searchDictionary(String dictionary);
}
