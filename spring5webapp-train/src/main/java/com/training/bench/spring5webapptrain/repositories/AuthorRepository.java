package com.training.bench.spring5webapptrain.repositories;

import com.training.bench.spring5webapptrain.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
