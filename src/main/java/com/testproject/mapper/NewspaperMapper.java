package com.testproject.mapper;

import com.testproject.dao.model.Newspaper;
import com.testproject.model.EpaperRequest;
import jakarta.xml.bind.JAXBException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@Mapper(componentModel = "spring")
public abstract class NewspaperMapper {

    @Autowired
    private FileMapper fileMapper;

    public Newspaper map(MultipartFile source) {
        Newspaper result;
        try {
            EpaperRequest temp = fileMapper.validateAmdMap(source);
            result = map(temp, source.getOriginalFilename());
        } catch (IOException | JAXBException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Mapping(target = "deviceName", source = "source.deviceInfo.name")
    @Mapping(target = "deviceId", source = "source.deviceInfo.id")
    @Mapping(target = "screenWidth", source = "source.deviceInfo.screenInfo.width")
    @Mapping(target = "screenHeight", source = "source.deviceInfo.screenInfo.height")
    @Mapping(target = "screenDpi", source = "source.deviceInfo.screenInfo.dpi")
    @Mapping(target = "osName", source = "source.deviceInfo.osInfo.name")
    @Mapping(target = "osVersion", source = "source.deviceInfo.osInfo.version")
    @Mapping(target = "newspaperName", source = "source.deviceInfo.appInfo.newspaperName")
    @Mapping(target = "newspaperVersion", source = "source.deviceInfo.appInfo.version")
    @Mapping(target = "editionDefId", source = "source.getPages.editionDefId")
    @Mapping(target = "publicationDate", source = "source.getPages.publicationDate")
    @Mapping(target = "fileName", source = "originalFilename")
    @Mapping(target = "uploadDate", expression = "java(getCurrentTime())")
    public abstract Newspaper map(EpaperRequest source, String originalFilename);

    public Date getCurrentTime() {
        return Calendar.getInstance().getTime();
    }

}