package com.training.bench.spring5webapptrain.bootstrap;

import com.training.bench.spring5webapptrain.model.Author;
import com.training.bench.spring5webapptrain.model.Book;
import com.training.bench.spring5webapptrain.repositories.AuthorRepository;
import com.training.bench.spring5webapptrain.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    //will be populated by Spring dependency injection
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric","Graham");
        Book ddd = new Book("Domain driven design","123-34-234","Harper callings");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE dev without EJB","123-54-877","Morx");
        rod.getBooks().add(noEJB);

        Author rojer = new Author("Rojer","Jeliazny");
        Book amber = new Book("Amber chronicles","103-99-4257","Piter");
        rojer.getBooks().add(amber);
        amber.getAuthors().add(rojer);

        authorRepository.save(eric);
        authorRepository.save(rod);
        authorRepository.save(rojer);

        bookRepository.save(ddd);
        bookRepository.save(noEJB);
        bookRepository.save(amber);
    }
}
