package com.example.bai_tap_1.controller;

import com.example.bai_tap_1.model.EmailInbox;
import com.example.bai_tap_1.service.IEmailInboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailInboxController {
    @Autowired
    private IEmailInboxService emailInboxService;

    @GetMapping("")
    public String showListEmail(Model model) {
        model.addAttribute("stringMap", emailInboxService.getListEmail());
        return "index";
    }

    @PostMapping("showFormEdit")
    public ModelAndView showEmail(@RequestParam(value = "id") Integer id) {
        EmailInbox emailInbox;
        emailInbox = emailInboxService.findId(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("emailinbox", emailInbox);
        modelAndView.addObject("languagesArray", new String[]{"VietNamese", "English", "Japanese", "Chinese"});
        modelAndView.addObject("pagesizeArray", new Integer[]{5, 10, 15, 25, 50, 100});
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editEmail(@ModelAttribute EmailInbox emailInbox, RedirectAttributes redirectAttributes) {
        int id = this.emailInboxService.findIndex(emailInbox.getId());
        this.emailInboxService.editEmail(emailInbox, id);
        return "redirect:/";
    }
}
