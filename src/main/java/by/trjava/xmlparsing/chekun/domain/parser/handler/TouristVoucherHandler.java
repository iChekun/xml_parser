package by.trjava.xmlparsing.chekun.domain.parser.handler;

import by.trjava.xmlparsing.chekun.domain.builder.HotelCharacteristicBuilder;
import by.trjava.xmlparsing.chekun.domain.builder.TouristVoucherBuilder;
import by.trjava.xmlparsing.chekun.domain.builder.TripPriceBuilder;
import by.trjava.xmlparsing.chekun.domain.builder.impl.HotelCharacteristicBuilderImpl;
import by.trjava.xmlparsing.chekun.domain.builder.impl.TouristVoucherBuilderImpl;
import by.trjava.xmlparsing.chekun.domain.builder.impl.TripPriceBuilderImpl;
import by.trjava.xmlparsing.chekun.domain.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class TouristVoucherHandler extends DefaultHandler {


    private List<TouristVoucher> touristVouchers = new ArrayList<>();

    private TouristVoucherBuilder touristVoucherBuilder;
    private TripPriceBuilder tripPriceBuilder;
    private HotelCharacteristicBuilder hotelCharacteristicBuilder;


    private StringBuilder data = new StringBuilder();

    private TripParameter currentParameter;


    public List<TouristVoucher> getTouristVouchers() {
        return touristVouchers;
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        data = new StringBuilder(); //!!!!!!!!!!!!

        switch (qName) {
            case "tourist-voucher": {
                String id = attributes.getValue("id");

                touristVoucherBuilder = new TouristVoucherBuilderImpl(id);

                tripPriceBuilder = new TripPriceBuilderImpl();

                hotelCharacteristicBuilder = new HotelCharacteristicBuilderImpl();
            }
            break;
            case "type":
                currentParameter = TripParameter.TYPE;
                break;
            case "country":
                currentParameter = TripParameter.COUNTRY;
                break;
            case "number-days":
                currentParameter = TripParameter.NUMBER_DAYS;
                break;
            case "transport":
                currentParameter = TripParameter.TRANSPORT;
                break;
            case "hotel-level":
                currentParameter = TripParameter.HOTEL_LEVEL;
                break;
            case "food-type":
                currentParameter = TripParameter.FOOD_TYPE;
                break;
            case "rooms-count":
                currentParameter = TripParameter.ROOMS_COUNT;
                break;
            case "is-TV-available":
                currentParameter = TripParameter.IS_TV_AVAILABLE;
                break;
            case "is-air-condition-available":
                currentParameter = TripParameter.IS_AIR_CONDITION_AVAILABLE;
                break;
            case "full-price":
                currentParameter = TripParameter.FULL_PRICE;
                break;
            case "transport-price":
                currentParameter = TripParameter.TRANSPORT_PRICE;
                break;
            case "hotel-price":
                currentParameter = TripParameter.HOTEL_PRICE;
                break;
            case "departure-date":
                currentParameter = TripParameter.DEPARTURE_DATE;
                break;
            default:
                break;
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(new String(ch, start, length));
    }


    @Override
    public void endElement(String uri, String localName, String qName) {

        switch (currentParameter) {
            case TYPE:
                touristVoucherBuilder.withType(data.toString());
                break;
            case COUNTRY:
                touristVoucherBuilder.withCountry(data.toString());
                break;
            case NUMBER_DAYS:
                touristVoucherBuilder.withDaysNumber(Integer.parseInt(data.toString()));
                break;
            case TRANSPORT:
                touristVoucherBuilder.withTransport(data.toString());
                break;
            case HOTEL_LEVEL:
                hotelCharacteristicBuilder.withHotelLevel(Integer.parseInt(data.toString()));
                break;
            case FOOD_TYPE:
                final FoodType foodType = FoodType.valueOf(data.toString());
                hotelCharacteristicBuilder.withFoodType(foodType);
                break;
            case ROOMS_COUNT:
                hotelCharacteristicBuilder.withRoomsCount(Integer.parseInt(data.toString()));
                break;
            case IS_TV_AVAILABLE:
                hotelCharacteristicBuilder.withTVAvailability(Boolean.parseBoolean(data.toString()));
                break;
            case IS_AIR_CONDITION_AVAILABLE:
                hotelCharacteristicBuilder.withAirConditionAvailability(Boolean.parseBoolean(data.toString()));
                break;
            case FULL_PRICE:
                tripPriceBuilder.withFullPrice(Double.parseDouble(data.toString()));
                break;
            case HOTEL_PRICE:
                tripPriceBuilder.withHotelPrice(Double.parseDouble(data.toString()));
                break;
            case TRANSPORT_PRICE:
                tripPriceBuilder.withTransportPrice(Double.parseDouble(data.toString()));
                break;
            case DEPARTURE_DATE:
                touristVoucherBuilder.withDepartureDate(data.toString().trim());
                break;
            default:
                break;
        }

        createTouristVoucher(qName);
    }

    private void createTouristVoucher(final String qName) {
        if ("tourist-voucher".equals(qName)) {

            HotelCharacteristic hotelCharacteristic = hotelCharacteristicBuilder.build();
            touristVoucherBuilder.withHotelCharacteristic(hotelCharacteristic);

            TripPrice tripPrice = tripPriceBuilder.build();
            touristVoucherBuilder.withTripPrice(tripPrice);

            TouristVoucher touristVoucher = touristVoucherBuilder.build();
            touristVouchers.add(touristVoucher);
        }
    }

}
