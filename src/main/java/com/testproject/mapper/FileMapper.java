package com.testproject.mapper;

import com.testproject.model.EpaperRequest;
import jakarta.xml.bind.JAXBException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileMapper {

    EpaperRequest map(MultipartFile input) throws IOException, JAXBException;
}