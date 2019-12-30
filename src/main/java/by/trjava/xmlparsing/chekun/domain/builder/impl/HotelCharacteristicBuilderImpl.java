package by.trjava.xmlparsing.chekun.domain.builder.impl;

import by.trjava.xmlparsing.chekun.domain.entity.FoodType;
import by.trjava.xmlparsing.chekun.domain.builder.HotelCharacteristicBuilder;
import by.trjava.xmlparsing.chekun.domain.entity.HotelCharacteristic;

public class HotelCharacteristicBuilderImpl implements HotelCharacteristicBuilder {

    private int hotelLevel;

    private FoodType foodType;

    private int roomsCount;

    private boolean isTVAvailable;

    private boolean isAirConditionAvailable;


    public HotelCharacteristicBuilderImpl() {
    }


    @Override
    public HotelCharacteristicBuilder withHotelLevel(int hotelLevel) {
        this.hotelLevel = hotelLevel;
        return this;
    }

    @Override
    public HotelCharacteristicBuilder withFoodType(FoodType foodType) {
        this.foodType = foodType;
        return this;
    }

    @Override
    public HotelCharacteristicBuilder withRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
        return this;
    }

    @Override
    public HotelCharacteristicBuilder withTVAvailability(boolean isTVAvailable) {
        this.isTVAvailable = isTVAvailable;
        return this;
    }

    @Override
    public HotelCharacteristicBuilder withAirConditionAvailability(boolean isAirConditionAvailable) {
        this.isAirConditionAvailable = isAirConditionAvailable;
        return this;
    }

    @Override
    public HotelCharacteristic build() {
        final HotelCharacteristic hotelCharacteristic = new HotelCharacteristic(hotelLevel, foodType, roomsCount, isTVAvailable, isAirConditionAvailable);
        return hotelCharacteristic;
    }


    public int getHotelLevel() {
        return hotelLevel;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public boolean getIsTVAvailable() {
        return isTVAvailable;
    }

    public boolean getIsAirConditionAvailable() {
        return isAirConditionAvailable;
    }


}
