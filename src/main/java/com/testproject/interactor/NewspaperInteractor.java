package com.testproject.interactor;

import com.testproject.dao.model.Newspaper;
import org.springframework.web.multipart.MultipartFile;

public interface NewspaperInteractor {

    void createNewspaper(MultipartFile newspaper);

    Newspaper[] getAllNewspapers();
}