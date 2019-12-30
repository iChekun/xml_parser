package by.trjava.xmlparsing.chekun.domain.builder.impl;

import by.trjava.xmlparsing.chekun.domain.builder.TouristVoucherBuilder;
import by.trjava.xmlparsing.chekun.domain.entity.HotelCharacteristic;
import by.trjava.xmlparsing.chekun.domain.entity.TouristVoucher;
import by.trjava.xmlparsing.chekun.domain.entity.TripPrice;

public class TouristVoucherBuilderImpl implements TouristVoucherBuilder {

    private String id;

    private String type;

    private String country;

    private int numberDays;

    private String transport;

    private HotelCharacteristic hotelCharacteristic;

    private TripPrice tripPrice;

    private String departureDate;

    public TouristVoucherBuilderImpl(String id) {
        this.id = id;
    }


    @Override
    public TouristVoucherBuilder withType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public TouristVoucherBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    @Override
    public TouristVoucherBuilder withDaysNumber(int numberDays) {
        this.numberDays = numberDays;
        return this;
    }

    @Override
    public TouristVoucherBuilder withTransport(String transport) {
        this.transport = transport;
        return this;
    }

    @Override
    public TouristVoucherBuilder withHotelCharacteristic(HotelCharacteristic hotelCharacteristic) {
        this.hotelCharacteristic = hotelCharacteristic;
        return this;
    }

    @Override
    public TouristVoucherBuilder withTripPrice(TripPrice tripPrice) {
        this.tripPrice = tripPrice;
        return this;
    }

    @Override
    public TouristVoucherBuilder withDepartureDate(String departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    @Override
    public TouristVoucher build() {

        final TouristVoucher touristVoucher = new TouristVoucher(id, type, country, numberDays,
                                                             transport, hotelCharacteristic, tripPrice, departureDate);

        return touristVoucher;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getCountry() {
        return country;
    }

    public int getNumberDays() {
        return numberDays;
    }

    public String getTransport() {
        return transport;
    }

    public HotelCharacteristic getHotelCharacteristic() {
        return hotelCharacteristic;
    }

    public TripPrice getTripPrice() {
        return tripPrice;
    }

    public String getDepartureDate() {
        return departureDate;
    }
}
