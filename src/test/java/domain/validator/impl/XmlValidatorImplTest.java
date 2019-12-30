package domain.validator.impl;

import by.trjava.xmlparsing.chekun.domain.validator.XmlValidator;
import by.trjava.xmlparsing.chekun.domain.validator.exception.ValidationException;
import by.trjava.xmlparsing.chekun.domain.validator.impl.XmlValidatorImpl;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.testng.Assert.assertTrue;

public class XmlValidatorImplTest {

    private XmlValidator validator = new XmlValidatorImpl();


    @Test(expectedExceptions = ValidationException.class)
    public void validate_test_null_false() throws ValidationException {

        InputStream xmlInputStream = null;
        InputStream xsdInputStream = null;

        validator.validate(xmlInputStream, xsdInputStream);
    }

    @Test
    public void validate_correctFiles_true() throws FileNotFoundException, ValidationException {
        //given
        InputStream xmlInputStream = new FileInputStream("src/main/resources/tourist_vouchers.xml");
        InputStream xsdInputStream = new FileInputStream("src/main/resources/schema.xsd");

        //when
        boolean result = validator.validate(xmlInputStream, xsdInputStream);

        //then
        assertTrue(result);
    }

    @Test(expectedExceptions = ValidationException.class)
    public void validate_badFilesData_false() throws FileNotFoundException, ValidationException {
        //given
        InputStream xmlInputStream = new FileInputStream("src/main/resources/test/bad_tourist_vouchers.xml");
        InputStream xsdInputStream = new FileInputStream("src/main/resources/schema.xsd");

        //when

        validator.validate(xmlInputStream, xsdInputStream);
        //then
        //ValidationException exception
    }


    @Test(expectedExceptions = FileNotFoundException.class)
    public void validate_badFile_false() throws FileNotFoundException, ValidationException {
        //given
        InputStream xmlInputStream = new FileInputStream("src/main/resources/bad_tourist_vouchers.xml");
        InputStream xsdInputStream = new FileInputStream("src/main/resources/schema.xml"); // bad type

        //when

        validator.validate(xmlInputStream, xsdInputStream);
        //then
        //FileNotFoundException exception
    }
}