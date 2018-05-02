package com.training.bench.spring5webapptrain.repositories;

import com.training.bench.spring5webapptrain.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
