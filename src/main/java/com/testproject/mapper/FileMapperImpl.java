package com.testproject.mapper;

import com.testproject.model.EpaperRequest;
import com.testproject.validator.Validator;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class FileMapperImpl implements FileMapper {

    private final Validator validator;

    public EpaperRequest validateAmdMap(MultipartFile input) throws IOException, JAXBException {
        File tempFile = File.createTempFile("tmp", ".tmp");
        input.transferTo(tempFile);
        validator.validate(tempFile);
        JAXBContext context = JAXBContext.newInstance(EpaperRequest.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (EpaperRequest) unmarshaller.unmarshal(tempFile);
    }
}