package com.testproject.dao;

import com.testproject.dao.model.Newspaper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewspaperRepository extends JpaRepository<Newspaper, Long> {
}