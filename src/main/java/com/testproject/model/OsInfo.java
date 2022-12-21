package com.testproject.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OsInfo {

    private String name;
    private Double version;

    @XmlAttribute
    public String getName() {
        return name;
    }

    @XmlAttribute
    public Double getVersion() {
        return version;
    }
}