package by.trjava.xmlparsing.chekun.domain.parser;

import by.trjava.xmlparsing.chekun.domain.entity.TouristVoucher;
import by.trjava.xmlparsing.chekun.domain.parser.creator.ParserCreator;
import by.trjava.xmlparsing.chekun.domain.parser.impl.DomParser;
import by.trjava.xmlparsing.chekun.domain.parser.impl.SaxParser;
import by.trjava.xmlparsing.chekun.domain.parser.impl.StaxParser;
import by.trjava.xmlparsing.chekun.domain.parser.exception.ParsingException;

import java.io.InputStream;
import java.util.List;

public interface XmlParser {
    /**
     * Parses specified xml document
     *
     * @param xmlInputStream inputStream of xml document
     * @return {@code List<TouristVoucher}  specified by XML doc
     * @throws ParsingException throws if there was the error while parsing
     * @see ParserCreator
     * @see SaxParser
     * @see StaxParser
     * @see DomParser
     */
    List<TouristVoucher> parse(InputStream xmlInputStream) throws ParsingException;
}
