package com.training.bench.spring5webapptrain.bootstrap;

import com.training.bench.spring5webapptrain.model.Author;
import com.training.bench.spring5webapptrain.model.Book;
import com.training.bench.spring5webapptrain.model.Publisher;
import com.training.bench.spring5webapptrain.repositories.AuthorRepository;
import com.training.bench.spring5webapptrain.repositories.BookRepository;
import com.training.bench.spring5webapptrain.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    //will be populated by Spring dependency injection
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher pb1 = new Publisher("Piter","Moscow, street 123/4");
        Publisher pb2 = new Publisher("Global publisher","Earth");
        Author eric = new Author("Eric","Graham");
        Book ddd = new Book("Domain driven design","123-34-234");
        ddd.setPublisher(pb2);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE dev without EJB","123-54-877");
        noEJB.setPublisher(pb2);
        rod.getBooks().add(noEJB);

        Author rojer = new Author("Rojer","Jeliazny");
        Book amber = new Book("Amber chronicles","103-99-4257");
        amber.setPublisher(pb1);
        rojer.getBooks().add(amber);
        amber.getAuthors().add(rojer);

        publisherRepository.save(pb1);
        publisherRepository.save(pb2);

        authorRepository.save(eric);
        authorRepository.save(rod);
        authorRepository.save(rojer);

        bookRepository.save(ddd);
        bookRepository.save(noEJB);
        bookRepository.save(amber);


    }
}
