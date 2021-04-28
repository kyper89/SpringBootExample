package ru.geekbrains.springbootexample.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class HibernateUtil {
    private SessionFactory sessionFactory;

    @PostConstruct
    public void init() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @PreDestroy
    public void shutdown() {
        if(sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
