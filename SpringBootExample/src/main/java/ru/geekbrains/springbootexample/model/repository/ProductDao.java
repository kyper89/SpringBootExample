package ru.geekbrains.springbootexample.model.repository;

import org.springframework.stereotype.Service;
import ru.geekbrains.springbootexample.model.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Service
public class ProductDao implements ProductRepository{
    private final EntityManager em;

    public ProductDao(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public Product get(Long id) {
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> getProducts() {
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    @Override
    public void saveProduct(Product product) {
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        em.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void deleteProduct(Long id) {
        em.getTransaction().begin();
        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
    }

}
