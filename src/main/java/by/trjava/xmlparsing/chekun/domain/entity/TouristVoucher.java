package by.trjava.xmlparsing.chekun.domain.entity;


import java.util.Objects;


public class TouristVoucher {

    private final String id;

    private final String type;

    private final String country;

    private final int numberDays;

    private final String transport;

    private final HotelCharacteristic hotelCharacteristic;

    private final TripPrice tripPrice;

    private final String departureDate;


    public TouristVoucher(String id, String type, String country,
                          int numberDays, String transport,
                          HotelCharacteristic hotelCharacteristic,
                          TripPrice tripPrice, String departureDate) {
        this.id = id;
        this.type = type;
        this.country = country;
        this.numberDays = numberDays;
        this.transport = transport;
        this.hotelCharacteristic = hotelCharacteristic;
        this.tripPrice = tripPrice;
        this.departureDate = departureDate;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TouristVoucher that = (TouristVoucher) o;
        return numberDays == that.numberDays &&
                Objects.equals(id, that.id) &&
                Objects.equals(type, that.type) &&
                Objects.equals(country, that.country) &&
                Objects.equals(transport, that.transport) &&
                Objects.equals(hotelCharacteristic, that.hotelCharacteristic) &&
                Objects.equals(tripPrice, that.tripPrice) &&
                Objects.equals(departureDate, that.departureDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, country, numberDays, transport, hotelCharacteristic, tripPrice, departureDate);
    }

    @Override
    public String toString() {
        return "TouristVoucher@" +
                "id=" + id +
                ", type=" + type +
                ", country=" + country +
                ", numberDays=" + numberDays +
                ", transport=" + transport +
                ", hotelCharacteristic=" + hotelCharacteristic +
                ", tripPrice=" + tripPrice +
                ", departureDate=" + departureDate;
    }
}
