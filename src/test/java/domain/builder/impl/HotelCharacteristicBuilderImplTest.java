package domain.builder.impl;


import by.trjava.xmlparsing.chekun.domain.builder.impl.HotelCharacteristicBuilderImpl;
import by.trjava.xmlparsing.chekun.domain.entity.FoodType;
import by.trjava.xmlparsing.chekun.domain.entity.HotelCharacteristic;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HotelCharacteristicBuilderImplTest {

    private HotelCharacteristicBuilderImpl hotelCharacteristicBuilder = new HotelCharacteristicBuilderImpl();

    private HotelCharacteristicBuilderImpl readyBuilder = new HotelCharacteristicBuilderImpl();

    private HotelCharacteristic hotelCharacteristic;

    @BeforeClass
    public void init() {
        readyBuilder.withHotelLevel(2)
                .withFoodType(FoodType.BB)
                .withRoomsCount(2)
                .withTVAvailability(false)
                .withAirConditionAvailability(false);

        hotelCharacteristic = new HotelCharacteristic(2, FoodType.BB, 2, false, false);
    }

    @Test
    public void testWithHotelLevel() {
        hotelCharacteristicBuilder.withHotelLevel(2);

        assertEquals(readyBuilder.getHotelLevel(), hotelCharacteristicBuilder.getHotelLevel());
    }

    @Test
    public void testWithFoodType() {
        hotelCharacteristicBuilder.withHotelLevel(2);

        assertEquals(readyBuilder.getHotelLevel(), hotelCharacteristicBuilder.getHotelLevel());
    }

    @Test
    public void testWithRoomsCount() {
        hotelCharacteristicBuilder.withRoomsCount(2);

        assertEquals(readyBuilder.getRoomsCount(), hotelCharacteristicBuilder.getRoomsCount());
    }

    @Test
    public void testWithTVAvailability() {
        hotelCharacteristicBuilder.withTVAvailability(false);

        assertEquals(readyBuilder.getIsTVAvailable(), hotelCharacteristicBuilder.getIsTVAvailable());
    }

    @Test
    public void testWithAirConditionAvailability() {
        hotelCharacteristicBuilder.withAirConditionAvailability(false);

        assertEquals(readyBuilder.getIsAirConditionAvailable(), hotelCharacteristicBuilder.getIsAirConditionAvailable());
    }

    @Test
    public void testBuild() {

        hotelCharacteristicBuilder.withHotelLevel(2)
                .withFoodType(FoodType.BB)
                .withRoomsCount(2)
                .withTVAvailability(false)
                .withAirConditionAvailability(false);

        HotelCharacteristic actualHotelCharacteristic = hotelCharacteristicBuilder.build();

        assertEquals(hotelCharacteristic, actualHotelCharacteristic);
    }
}