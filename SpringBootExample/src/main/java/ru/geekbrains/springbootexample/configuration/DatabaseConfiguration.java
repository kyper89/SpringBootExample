package ru.geekbrains.springbootexample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public EntityManager entityManager() {
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory().createEntityManager();
    }
}
