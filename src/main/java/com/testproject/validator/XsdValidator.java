package com.testproject.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

import static org.springframework.util.ResourceUtils.CLASSPATH_URL_PREFIX;
import static org.springframework.util.ResourceUtils.getFile;

@Component
@RequiredArgsConstructor
public class XsdValidator implements Validator {
    private final String schemaLocation = CLASSPATH_URL_PREFIX + "Schema.xsd";

    @Override
    public void validate(File file) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Source schemaFile = new StreamSource(getFile(schemaLocation));
            Schema schema = factory.newSchema(schemaFile);
            schema.newValidator().validate(new StreamSource(file));
        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
