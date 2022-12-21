package com.testproject.dao;

import com.testproject.dao.model.Newspaper;

public interface NewspaperDao {

    void saveNewspaper(Newspaper newspaper);

    Newspaper[] getAll();
}