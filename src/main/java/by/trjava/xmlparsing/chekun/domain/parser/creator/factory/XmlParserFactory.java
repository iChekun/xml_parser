package by.trjava.xmlparsing.chekun.domain.parser.creator.factory;

import by.trjava.xmlparsing.chekun.domain.parser.XmlParser;
import by.trjava.xmlparsing.chekun.domain.parser.type.ParserType;

public interface XmlParserFactory {
    /**
     * Returns XML parser according with received name.
     * Can returns object that implement XMLParser.
     *
     * @param parserType parser name
     * @return Xml parser with received name
     * @see XmlParser
     */
    public XmlParser getXmlParser(ParserType parserType);
}
