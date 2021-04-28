package ru.geekbrains.springbootexample.model.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.geekbrains.springbootexample.model.entity.Client;
import ru.geekbrains.springbootexample.utils.HibernateUtil;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    private final HibernateUtil hibernateUtil;

    public ClientRepository(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    public Client get(Long id) {
        try (Session session = hibernateUtil.getCurrentSession()){
            session.beginTransaction();
            Optional<Client> client = Optional.ofNullable(session.get(Client.class, id));
            session.getTransaction().commit();
            return client.get();
        }
    }

    public List<Client> getAll() {
        try (Session session = hibernateUtil.getCurrentSession()){
            session.beginTransaction();
            List<Client> clients = session.createNamedQuery("Client.findAll", Client.class).getResultList();
            session.getTransaction().commit();
            return clients;
        }
    }

    public void save(Client client) {
        try (Session session = hibernateUtil.getCurrentSession()){
            session.beginTransaction();
            session.saveOrUpdate(client);
            session.getTransaction().commit();
        }
    }


    public void delete(Client client) {
        try (Session session = hibernateUtil.getCurrentSession()){
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        }
    }
}
