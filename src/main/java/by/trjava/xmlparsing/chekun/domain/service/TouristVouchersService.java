package by.trjava.xmlparsing.chekun.domain.service;

import by.trjava.xmlparsing.chekun.domain.entity.TouristVoucher;
import by.trjava.xmlparsing.chekun.domain.service.exception.ServiceException;

import java.io.InputStream;
import java.util.List;

public interface TouristVouchersService {

    /**
     * Use for get list with tourist vouchers from given file.
     *
     * @param parserName name of parser to use
     * @param xmlInputStream inputStream of xmlFile
     * @param xsdInputStream inputStream of xsdFile
     * @param parsingInputStream inputStream if xmlFile for parsing
     * @return list with tourist vouchers
     * @throws ServiceException throws if something going wrong
     * @see TouristVoucher
     */
    public List<TouristVoucher> getTouristVouchersList(String parserName,
                                                       InputStream xmlInputStream,
                                                       InputStream xsdInputStream,
                                                       InputStream parsingInputStream)
                                                       throws ServiceException;


}
