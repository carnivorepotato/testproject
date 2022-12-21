package com.testproject.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class DaoFactory {

    private NewspaperRepository repository;
    private Logger logger;

    @Bean
    public CommandLineRunner init(NewspaperRepository repository) {
        return args -> {
            this.repository = repository;
            this.logger = LoggerFactory.getLogger(DaoFactory.class);
        };
    }

    public NewspaperRepository getNewspaperRepository() {
        return repository;
    }
}
