package com.testproject.dao;

import com.testproject.dao.model.Newspaper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NewspaperDaoImpl implements NewspaperDao {

    @NonNull
    private DaoFactory daoFactory;

    public void saveNewspaper(Newspaper newspaper) {
        daoFactory.getNewspaperRepository().save(newspaper);
    }

    @Override
    public Newspaper[] getAll() {
        return daoFactory.getNewspaperRepository().findAll().toArray(new Newspaper[0]);
    }
}