package com.testproject.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceInfo {

    private String name;
    private String id;
    private ScreenInfo screenInfo;
    private OsInfo osInfo;
    private AppInfo appInfo;

    @XmlAttribute
    public String getName() {
        return name;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    @XmlElement
    public ScreenInfo getScreenInfo() {
        return screenInfo;
    }

    @XmlElement
    public OsInfo getOsInfo() {
        return osInfo;
    }

    @XmlElement
    public AppInfo getAppInfo() {
        return appInfo;
    }
}