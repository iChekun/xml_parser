package by.trjava.xmlparsing.chekun.controller;//


import by.trjava.xmlparsing.chekun.domain.entity.TouristVoucher;
import by.trjava.xmlparsing.chekun.domain.service.ServiceFactory;
import by.trjava.xmlparsing.chekun.domain.service.TouristVouchersService;
import by.trjava.xmlparsing.chekun.domain.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] argc) {

        String xmlPath = "src/main/resources/tourist_vouchers.xml";
        String xsdPath = "src/main/resources/schema.xsd";
        String parserName = "sax";

        try (InputStream xmlInputStream = new FileInputStream(xmlPath);
             InputStream xsdInputStream = new FileInputStream(xsdPath);
             InputStream parsingInputStream = new FileInputStream(xmlPath)) {

            final ServiceFactory serviceFactory = ServiceFactory.getInstance();
            final TouristVouchersService touristVouchersService = serviceFactory.getTouristVouchersService();

            final List<TouristVoucher> touristVouchers = touristVouchersService.getTouristVouchersList(parserName, xmlInputStream, xsdInputStream, parsingInputStream);

            touristVouchers.forEach(System.out::println);

            touristVouchers.forEach(logger::info);

        } catch (ServiceException | IOException e) {
            logger.warn(e.getMessage());
            //System.out.println(e.getMessage());
        }
    }
}



