package ru.geekbrains.springbootexample.model.services;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import ru.geekbrains.springbootexample.model.entity.Client;
import ru.geekbrains.springbootexample.model.entity.Product;
import ru.geekbrains.springbootexample.model.repository.ClientRepository;
import ru.geekbrains.springbootexample.model.repository.ProductDao;
import ru.geekbrains.springbootexample.utils.HibernateUtil;

import java.util.List;

@Service
public class tradeService {
    private final HibernateUtil hibernateUtil;
    private final ClientRepository clientRepository;
    private final ProductDao productRepository;

    public tradeService(HibernateUtil hibernateUtil, ClientRepository clientRepository, ProductDao productRepository) {
        this.hibernateUtil = hibernateUtil;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    public List<Product> getProductsByClient(Long id) {
        try (Session session = hibernateUtil.getCurrentSession()){
            session.beginTransaction();
            List<Product> products = clientRepository.get(id).getProducts();
            session.getTransaction().commit();
            return products;
        }
    }

    public List<Client> getClientsByProduct(Long id) {
        try (Session session = hibernateUtil.getCurrentSession()){
            session.beginTransaction();
            List<Client> clients = productRepository.get(id).getClients();
            session.getTransaction().commit();
            return clients;
        }
    }
}
