package domain.parser.creator.impl;

import by.trjava.xmlparsing.chekun.domain.parser.XmlParser;
import by.trjava.xmlparsing.chekun.domain.parser.creator.ParserCreator;
import by.trjava.xmlparsing.chekun.domain.parser.creator.exception.WrongParserTypeException;
import by.trjava.xmlparsing.chekun.domain.parser.creator.impl.ParserCreatorImpl;
import by.trjava.xmlparsing.chekun.domain.parser.impl.DomParser;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParserCreatorImplTest {

    private ParserCreator creator = new ParserCreatorImpl();


    @Test
    public void testGetParser_correct_Name_true() throws WrongParserTypeException {
        XmlParser expected = new DomParser();
        //given
        String type = "dom";
        //when
        XmlParser actual = creator.getParser(type);
        //then
        assertEquals(expected.getClass(), actual.getClass());
    }


    @Test(expectedExceptions = WrongParserTypeException.class)
    public void testGetParser_wrong_name_false() throws WrongParserTypeException {
        XmlParser expected = new DomParser();
        //given
        String type = "bolt";
        //when
        XmlParser actual = creator.getParser(type);
        //then

    }
}