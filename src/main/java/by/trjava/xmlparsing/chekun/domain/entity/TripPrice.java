package by.trjava.xmlparsing.chekun.domain.entity;

import java.util.Objects;

public class TripPrice {

    private final double fullPrice;

    private final double transportPrice;

    private final double hotelPrice;


    public TripPrice(double fullPrice, double transportPrice, double hotelPrice) {
        this.fullPrice = fullPrice;
        this.transportPrice = transportPrice;
        this.hotelPrice = hotelPrice;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripPrice tripPrice = (TripPrice) o;
        return Double.compare(tripPrice.fullPrice, fullPrice) == 0 &&
                Double.compare(tripPrice.transportPrice, transportPrice) == 0 &&
                Double.compare(tripPrice.hotelPrice, hotelPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullPrice, transportPrice, hotelPrice);
    }


    @Override
    public String toString() {
        return "TripPrice@" +
                "fullPrice=" + fullPrice +
                ", transportPrice=" + transportPrice +
                ", hotelPrice=" + hotelPrice;
    }
}
