package by.trjava.xmlparsing.chekun.domain.service.impl;

import by.trjava.xmlparsing.chekun.domain.entity.TouristVoucher;
import by.trjava.xmlparsing.chekun.domain.parser.XmlParser;
import by.trjava.xmlparsing.chekun.domain.parser.creator.ParserCreator;
import by.trjava.xmlparsing.chekun.domain.parser.creator.exception.WrongParserTypeException;
import by.trjava.xmlparsing.chekun.domain.parser.creator.impl.ParserCreatorImpl;
import by.trjava.xmlparsing.chekun.domain.service.TouristVouchersService;
import by.trjava.xmlparsing.chekun.domain.service.exception.ServiceException;
import by.trjava.xmlparsing.chekun.domain.validator.XmlValidator;
import by.trjava.xmlparsing.chekun.domain.validator.exception.ValidationException;
import by.trjava.xmlparsing.chekun.domain.parser.exception.ParsingException;
import by.trjava.xmlparsing.chekun.domain.validator.impl.XmlValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.List;

public class TouristVouchersServiceImpl implements TouristVouchersService {

    private static final Logger logger = LogManager.getLogger(TouristVouchersServiceImpl.class);

    @Override
    public List<TouristVoucher> getTouristVouchersList(final String parserName,
                                                       final InputStream xmlInputStream,
                                                       final InputStream xsdInputStream,
                                                       final InputStream parsingInputStream)
                                                       throws ServiceException {

        logger.debug("Received parser name: " + parserName);

        try {
            final ParserCreator parserCreator = new ParserCreatorImpl();
            final XmlParser parser = parserCreator.getParser(parserName);

            final XmlValidator xmlValidator = new XmlValidatorImpl();
            xmlValidator.validate(xmlInputStream, xsdInputStream);

            final List<TouristVoucher> touristVouchers = parser.parse(parsingInputStream);

            return touristVouchers;

        } catch (WrongParserTypeException e) {
            logger.warn(e.getMessage());
            throw new ServiceException(e.getMessage());
        } catch (ValidationException e) {
            logger.warn("Received files is not valid! : " + e.getMessage());
            throw new ServiceException("Received files is not valid! : " + e.getMessage());
        } catch (ParsingException e) {
            logger.warn("Can`t parse file! Problem : " + e.getMessage());
            throw new ServiceException("Can`t parse file! Problem : " + e.getMessage());
        }
    }


}
