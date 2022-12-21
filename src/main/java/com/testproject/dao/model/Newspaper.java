package com.testproject.dao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Newspaper")
public class Newspaper {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column(name = "uploadDate")
    private Date uploadDate;

    @NonNull
    @Column(name = "fileName")
    private String fileName;

    @NonNull
    @Column(name = "deviceName", nullable = false)
    private String deviceName;

    @NonNull
    @Column(name = "deviceId", nullable = false)
    private String deviceId;

    @NonNull
    @Column(name = "screenWidth", nullable = false)
    private Integer screenWidth;

    @NonNull
    @Column(name = "screenHeight", nullable = false)
    private Integer screenHeight;

    @NonNull
    @Column(name = "screenDpi", nullable = false)
    private Integer screenDpi;

    @NonNull
    @Column(name = "osName", nullable = false)
    private String osName;

    @NonNull
    @Column(name = "osVersion", nullable = false)
    private Double osVersion;

    @NonNull
    @Column(name = "newspaperName", nullable = false)
    private String newspaperName;

    @NonNull
    @Column(name = "newspaperVersion", nullable = false)
    private Double newspaperVersion;

    @NonNull
    @Column(name = "editionDefId", nullable = false)
    private Integer editionDefId;

    @NonNull
    @Column(name = "publicationDate", nullable = false)
    private Date publicationDate;
}
