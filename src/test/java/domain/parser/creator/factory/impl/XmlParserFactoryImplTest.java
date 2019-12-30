package domain.parser.creator.factory.impl;

import by.trjava.xmlparsing.chekun.domain.parser.XmlParser;
import by.trjava.xmlparsing.chekun.domain.parser.creator.factory.XmlParserFactory;
import by.trjava.xmlparsing.chekun.domain.parser.creator.factory.impl.XmlParserFactoryImpl;
import by.trjava.xmlparsing.chekun.domain.parser.impl.DomParser;
import by.trjava.xmlparsing.chekun.domain.parser.impl.SaxParser;
import by.trjava.xmlparsing.chekun.domain.parser.impl.StaxParser;
import by.trjava.xmlparsing.chekun.domain.parser.type.ParserType;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class XmlParserFactoryImplTest {


    private XmlParserFactory factory = new XmlParserFactoryImpl();

    @Test
    public void getXmlParser_DOM_true() {
        XmlParser expected = new DomParser();
        //given
        //when
        XmlParser parser = factory.getXmlParser(ParserType.DOM);
        //then
        assertEquals(parser.getClass(), expected.getClass());
    }

    @Test
    public void getXmlParser_SAX_true() {
        XmlParser expected = new SaxParser();
        //given
        //when
        XmlParser parser = factory.getXmlParser(ParserType.SAX);
        //then
        assertEquals(parser.getClass(), expected.getClass());
    }

    @Test
    public void getXmlParser_StAX_true() {
        XmlParser expected = new StaxParser();
        //given
        //when
        XmlParser parser = factory.getXmlParser(ParserType.STAX);
        //then
        assertEquals(parser.getClass(), expected.getClass());
    }

}