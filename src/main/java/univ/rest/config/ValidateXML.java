package univ.rest.config;

import java.io.*;
import java.nio.charset.StandardCharsets;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class ValidateXML {

    public static boolean should_validate_with_DOM(StringWriter xmlStr) {
        SchemaFactory factory =
                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = null;
        try {
            schema = factory.newSchema(new StreamSource("src/main/resources/stb.xsd"));
        } catch (SAXException e) {
            e.printStackTrace();
            return false;
        }
        Validator validator = schema.newValidator();
        InputStream inputStream = new ByteArrayInputStream(xmlStr.toString().getBytes(StandardCharsets.UTF_8));
        try {
            validator.validate(new StreamSource(inputStream));
        } catch (SAXException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}