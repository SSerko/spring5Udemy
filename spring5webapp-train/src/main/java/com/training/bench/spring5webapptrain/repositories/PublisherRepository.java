package com.training.bench.spring5webapptrain.repositories;

import com.training.bench.spring5webapptrain.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
