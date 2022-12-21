package com.testproject.dao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class DaoFactory {

    private NewspaperRepository repository;

    @Bean
    public CommandLineRunner initDaoFactory(NewspaperRepository repository) {
        return args -> {
            this.repository = repository;
        };
    }

    public NewspaperRepository getNewspaperRepository() {
        return repository;
    }
}
