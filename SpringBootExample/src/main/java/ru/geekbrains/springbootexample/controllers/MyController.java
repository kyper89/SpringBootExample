package ru.geekbrains.springbootexample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        System.out.println("GetMapping");
        uiModel.addAttribute("products", productRepository.getProducts());
        uiModel.addAttribute("product", new Product());
        return "products";
    }

    @PostMapping(value = "/products")
    public String createProduct(Model uiModel, Product product) {
        productRepository.saveProduct(product);
        uiModel.addAttribute("product", new Product());
        uiModel.addAttribute("products", productRepository.getProducts());
        return "products";
    }

    @GetMapping (value = "/products/delete")
    public String deleteProduct(Model uiModel, @RequestParam(name = "id") Long id){
        System.out.println("GetMapping/delete");
        productRepository.deleteProduct(id);
        uiModel.addAttribute("products", productRepository.getProducts());
        uiModel.addAttribute("id", 0);
        return "products";
    }
}
