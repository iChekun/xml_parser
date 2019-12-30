package by.trjava.xmlparsing.chekun.domain.entity;

import java.util.Objects;

public class HotelCharacteristic {

    private final int hotelLevel;

    private final FoodType foodType;

    private final int roomsCount;

    private final boolean isTVAvailable;

    private final boolean isAirConditionAvailable;


    public HotelCharacteristic(int hotelLevel, FoodType foodType, int roomsCount, boolean isTVAvailable, boolean isAirConditionAvailable) {
        this.hotelLevel = hotelLevel;
        this.foodType = foodType;
        this.roomsCount = roomsCount;
        this.isTVAvailable = isTVAvailable;
        this.isAirConditionAvailable = isAirConditionAvailable;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelCharacteristic that = (HotelCharacteristic) o;
        return hotelLevel == that.hotelLevel &&
                roomsCount == that.roomsCount &&
                isTVAvailable == that.isTVAvailable &&
                isAirConditionAvailable == that.isAirConditionAvailable &&
                foodType == that.foodType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelLevel, foodType, roomsCount, isTVAvailable, isAirConditionAvailable);
    }

    @Override
    public String toString() {
        return "HotelCharacteristic@" +
                "hotelLevel=" + hotelLevel +
                ", foodType=" + foodType +
                ", roomsCount=" + roomsCount +
                ", getTVAvailable=" + isTVAvailable +
                ", getAirConditionAvailable=" + isAirConditionAvailable;
    }
}
