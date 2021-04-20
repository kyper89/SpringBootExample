package ru.geekbrains.springbootexample.model.repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.springbootexample.model.entity.Product;

import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository{

    private final List<Product> products;

    {
        products = Product.generateProduct(5);
    }

    @Override
    public Product getProduct(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void saveProduct(Product product) {
        products.add(product);
    }
}
