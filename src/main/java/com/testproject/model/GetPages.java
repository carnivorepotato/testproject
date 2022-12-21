package com.testproject.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GetPages {

    private Integer editionDefId;
    private Date publicationDate;

    @XmlAttribute
    public Integer getEditionDefId() {
        return editionDefId;
    }

    @XmlAttribute
    public Date getPublicationDate() {
        return publicationDate;
    }
}