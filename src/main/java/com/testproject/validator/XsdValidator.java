package com.testproject.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class XsdValidator implements Validator {
    private final String schemaLocation = "classpath:/schema.xsd";
    private final ResourceLoader loader;

    @Override
    public void validate(File file) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Source schemaFile = new StreamSource(getResourceFile());
            Schema schema = factory.newSchema(schemaFile);
            schema.newValidator().validate(new StreamSource(file));
        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File getResourceFile() {
        Resource resource = loader.getResource(schemaLocation);
        File result;
        try {
            result = resource.getFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


}
