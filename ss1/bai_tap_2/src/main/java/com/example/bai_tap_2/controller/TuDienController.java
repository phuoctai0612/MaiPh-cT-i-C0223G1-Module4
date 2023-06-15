package com.example.bai_tap_2.controller;


import com.example.bai_tap_2.service.ITuDienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class TuDienController {
    @Autowired
    private ITuDienService tuDienService;
    @GetMapping("")
    public String tuDien() {
        return "index";
    }

    @GetMapping("tuDienCuaTai")
    public String tuDienTiengViet(@RequestParam String tiengViet, Model model) {
       Map<String, String> stringMap = tuDienService.layTuDien();
        stringMap.put("Thiên tài", "Genius");
        stringMap.put("Tấc nơ", "Bow inch");
        stringMap.put("Căng thẳng", "stress");
        stringMap.put("Target", "Mục tiêu");
        stringMap.put("Ngu", "Stupid");
        for (String s : stringMap.keySet()) {
            if (s.equals(tiengViet)) {
                model.addAttribute("kiTu", stringMap.get(s));
                return "index";
            }
        }
        model.addAttribute("kiTu", "Không có từ này trong từ điển");
        return "index";
    }
}
