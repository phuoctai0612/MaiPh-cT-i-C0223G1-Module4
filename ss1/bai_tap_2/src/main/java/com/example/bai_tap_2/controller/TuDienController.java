package com.example.bai_tap_2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class TuDienController {
    @GetMapping("")
    public String tuDien() {
        return "index";
    }

    @GetMapping("tuDienCuaTai")
    public String tuDienTiengViet(@RequestParam String tiengViet, Model model) {
        HashMap<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("Thiên tài", "Genius");
        hashMap.put("Tấc nơ", "Bow inch");
        hashMap.put("Căng thẳng", "stress");
        hashMap.put("Target", "Mục tiêu");
        hashMap.put("Ngu", "Stupid");
        for (String s : hashMap.keySet()) {
            if (s.equals(tiengViet)) {
                model.addAttribute("kiTu", hashMap.get(s));
                return "index";
            }
        }
        model.addAttribute("kiTu", "Không có từ này trong từ điển");
        return "index";
    }
}
