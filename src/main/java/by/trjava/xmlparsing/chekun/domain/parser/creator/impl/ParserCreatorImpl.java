package by.trjava.xmlparsing.chekun.domain.parser.creator.impl;

import by.trjava.xmlparsing.chekun.domain.parser.XmlParser;
import by.trjava.xmlparsing.chekun.domain.parser.creator.ParserCreator;
import by.trjava.xmlparsing.chekun.domain.parser.creator.factory.impl.XmlParserFactoryImpl;
import by.trjava.xmlparsing.chekun.domain.parser.creator.exception.WrongParserTypeException;
import by.trjava.xmlparsing.chekun.domain.parser.creator.factory.XmlParserFactory;
import by.trjava.xmlparsing.chekun.domain.parser.creator.validator.ParserTypeValidator;
import by.trjava.xmlparsing.chekun.domain.parser.creator.validator.impl.ParserTypeValidatorImpl;
import by.trjava.xmlparsing.chekun.domain.parser.type.ParserType;

import java.util.Arrays;

public class ParserCreatorImpl implements ParserCreator {

    private final ParserTypeValidator validator = new ParserTypeValidatorImpl();

    private final XmlParserFactory xmlParserFactory = new XmlParserFactoryImpl();


    public XmlParser getParser(final String parserName) throws WrongParserTypeException {

        if (validator.isParserTypeCorrect(parserName)) {

            final ParserType parserType = ParserType.valueOf(parserName.toUpperCase());

            final XmlParser xmlParser = xmlParserFactory.getXmlParser(parserType);

            return xmlParser;
        }

        throw new WrongParserTypeException("Parser type=" + parserName + " is not valid! Need to use: " + Arrays.toString(ParserType.values()));
    }
}
