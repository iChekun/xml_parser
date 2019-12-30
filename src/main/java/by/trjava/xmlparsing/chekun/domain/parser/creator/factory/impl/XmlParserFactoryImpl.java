package by.trjava.xmlparsing.chekun.domain.parser.creator.factory.impl;

import by.trjava.xmlparsing.chekun.domain.parser.impl.StaxParser;
import by.trjava.xmlparsing.chekun.domain.parser.creator.factory.XmlParserFactory;
import by.trjava.xmlparsing.chekun.domain.parser.XmlParser;
import by.trjava.xmlparsing.chekun.domain.parser.impl.DomParser;
import by.trjava.xmlparsing.chekun.domain.parser.impl.SaxParser;
import by.trjava.xmlparsing.chekun.domain.parser.type.ParserType;

public class XmlParserFactoryImpl implements XmlParserFactory {

    @Override
    public XmlParser getXmlParser(final ParserType parserType) {
        XmlParser parser = null;

        switch (parserType) {
            case DOM:
                parser = new DomParser();
                break;
            case SAX:
                parser = new SaxParser();
                break;
            case STAX:
                parser = new StaxParser();
                break;
        }
        return parser;
    }

}
