package by.trjava.xmlparsing.chekun.domain.validator;


import by.trjava.xmlparsing.chekun.domain.validator.exception.ValidationException;

import java.io.InputStream;


public interface XmlValidator {
    /**
     * Validate XML document against XSD schema
     *
     * @param xmlInputStream input stream of XML document
     * @param xsdInputStream input stream ob XSD schema
     * @return {@code true} -> if document valid
     * @throws ValidationException throws if xml document is not valid and it has any errors
     */
    boolean validate(InputStream xmlInputStream, InputStream xsdInputStream) throws ValidationException;

}
