package ro.sda.java64.demo2.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.sda.java64.demo2.model.Book;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BooksController {

    private static final List<Book> books = new ArrayList<>();
    @GetMapping("/create")
    public String showForm(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        return "book_create";
    }

    @PostMapping("/create2")
    public String createBook(@ModelAttribute("book") @Valid Book form, Errors errors, Model model){
        if (errors.hasErrors()){
            return "book_create";
        }
        books.add(form);

        model.addAttribute("books", books);
        return "books";
    }
}
