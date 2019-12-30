package by.trjava.xmlparsing.chekun.domain.service;

import by.trjava.xmlparsing.chekun.domain.service.impl.TouristVouchersServiceImpl;

public final class ServiceFactory {

    private static ServiceFactory instance = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return instance;
    }

    private TouristVouchersService touristVouchersService = new TouristVouchersServiceImpl();

    public TouristVouchersService getTouristVouchersService() {
        return touristVouchersService;
    }

    private ServiceFactory() {
    }
}
