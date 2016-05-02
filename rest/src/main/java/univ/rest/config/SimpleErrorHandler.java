package univ.rest.config;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SimpleErrorHandler implements org.xml.sax.ErrorHandler {

    private boolean errorOccured=false;

    public void warning(SAXParseException exception) throws SAXException {
        errorOccured = true;
    }

    public void error(SAXParseException exception) throws SAXException {
        errorOccured = true;
    }

    public void fatalError(SAXParseException exception) throws SAXException {
        errorOccured = true;
    }

    public boolean hasError() {
        return errorOccured;
    }
}