package by.trjava.xmlparsing.chekun.domain.parser.impl;

import by.trjava.xmlparsing.chekun.domain.entity.TouristVoucher;
import by.trjava.xmlparsing.chekun.domain.parser.XmlParser;
import by.trjava.xmlparsing.chekun.domain.parser.exception.ParsingException;
import by.trjava.xmlparsing.chekun.domain.parser.handler.TouristVoucherHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SaxParser implements XmlParser {

    @Override
    public List<TouristVoucher> parse(final InputStream xmlInputStream) throws ParsingException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();

            SAXParser parser = factory.newSAXParser();

            TouristVoucherHandler handler = new TouristVoucherHandler();

            parser.parse(xmlInputStream, handler);

            final List<TouristVoucher> list = handler.getTouristVouchers();

            return list;
        } catch (ParserConfigurationException ex) {
            throw new ParsingException("Parser configuration error: " + ex.getMessage());
        } catch (SAXException ex) {
            throw new ParsingException("SAX Error: " + ex.getMessage());
        } catch (IOException ex) {
            throw new ParsingException("I/O error: " + ex.getMessage());
        }
    }

}



