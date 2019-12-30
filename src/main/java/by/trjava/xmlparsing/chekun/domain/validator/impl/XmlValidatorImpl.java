package by.trjava.xmlparsing.chekun.domain.validator.impl;


import by.trjava.xmlparsing.chekun.domain.validator.XmlValidator;
import by.trjava.xmlparsing.chekun.domain.validator.exception.ValidationException;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.InputStream;


public class XmlValidatorImpl implements XmlValidator {


    @Override
    public boolean validate(final InputStream xmlInputStream,
                            final InputStream xsdInputStream)
                            throws ValidationException {
        //xml schema namespace ("http://www.w3.org/2001/XMLSchema";)
        final String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        final SchemaFactory schemaFactory = SchemaFactory.newInstance(language);

        try {

            Source schemaSource = new StreamSource(xsdInputStream);

            Source xmlFile = new StreamSource(xmlInputStream);

            Schema schema = schemaFactory.newSchema(schemaSource);

            Validator validator = schema.newValidator();

            validator.validate(xmlFile);

            return true;
        } catch (IOException e) {
            throw new ValidationException("I/O error: " + e.getMessage());
        } catch (SAXException e) {
            throw new ValidationException("SAX error: " + e.getMessage());
        }
    }
}
