package by.trjava.xmlparsing.chekun.domain.builder;

import by.trjava.xmlparsing.chekun.domain.entity.HotelCharacteristic;
import by.trjava.xmlparsing.chekun.domain.entity.TouristVoucher;
import by.trjava.xmlparsing.chekun.domain.entity.TripPrice;

public interface TouristVoucherBuilder {

    TouristVoucher build();

    TouristVoucherBuilder withType(String type);

    TouristVoucherBuilder withCountry(String country);

    TouristVoucherBuilder withDaysNumber(int numberDays);

    TouristVoucherBuilder withTransport(String transport);

    TouristVoucherBuilder withHotelCharacteristic(HotelCharacteristic hotelCharacteristic);

    TouristVoucherBuilder withTripPrice(TripPrice tripPrice);

    TouristVoucherBuilder withDepartureDate(String departureDate);
}
