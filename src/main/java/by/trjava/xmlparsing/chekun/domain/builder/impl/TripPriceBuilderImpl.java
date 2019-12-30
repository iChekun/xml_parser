package by.trjava.xmlparsing.chekun.domain.builder.impl;

import by.trjava.xmlparsing.chekun.domain.builder.TripPriceBuilder;
import by.trjava.xmlparsing.chekun.domain.entity.TripPrice;

public class TripPriceBuilderImpl implements TripPriceBuilder {

    private double fullPrice;

    private double transportPrice;

    private double hotelPrice;

    public TripPriceBuilderImpl() {
    }


    @Override
    public TripPriceBuilder withFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
        return this;
    }

    @Override
    public TripPriceBuilder withTransportPrice(double transportPrice) {
        this.transportPrice = transportPrice;
        return this;
    }

    @Override
    public TripPriceBuilder withHotelPrice(double hotelPrice) {
        this.hotelPrice = hotelPrice;
        return this;
    }


    @Override
    public TripPrice build() {
        final TripPrice tripPrice = new TripPrice(fullPrice, transportPrice, hotelPrice);
        return tripPrice;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public double getTransportPrice() {
        return transportPrice;
    }

    public double getHotelPrice() {
        return hotelPrice;
    }
}
