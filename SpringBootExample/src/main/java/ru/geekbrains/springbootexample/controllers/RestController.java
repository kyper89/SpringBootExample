package ru.geekbrains.springbootexample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.springbootexample.model.entity.Product;
import ru.geekbrains.springbootexample.model.repository.SpringDataProductRepository;

@Controller
@RequestMapping("/app")
public class RestController {

    private final SpringDataProductRepository productRepository;

    public RestController(SpringDataProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/products/{id}")
    public String findById(Model uiModel, @PathVariable(value = "id") Long id) {
        System.out.println("findById");
        uiModel.addAttribute("products", productRepository.findAll());
        uiModel.addAttribute("product", productRepository.findById(id));
        return "products";
    }

    @GetMapping(value = "/products")
    public String getAll(Model uiModel){
        System.out.println("getAll");
        uiModel.addAttribute("products", productRepository.findAll());
        uiModel.addAttribute("product", new Product());
        return "products";
    }

    @PostMapping(value = "/products")
    public String create(Model uiModel, Product product) {
        System.out.println("create");
        productRepository.save(product);
        uiModel.addAttribute("product", new Product());
        uiModel.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @GetMapping (value = "/products/delete/{id}")
    public String deleteById(Model uiModel, @PathVariable(value = "id") Long id){
        System.out.println("deleteById");
        productRepository.deleteById(id);
        uiModel.addAttribute("products", productRepository.findAll());
        uiModel.addAttribute("product", new Product());
        return "products";
    }

    @PostMapping(value = "/deleteProduct")
    public String deleteProduct(Model uiModel, Product product){
        System.out.println("delete product " + product.getTitle());
        productRepository.delete(product);
        return "redirect:/products";
    }
}
