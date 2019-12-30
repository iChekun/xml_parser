package by.trjava.xmlparsing.chekun.domain.parser.creator;

import by.trjava.xmlparsing.chekun.domain.parser.XmlParser;
import by.trjava.xmlparsing.chekun.domain.parser.creator.exception.WrongParserTypeException;

public interface ParserCreator {
    /**
     * Create parser according with received name.
     *
     * @param parserName {@code String} parser name
     * @return XmlParser with received name
     * @throws WrongParserTypeException throws if received parser name is not valid
     */
    public XmlParser getParser(final String parserName) throws WrongParserTypeException;
}
