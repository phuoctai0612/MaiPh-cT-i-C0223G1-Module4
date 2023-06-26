package com.example.demo.controller;

import com.example.demo.dto.AppSongDto;
import com.example.demo.model.AppSong;
import com.example.demo.service.IAppSongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("app")
public class AppSongController {
    @Autowired
    private IAppSongService iAppSongService;

    @GetMapping("")
    public String list(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<AppSong> listApp = iAppSongService.findAllByIdFlagDeleteIsFalse(pageable);
        model.addAttribute("listApp", listApp);
        return "list";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("appSong", new AppSongDto());
        return "create";
    }

    @PostMapping("create")
    public String create(@Validated @ModelAttribute AppSongDto appSongDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        AppSong appSong = new AppSong();
        BeanUtils.copyProperties(appSongDto, appSong);
        this.iAppSongService.create(appSong);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/app";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (this.iAppSongService.findAppSongById(id) != null) {
            model.addAttribute("appSong", iAppSongService.findAppSongById(id));
            return "edit";
        } else {
            redirectAttributes.addFlashAttribute("msg", "Không tìm thấy id này");
            return "redirect:/list";
        }
    }

    @PostMapping("edit")
    public String edit(@Validated @ModelAttribute AppSongDto appSongDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        AppSong appSong = new AppSong();
        BeanUtils.copyProperties(appSongDto, appSong);
        this.iAppSongService.edit(appSong);
        redirectAttributes.addFlashAttribute("msg", "Sửa thành công");
        return "redirect:/app";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (iAppSongService.findAppSongById(id) != null) {
            iAppSongService.delete(iAppSongService.findAppSongById(id));
            redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
            return "redirect:/app";
        } else {
            redirectAttributes.addFlashAttribute("msg", "Không tìm thấy Id này");
            return "redirect:/app";
        }
    }
}
