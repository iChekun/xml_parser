package domain.parser.impl;

import by.trjava.xmlparsing.chekun.domain.builder.HotelCharacteristicBuilder;
import by.trjava.xmlparsing.chekun.domain.builder.TouristVoucherBuilder;
import by.trjava.xmlparsing.chekun.domain.builder.TripPriceBuilder;
import by.trjava.xmlparsing.chekun.domain.builder.impl.HotelCharacteristicBuilderImpl;
import by.trjava.xmlparsing.chekun.domain.builder.impl.TouristVoucherBuilderImpl;
import by.trjava.xmlparsing.chekun.domain.builder.impl.TripPriceBuilderImpl;
import by.trjava.xmlparsing.chekun.domain.entity.FoodType;
import by.trjava.xmlparsing.chekun.domain.entity.HotelCharacteristic;
import by.trjava.xmlparsing.chekun.domain.entity.TouristVoucher;
import by.trjava.xmlparsing.chekun.domain.entity.TripPrice;
import by.trjava.xmlparsing.chekun.domain.parser.XmlParser;
import by.trjava.xmlparsing.chekun.domain.parser.exception.ParsingException;
import by.trjava.xmlparsing.chekun.domain.parser.impl.DomParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class DomParserTest {
    private XmlParser parser = new DomParser();


    private List<TouristVoucher> expected = new ArrayList<>();

    @BeforeClass
    public void beforeClass() {
        TouristVoucher firstTouristVoucher = null;
        TouristVoucher secondTouristVoucher = null;
        {
            HotelCharacteristicBuilder hotelCharacteristicBuilder = new HotelCharacteristicBuilderImpl();
            hotelCharacteristicBuilder.withHotelLevel(3)
                    .withFoodType(FoodType.BB)
                    .withRoomsCount(3)
                    .withAirConditionAvailability(false)
                    .withTVAvailability(true);

            HotelCharacteristic hotelCharacteristic = hotelCharacteristicBuilder.build();
            /////////////////////////////////////////////////////////////////////////////////
            TripPriceBuilder tripPriceBuilder = new TripPriceBuilderImpl();
            tripPriceBuilder.withTransportPrice(1500)
                    .withHotelPrice(2000)
                    .withFullPrice(10_000);
            TripPrice tripPrice = tripPriceBuilder.build();
            /////////////////////////////////////////////////////////////////////////////////
            TouristVoucherBuilder touristVoucherBuilder = new TouristVoucherBuilderImpl("ID-1");
            touristVoucherBuilder.withCountry("Belarus")
                    .withDaysNumber(25)
                    .withTransport("Car")
                    .withType("Rest")
                    .withHotelCharacteristic(hotelCharacteristic)
                    .withTripPrice(tripPrice)
                    .withDepartureDate("2019-02-10");
            firstTouristVoucher = touristVoucherBuilder.build();
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        {
            HotelCharacteristicBuilder hotelCharacteristicBuilder = new HotelCharacteristicBuilderImpl();
            hotelCharacteristicBuilder.withHotelLevel(2)
                    .withFoodType(FoodType.FB)
                    .withRoomsCount(2)
                    .withAirConditionAvailability(false)
                    .withTVAvailability(false);

            HotelCharacteristic hotelCharacteristic = hotelCharacteristicBuilder.build();
            /////////////////////////////////////////////////////////////////////////////////
            TripPriceBuilder tripPriceBuilder = new TripPriceBuilderImpl();
            tripPriceBuilder.withTransportPrice(500)
                    .withHotelPrice(1300)
                    .withFullPrice(7500);
            TripPrice tripPrice = tripPriceBuilder.build();
            /////////////////////////////////////////////////////////////////////////////////
            TouristVoucherBuilder touristVoucherBuilder = new TouristVoucherBuilderImpl("ID-2");
            touristVoucherBuilder.withCountry("Russia")
                    .withDaysNumber(31)
                    .withTransport("Bus")
                    .withType("Excursion")
                    .withHotelCharacteristic(hotelCharacteristic)
                    .withTripPrice(tripPrice)
                    .withDepartureDate("2017-03-01");
            secondTouristVoucher = touristVoucherBuilder.build();
        }

        expected.add(firstTouristVoucher);
        expected.add(secondTouristVoucher);
    }


    @Test(expectedExceptions = ParsingException.class)
    public void parse_wrongParameters_exception() throws FileNotFoundException, ParsingException {
        //given
        InputStream inputStream = new FileInputStream("src/main/resources/test/bad_tourist_vouchers.xml");
        //when
        parser.parse(inputStream);
        //then
        //ParsingException
    }

    @Test
    public void parse_correctParameters_true() throws FileNotFoundException, ParsingException {
        //given
        InputStream inputStream = new FileInputStream("src/main/resources/test/test_parsers.xml");
        //when
        List<TouristVoucher> actual = parser.parse(inputStream);
        //then
        assertEquals(expected, actual);
    }
}

