package by.trjava.xmlparsing.chekun.domain.parser.creator.validator.impl;

import by.trjava.xmlparsing.chekun.domain.parser.type.ParserType;
import by.trjava.xmlparsing.chekun.domain.parser.creator.validator.ParserTypeValidator;

import java.util.Arrays;

public class ParserTypeValidatorImpl implements ParserTypeValidator {

    private static final String[] PARSERS_NAMES = Arrays.stream(ParserType.values()).map(Enum::name).toArray(String[]::new);

    @Override
    public boolean isParserTypeCorrect(final String parserName) {

        return parserName != null &&
                Arrays.stream(PARSERS_NAMES).anyMatch(s -> s.equalsIgnoreCase(parserName));
    }
}
