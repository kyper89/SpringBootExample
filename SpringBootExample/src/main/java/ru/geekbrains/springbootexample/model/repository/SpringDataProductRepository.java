package ru.geekbrains.springbootexample.model.repository;

import org.springframework.data.repository.CrudRepository;
import ru.geekbrains.springbootexample.model.entity.Product;

public interface SpringDataProductRepository extends CrudRepository<Product, Long> {
}
