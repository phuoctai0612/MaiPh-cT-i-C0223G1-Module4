package com.example.bai_tap_1.controller;

import com.example.bai_tap_1.dto.UserDto;
import com.example.bai_tap_1.model.User;
import com.example.bai_tap_1.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RequestMapping("user")
@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("")
    public String list(Model model){
        model.addAttribute("userList",iUserService.getList());
        return "list";
    }
    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("userDto",new UserDto());
        return "create";
    }
    @PostMapping("create")
    public String create(@Validated @ModelAttribute UserDto userDto,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){
        if (bindingResult.hasErrors()){
            return "create";
        }
        User userModel=new User();
        BeanUtils.copyProperties(userDto,userModel);
        this.iUserService.createUser(userModel);
        redirectAttributes.addFlashAttribute("msg","Thêm mới thành công");
        return "redirect:/user";
    }
}
