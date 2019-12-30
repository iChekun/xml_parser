package domain.builder.impl;


import by.trjava.xmlparsing.chekun.domain.builder.impl.TripPriceBuilderImpl;
import by.trjava.xmlparsing.chekun.domain.entity.TripPrice;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TripPriceBuilderImplTest {


    private TripPriceBuilderImpl readyBuilder = new TripPriceBuilderImpl();

    private TripPriceBuilderImpl tripPriceBuilder = new TripPriceBuilderImpl();

    private TripPrice readyTripPrice;

    @BeforeClass
    public void init() {
        readyBuilder.withTransportPrice(1500).withHotelPrice(1500).withFullPrice(5000);

        readyTripPrice = readyBuilder.build();
    }

    @Test
    public void testWithFullPrice() {
        tripPriceBuilder.withFullPrice(5000);

        assertEquals(readyBuilder.getFullPrice(),tripPriceBuilder.getFullPrice());
    }

    @Test
    public void testWithTransportPrice() {
        tripPriceBuilder.withTransportPrice(1500);

        assertEquals(readyBuilder.getTransportPrice(),tripPriceBuilder.getTransportPrice());
    }

    @Test
    public void testWithHotelPrice() {
        tripPriceBuilder.withHotelPrice(1500);

        assertEquals(readyBuilder.getHotelPrice(),tripPriceBuilder.getHotelPrice());
    }

    @Test
    public void testBuild() {
        tripPriceBuilder.withTransportPrice(1500).withHotelPrice(1500).withFullPrice(5000);
        TripPrice actualTripPrice = tripPriceBuilder.build();

        assertEquals(readyTripPrice,actualTripPrice);
    }
}