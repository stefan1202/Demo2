package ro.sda.java64.demo2.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ro.sda.java64.demo2.entities.BookEntity;
import ro.sda.java64.demo2.model.Book;
import ro.sda.java64.demo2.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/book")
@EnableMethodSecurity
public class BooksController {

    private final BookRepository bookRepository;

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
        BookEntity entity= new BookEntity();
        entity.setAuthor(form.getAuthor());
        entity.setTitle(form.getTitle());
        entity.setIsbn(form.getIsbn());
        entity.setPages(form.getPages());
        entity.setPublisher(form.getPublisher());

        bookRepository.save(entity);

        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }

    @GetMapping("/books")
    public String listBooksByAuthor(@RequestParam String author, Model model){


        model.addAttribute("books", bookRepository.findAllByAuthorStartingWith(author));
        return "books";
    }

    @PostMapping("/create/v1")
//    @Secured("ROLE_admin")
//    @RolesAllowed("admin")
    @PreAuthorize("hasRole('admin')")
    public @ResponseBody BookEntity createBookUsingRestApi(@RequestBody Book form){
        BookEntity entity= new BookEntity();
        entity.setAuthor(form.getAuthor());
        entity.setTitle(form.getTitle());
        entity.setIsbn(form.getIsbn());
        entity.setPages(form.getPages());
        entity.setPublisher(form.getPublisher());

        return bookRepository.save(entity);

    }
}
