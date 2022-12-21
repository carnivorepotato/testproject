package com.testproject.mapper;

import com.testproject.model.EpaperRequest;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class FileMapperImpl implements FileMapper {

    public EpaperRequest map(MultipartFile input) throws IOException, JAXBException {
        File tempFile = File.createTempFile("tmp", ".tmp");
        input.transferTo(tempFile);
        JAXBContext context = JAXBContext.newInstance(EpaperRequest.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (EpaperRequest) unmarshaller.unmarshal(tempFile);
    }
}