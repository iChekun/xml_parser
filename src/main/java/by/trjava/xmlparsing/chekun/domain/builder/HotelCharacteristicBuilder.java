package by.trjava.xmlparsing.chekun.domain.builder;

import by.trjava.xmlparsing.chekun.domain.entity.FoodType;
import by.trjava.xmlparsing.chekun.domain.entity.HotelCharacteristic;

public interface HotelCharacteristicBuilder {

    HotelCharacteristic build();

    HotelCharacteristicBuilder withHotelLevel(int hotelLevel);

    HotelCharacteristicBuilder withFoodType(FoodType foodType);

    HotelCharacteristicBuilder withRoomsCount(int roomsCount);

    HotelCharacteristicBuilder withTVAvailability(boolean isTVAvailable);

    HotelCharacteristicBuilder withAirConditionAvailability(boolean isAirConditionAvailable);
}
