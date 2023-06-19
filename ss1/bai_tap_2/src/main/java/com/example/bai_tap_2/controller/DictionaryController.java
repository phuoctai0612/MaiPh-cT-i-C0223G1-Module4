package com.example.bai_tap_2.controller;


import com.example.bai_tap_2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;
    @GetMapping("")
    public String dictionary() {
        return "index";
    }

    @GetMapping("tuDienCuaTai")
    public String DictionaryVietNamese(@RequestParam String tiengViet, Model model) {
       String check= dictionaryService.searchDictionary(tiengViet);
       if (check!=null){
           model.addAttribute("kiTu",check);

       }else {
           model.addAttribute("kiTu", "Không có từ này trong từ điển");
       }
        return "index";
    }
}
