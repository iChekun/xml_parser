package by.trjava.xmlparsing.chekun.domain.builder;

import by.trjava.xmlparsing.chekun.domain.entity.TripPrice;

public interface TripPriceBuilder {

    TripPrice build();

    TripPriceBuilder withFullPrice(double fullPrice);

    TripPriceBuilder withTransportPrice(double transportPrice);

    TripPriceBuilder withHotelPrice(double hotelPrice);
}
