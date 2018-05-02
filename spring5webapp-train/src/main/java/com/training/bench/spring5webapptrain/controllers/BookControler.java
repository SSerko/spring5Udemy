package com.training.bench.spring5webapptrain.controllers;

import com.training.bench.spring5webapptrain.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookControler {

    private BookRepository bookRepository;

    //autoinjected by spring at runtime
    public BookControler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books",bookRepository.findAll());//here we set book that we can iterate in template
        return "books_list";//ok. so this is template name (or view name)
    }
}
