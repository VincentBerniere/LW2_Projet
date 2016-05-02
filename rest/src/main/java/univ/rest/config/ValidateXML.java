package univ.rest.config;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ValidateXML {

    public static boolean should_validate_with_DOM(InputSource inputSource) {
        SimpleErrorHandler errorHandler = new SimpleErrorHandler();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);

        SchemaFactory schemaFactory =
                SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");


        try {
            factory.setSchema(schemaFactory.newSchema(
                    new Source[] {new StreamSource("src/main/ressources/stb.xsd")}));
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        builder.setErrorHandler(errorHandler);

        try {
            Document document = builder.parse(inputSource);
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return errorHandler.hasError();
    }
}