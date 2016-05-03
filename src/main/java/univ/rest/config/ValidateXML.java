package univ.rest.config;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class ValidateXML {

    public static boolean should_validate_with_DOM(StringWriter xmlStr) {
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema = null;
        try {
            schema = factory.newSchema(new StreamSource("src/main/resources/stb.xsd"));
        } catch (SAXException e) {
            e.printStackTrace();
            return false;
        }
        Validator validator = schema.newValidator();
        Source source = new StreamSource(new StringReader(xmlStr.toString()));

        try {
            validator.validate(source);
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