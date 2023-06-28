package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.IdBookingBook;
import com.example.demo.repository.IIdBookingBookRepository;
import com.example.demo.service.IBookService;
import com.example.demo.service.IIdBookingBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("booking")
public class IdBookingBookController {
    @Autowired
    private IIdBookingBookService iIdBookingBookService;
    @Autowired
    private IBookService iBookService;

    @GetMapping("")
    public String listLll(Model model) {
        model.addAttribute("idBookList",iIdBookingBookService.getALl());
        return "view_booking";
    }

    @GetMapping("{id}")
    public String list(Model model, @PathVariable int id) {
        List<IdBookingBook> idBookList = iIdBookingBookService.getListBooking(id);
        model.addAttribute("idBookList", idBookList);
        return "view_booking";
    }

    @GetMapping("create/{id}")
    public String create(@PathVariable int id, RedirectAttributes redirectAttributes) {
        Book book = iBookService.findBookById(id);
        long count = Math.round(Math.random() * 99999);
        while (count < 10000) {
            count = Math.round(Math.random() * 99999);
        }
        iIdBookingBookService.create(new IdBookingBook(String.valueOf(count), book));
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công mã " + count);
        return "redirect:/book";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable String id, Model model, RedirectAttributes redirectAttributes) {
        if (iIdBookingBookService.findIdBooking(id) == null) {
            redirectAttributes.addFlashAttribute("msg", "Không tìm thấy id này");
            return "view";
        } else {
            model.addAttribute("book", iIdBookingBookService.findIdBooking(id));
        }
        return "edit";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute IdBookingBook idBookingBook, RedirectAttributes redirectAttributes) {
        iIdBookingBookService.edit(idBookingBook);
        redirectAttributes.addFlashAttribute("msg", "Sửa thành công");
        return "redirect:/view_booking";
    }

}
