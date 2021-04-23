package ru.geekbrains.springbootexample.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@NamedQueries(
        @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"))
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private BigDecimal cost;

    public Product() {}

    public Product(int id, String title, BigDecimal cost) {
        this.title = title;
        this.cost = cost;
    }

    public static List<Product> generateProduct(int count) {

        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            products.add(new Product(i, "Product_" + i, new BigDecimal(String.format("%d.%d", i, i))));
        }

        return products;
    }

    @Override
    public String toString() {
        return id + "_" + title + ", cost=" + cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setId(int id) {}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
