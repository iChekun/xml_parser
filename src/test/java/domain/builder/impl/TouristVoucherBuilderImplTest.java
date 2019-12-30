package domain.builder.impl;

import by.trjava.xmlparsing.chekun.domain.builder.impl.HotelCharacteristicBuilderImpl;
import by.trjava.xmlparsing.chekun.domain.builder.impl.TouristVoucherBuilderImpl;
import by.trjava.xmlparsing.chekun.domain.builder.impl.TripPriceBuilderImpl;
import by.trjava.xmlparsing.chekun.domain.entity.FoodType;
import by.trjava.xmlparsing.chekun.domain.entity.HotelCharacteristic;
import by.trjava.xmlparsing.chekun.domain.entity.TouristVoucher;
import by.trjava.xmlparsing.chekun.domain.entity.TripPrice;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TouristVoucherBuilderImplTest {


    private TouristVoucherBuilderImpl touristVoucherBuilder = new TouristVoucherBuilderImpl("ID-1");

    private TouristVoucherBuilderImpl readyBuilder = new TouristVoucherBuilderImpl("ID-1");

    private TripPrice readyTripPrice;

    private HotelCharacteristic readyHotelCharacteristicBuilder;

    private TouristVoucher readyTouristVoucher;


    @BeforeClass
    public void init() {
        readyTripPrice = new TripPriceBuilderImpl().withHotelPrice(500)
                .withTransportPrice(500)
                .withFullPrice(1500)
                .build();

        readyHotelCharacteristicBuilder = new HotelCharacteristicBuilderImpl().withHotelLevel(2)
                .withRoomsCount(2)
                .withFoodType(FoodType.BB)
                .withAirConditionAvailability(false)
                .withTVAvailability(false)
                .build();

        readyBuilder.withCountry("belarus")
                .withDepartureDate("2019-6-09")
                .withType("rest")
                .withDaysNumber(5)
                .withTransport("car")
                .withTripPrice(readyTripPrice)
                .withHotelCharacteristic(readyHotelCharacteristicBuilder);


        readyTouristVoucher = new TouristVoucher("ID-1", "rest", "belarus", 5, "car",
                readyHotelCharacteristicBuilder,
                readyTripPrice, "2019-6-09");
    }

    @Test
    public void testWithType() {
        touristVoucherBuilder.withType("rest");

        assertEquals(readyBuilder.getType(), touristVoucherBuilder.getType());
    }

    @Test
    public void testWithCountry() {
        touristVoucherBuilder.withCountry("belarus");

        assertEquals(readyBuilder.getCountry(), touristVoucherBuilder.getCountry());
    }

    @Test
    public void testWithDaysNumber() {
        touristVoucherBuilder.withDaysNumber(5);

        assertEquals(readyBuilder.getNumberDays(), touristVoucherBuilder.getNumberDays());
    }

    @Test
    public void testWithTransport() {
        touristVoucherBuilder.withTransport("car");

        assertEquals(readyBuilder.getTransport(), touristVoucherBuilder.getTransport());
    }

    @Test
    public void testWithHotelCharacteristic() {
        touristVoucherBuilder.withHotelCharacteristic(readyHotelCharacteristicBuilder);

        assertEquals(readyBuilder.getHotelCharacteristic(), touristVoucherBuilder.getHotelCharacteristic());
    }

    @Test
    public void testWithTripPrice() {
        touristVoucherBuilder.withTripPrice(readyTripPrice);

        assertEquals(readyBuilder.getTripPrice(), touristVoucherBuilder.getTripPrice());
    }

    @Test
    public void testWithDepartureDate() {
        touristVoucherBuilder.withDepartureDate("2019-6-09");

        assertEquals(readyBuilder.getDepartureDate(), touristVoucherBuilder.getDepartureDate());
    }

    @Test
    public void testBuild() {

        touristVoucherBuilder.withCountry("belarus")
                .withDepartureDate("2019-6-09")
                .withType("rest")
                .withDaysNumber(5)
                .withTransport("car")
                .withTripPrice(readyTripPrice)
                .withHotelCharacteristic(readyHotelCharacteristicBuilder);
        TouristVoucher actual = touristVoucherBuilder.build();

        assertEquals(readyTouristVoucher, actual);
    }
}