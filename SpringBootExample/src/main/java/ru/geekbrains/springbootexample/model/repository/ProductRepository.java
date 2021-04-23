package ru.geekbrains.springbootexample.model.repository;

import ru.geekbrains.springbootexample.model.entity.Product;

import java.util.List;

public interface ProductRepository {

    Product getProduct(int id);

    List<Product> getProducts();

    void saveProduct(Product product);

    void deleteProduct(int id);
}
