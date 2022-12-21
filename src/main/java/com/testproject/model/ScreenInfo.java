package com.testproject.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScreenInfo {

    private Integer width;
    private Integer height;
    private Integer dpi;

    @XmlAttribute
    public Integer getWidth() {
        return width;
    }

    @XmlAttribute
    public Integer getHeight() {
        return height;
    }

    @XmlAttribute
    public Integer getDpi() {
        return dpi;
    }
}