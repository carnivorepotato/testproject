package com.testproject.controller;

import com.testproject.dao.model.Newspaper;
import com.testproject.interactor.NewspaperInteractor;
import com.testproject.mapper.NewspaperMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("newspapers")
public class NewspaperController {


    private final NewspaperInteractor interactor;
    private final NewspaperMapper mapper;

    @PostMapping(value = "/new", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity createNewspaper(@RequestPart(value = "file") MultipartFile newspaper) {
        interactor.createNewspaper(newspaper);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/get/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Newspaper[]> getAllNewspapers() {
        return new ResponseEntity<>(interactor.getAllNewspapers(), HttpStatus.OK);
    }
}
