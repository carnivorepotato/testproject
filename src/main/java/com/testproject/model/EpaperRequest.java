package com.testproject.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@XmlRootElement
public class EpaperRequest {

    private DeviceInfo deviceInfo;
    private GetPages getPages;

    @XmlElement
    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    @XmlElement
    public GetPages getGetPages() {
        return getPages;
    }
}