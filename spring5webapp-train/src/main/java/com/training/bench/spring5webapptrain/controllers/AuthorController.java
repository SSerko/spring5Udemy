package com.training.bench.spring5webapptrain.controllers;

import com.training.bench.spring5webapptrain.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors",authorRepository.findAll());
        return "authors_list";
    }
}
