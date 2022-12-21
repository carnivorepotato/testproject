package com.testproject.interactor;

import com.testproject.dao.NewspaperDao;
import com.testproject.dao.model.Newspaper;
import com.testproject.mapper.NewspaperMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class NewspaperInteractorImpl implements NewspaperInteractor {

    private final NewspaperDao newspaperDao;
    private final NewspaperMapper mapper;

    @Override
    public void createNewspaper(MultipartFile source) {
        newspaperDao.saveNewspaper(mapper.map(source));
    }

    @Override
    public Newspaper[] getAllNewspapers() {
        return newspaperDao.getAll();
    }
}