package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.IdBookingBook;
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

import java.time.LocalDateTime;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @Autowired
    private IIdBookingBookService iIdBookingBookService;

    @GetMapping("")
    public String list(@PageableDefault(value = 2) Model model, Pageable pageable) {
        Page<Book> bookPage = iBookService.findAllByFlagDeleteIsFalse(pageable);
        model.addAttribute("bookList", bookPage);
        return "view";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (this.iBookService.findBookById(id) != null) {
            this.iBookService.findBookById(id).setFlagDelete(true);
            this.iBookService.delete(iBookService.findBookById(id));
            redirectAttributes.addFlashAttribute("msg", "Xóa thành công");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Không tìm thấy id này");
        }
        return "redirect:/book";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        iBookService.create(book);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/book";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (iBookService.findBookById(id) == null || iBookService.findBookById(id).isFlagDelete()) {
            redirectAttributes.addFlashAttribute("msg", "Không tìm thấy id này");
            return "view";
        } else {
            model.addAttribute("book", iBookService.findBookById(id));
        }
        return "edit";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        iBookService.edit(book);
        redirectAttributes.addFlashAttribute("msg", "Sửa thành công");
        return "redirect:/view";
    }

    @GetMapping("borrow/{id}")
    private String borrow(@PathVariable int id, RedirectAttributes redirectAttributes) {
        int check = iBookService.findBookById(id).getAmount() - 1;
        LocalDateTime localDateTime= LocalDateTime.now();
        int count=0;
        if (check >= 0) {
            iBookService.findBookById(id).setAmount(check);
            iBookService.edit(iBookService.findBookById(id));
            for (IdBookingBook i : iIdBookingBookService.getListBooking(id)) {
                if (!i.isBorrow()) {
                    i.setTimeBooking(localDateTime);
                    iIdBookingBookService.edit(i);
                    redirectAttributes.addFlashAttribute("msg", "Mượn thành công mã " + i.getIdBooking());
                    count++;
                    break;
                }
            }
        }else {
            try {
                throw new Exception("Không đủ số lượng để thuê");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (count==0){
            redirectAttributes.addFlashAttribute("msg", "Đã hết mã");
        }
        return "redirect:/book";
    }
    @GetMapping("return")
    public String returnBook(@RequestParam String idReturn,RedirectAttributes redirectAttributes){
        LocalDateTime localDateTime= LocalDateTime.now();
        if (iIdBookingBookService.findIdBooking(idReturn)!=null && !iIdBookingBookService.findIdBooking(idReturn).isBorrow()){
            iIdBookingBookService.findIdBooking(idReturn).setBorrow(true);
            iIdBookingBookService.edit(iIdBookingBookService.findIdBooking(idReturn));
            iIdBookingBookService.findIdBooking(idReturn).setTimeReturnBook(localDateTime);
            iIdBookingBookService.findIdBooking(idReturn).getBook().setAmount(iIdBookingBookService.findIdBooking(idReturn).getBook().getAmount()+1);
            iIdBookingBookService.edit(iIdBookingBookService.findIdBooking(idReturn));
            redirectAttributes.addFlashAttribute("msg","Trả thành công");
        }else {
            redirectAttributes.addFlashAttribute("msg","Không có mã này");
        }

        return "redirect:/book";
    }
}
