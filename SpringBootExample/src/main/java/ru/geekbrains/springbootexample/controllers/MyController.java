package ru.geekbrains.springbootexample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.springbootexample.model.entity.Product;
import ru.geekbrains.springbootexample.model.repository.ProductRepository;

@Controller
@RequestMapping("/")
public class MyController {

    private final ProductRepository productRepository;

    public MyController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/products")
    public String products(Model uiModel){
        uiModel.addAttribute("products", productRepository.getProducts());
        uiModel.addAttribute("product", new Product());
        return "products";
    }

    @PostMapping(value = "/products")
    public String createProduct(Model uiModel, Product product) {
        productRepository.saveProduct(product);
        uiModel.addAttribute("products", productRepository.getProducts());
        return "products";
    }

}
