package by.trjava.xmlparsing.chekun.domain.parser.impl;

import by.trjava.xmlparsing.chekun.domain.builder.impl.TouristVoucherBuilderImpl;
import by.trjava.xmlparsing.chekun.domain.builder.HotelCharacteristicBuilder;
import by.trjava.xmlparsing.chekun.domain.builder.TouristVoucherBuilder;
import by.trjava.xmlparsing.chekun.domain.builder.TripPriceBuilder;
import by.trjava.xmlparsing.chekun.domain.builder.impl.HotelCharacteristicBuilderImpl;
import by.trjava.xmlparsing.chekun.domain.builder.impl.TripPriceBuilderImpl;
import by.trjava.xmlparsing.chekun.domain.entity.*;
import by.trjava.xmlparsing.chekun.domain.parser.XmlParser;
import by.trjava.xmlparsing.chekun.domain.parser.exception.ParsingException;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static javax.xml.stream.XMLStreamConstants.*;

public class StaxParser implements XmlParser {

    private List<TouristVoucher> touristVouchers;

    private TouristVoucherBuilder touristVoucherBuilder;

    private TripPriceBuilder tripPriceBuilder;

    private HotelCharacteristicBuilder hotelCharacteristicBuilder;

    private TripParameter currentParameter = TripParameter.FREE;


    @Override
    public List<TouristVoucher> parse(final InputStream xmlInputStream) throws ParsingException {
        touristVouchers = new ArrayList<>();

        try {
            final XMLInputFactory factory = XMLInputFactory.newInstance();
            final XMLEventReader eventReader = factory.createXMLEventReader(xmlInputStream);

            while (eventReader.hasNext()) {
                final XMLEvent event = eventReader.nextEvent();
                chooseEventElement(event);
            }

            return touristVouchers;
        } catch (NoSuchElementException | XMLStreamException e) {
            throw new ParsingException("XML Stream error: " + e.getMessage());
        }

    }

    private final void chooseEventElement(final XMLEvent event) {
        switch (event.getEventType()) {
            case START_ELEMENT:
                startElement(event);
                break;
            case CHARACTERS:
                characters(event);
                break;
            case END_ELEMENT:
                endElement(event);
                break;
        }
    }

    private void startElement(final XMLEvent event) {
        StartElement startElement = event.asStartElement();
        String qName = startElement.getName().getLocalPart();

        switch (qName) {
            case "tourist-voucher": {
                Iterator<Attribute> iterator = startElement.getAttributes();
                String id = iterator.next().getValue();

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
        }
    }


    private void characters(final XMLEvent event) {
        Characters characters = event.asCharacters();
        String data = characters.getData();

        switch (currentParameter) {
            case TYPE:
                touristVoucherBuilder.withType(data);
                break;
            case COUNTRY:
                touristVoucherBuilder.withCountry(data);
                break;
            case NUMBER_DAYS:
                touristVoucherBuilder.withDaysNumber(Integer.parseInt(data));
                break;
            case TRANSPORT:
                touristVoucherBuilder.withTransport(data);
                break;
            case HOTEL_LEVEL:
                hotelCharacteristicBuilder.withHotelLevel(Integer.parseInt(data));
                break;
            case FOOD_TYPE:
                FoodType foodType = FoodType.valueOf(data);
                hotelCharacteristicBuilder.withFoodType(foodType);
                break;
            case ROOMS_COUNT:
                hotelCharacteristicBuilder.withRoomsCount(Integer.parseInt(data));
                break;
            case IS_TV_AVAILABLE:
                hotelCharacteristicBuilder.withTVAvailability(Boolean.parseBoolean(data));
                break;
            case IS_AIR_CONDITION_AVAILABLE:
                hotelCharacteristicBuilder.withAirConditionAvailability(Boolean.parseBoolean(data));
                break;
            case FULL_PRICE:
                tripPriceBuilder.withFullPrice(Double.parseDouble(data));
                break;
            case HOTEL_PRICE:
                tripPriceBuilder.withHotelPrice(Double.parseDouble(data));
                break;
            case TRANSPORT_PRICE:
                tripPriceBuilder.withTransportPrice(Double.parseDouble(data));
                break;
            case DEPARTURE_DATE:
                touristVoucherBuilder.withDepartureDate(data);
                break;
        }
        currentParameter = TripParameter.FREE;
    }

    private void endElement(final XMLEvent event) {
        EndElement endElement = event.asEndElement();
        final String tagName = endElement.getName().getLocalPart();
        final String expectedTagName = "tourist-voucher";

        if (expectedTagName.equals(tagName)) {
            final HotelCharacteristic hotelCharacteristic = hotelCharacteristicBuilder.build();
            final TripPrice tripPrice = tripPriceBuilder.build();

            TouristVoucher touristVoucher = touristVoucherBuilder.withHotelCharacteristic(hotelCharacteristic)
                                                                 .withTripPrice(tripPrice)
                                                                 .build();
            touristVouchers.add(touristVoucher);
        }
    }
}
