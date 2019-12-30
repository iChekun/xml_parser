package by.trjava.xmlparsing.chekun.domain.parser.impl;

import by.trjava.xmlparsing.chekun.domain.builder.impl.HotelCharacteristicBuilderImpl;
import by.trjava.xmlparsing.chekun.domain.builder.impl.TouristVoucherBuilderImpl;
import by.trjava.xmlparsing.chekun.domain.entity.FoodType;
import by.trjava.xmlparsing.chekun.domain.entity.TouristVoucher;
import by.trjava.xmlparsing.chekun.domain.parser.XmlParser;
import by.trjava.xmlparsing.chekun.domain.builder.HotelCharacteristicBuilder;
import by.trjava.xmlparsing.chekun.domain.builder.TouristVoucherBuilder;
import by.trjava.xmlparsing.chekun.domain.builder.TripPriceBuilder;
import by.trjava.xmlparsing.chekun.domain.builder.impl.TripPriceBuilderImpl;
import by.trjava.xmlparsing.chekun.domain.entity.HotelCharacteristic;
import by.trjava.xmlparsing.chekun.domain.entity.TripPrice;
import by.trjava.xmlparsing.chekun.domain.parser.exception.ParsingException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements XmlParser {

    private List<TouristVoucher> touristVouchers;

    @Override
    public List<TouristVoucher> parse(final InputStream xmlInputStream) throws ParsingException {

        touristVouchers = new ArrayList<>(500);
        final String tagName = "tourist-voucher";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(xmlInputStream);

            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName(tagName);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                parseNode(node);
            }

            return touristVouchers;
        } catch (ParserConfigurationException e) {
            throw new ParsingException("Parser configuration error: " + e.getMessage());
        } catch (SAXException e) {
            throw new ParsingException("DOM parser error: " + e.getMessage());
        } catch (IOException e) {
            throw new ParsingException("I/O error: " + e.getMessage());
        }
    }


    private void parseNode(final Node node) {

        Element touristVoucherElement = (Element) node;
        /////////////////////////////////////////////////////////////
        String id = getId(touristVoucherElement);

        String type = getType(touristVoucherElement);

        String country = getCountry(touristVoucherElement);

        int numberDays = getNumberDays(touristVoucherElement);

        String transport = getTransport(touristVoucherElement);

        String departureDate = getDepartureDate(touristVoucherElement);

        ///HotelCharacteristic

        int hotelLevel = getHotelLevel(touristVoucherElement);

        FoodType foodType = getFoodType(touristVoucherElement);

        int roomsCount = getRoomsCount(touristVoucherElement);

        boolean isTvAvailable = getTVAvailability(touristVoucherElement);

        boolean isAirConditionAvailable = getAirConditionAvailability(touristVoucherElement);


        ///TripPrice
        double fullPrice = getFullPrice(touristVoucherElement);

        double transportPrice = getTransportPrice(touristVoucherElement);

        double hotelPrice = getHotelPrice(touristVoucherElement);


        /////////////////////////////////////////////////////////////

        TripPriceBuilder tripPriceBuilder = new TripPriceBuilderImpl();

        TripPrice tripPrice = tripPriceBuilder.withTransportPrice(transportPrice)
                                                .withHotelPrice(hotelPrice)
                                                .withFullPrice(fullPrice)
                                                .build();

        /////////////////////////////////////////////////////////////
        HotelCharacteristicBuilder hotelCharacteristicBuilder = new HotelCharacteristicBuilderImpl();

        HotelCharacteristic hotelCharacteristic = hotelCharacteristicBuilder.withHotelLevel(hotelLevel)
                                                .withAirConditionAvailability(isAirConditionAvailable)
                                                .withFoodType(foodType)
                                                .withRoomsCount(roomsCount)
                                                .withTVAvailability(isTvAvailable)
                                                .build();

        /////////////////////////////////////////////////////////////
        TouristVoucherBuilder touristVoucherBuilder = new TouristVoucherBuilderImpl(id);

        TouristVoucher touristVoucher = touristVoucherBuilder.withType(type)
                                                .withCountry(country)
                                                .withDaysNumber(numberDays)
                                                .withTransport(transport)
                                                .withDepartureDate(departureDate)
                                                .withHotelCharacteristic(hotelCharacteristic)
                                                .withTripPrice(tripPrice)
                                                .build();

        /////////////////////////////////////////////////////////////
        touristVouchers.add(touristVoucher);
    }

    /**
     * @param element node with information about tariff.
     * @param name    name of element.
     * @return element its by name.
     */
    private String getElement(final Element element,final String name) {
        return element.getElementsByTagName(name)
                      .item(0)
                      .getTextContent();
    }


    private String getId(final Element touristVoucherElement) {
        return touristVoucherElement.getAttribute("id");
    }

    private String getType(final Element touristVoucherElement) {
        return getElement(touristVoucherElement, "type");
    }

    private String getCountry(final Element touristVoucherElement) {
        return getElement(touristVoucherElement, "country");
    }

    private int getNumberDays(final Element touristVoucherElement) {
        return Integer.parseInt(getElement(touristVoucherElement, "number-days"));
    }

    private String getTransport(final Element touristVoucherElement) {
        return getElement(touristVoucherElement, "transport");
    }

    private String getDepartureDate(final Element touristVoucherElement) {
        return getElement(touristVoucherElement, "departure-date");
    }


    ///HotelCharacteristic
    private int getHotelLevel(final Element touristVoucherElement) {
        return Integer.parseInt(getElement(touristVoucherElement, "hotel-level"));
    }

    private FoodType getFoodType(final Element touristVoucherElement) {
        String foodType = getElement(touristVoucherElement, "food-type");
        return FoodType.valueOf(foodType);
    }

    private int getRoomsCount(final Element touristVoucherElement) {
        return Integer.parseInt(getElement(touristVoucherElement, "rooms-count"));
    }

    private boolean getTVAvailability(final Element touristVoucherElement) {
        return Boolean.parseBoolean(getElement(touristVoucherElement, "is-TV-available"));
    }

    private boolean getAirConditionAvailability(final Element touristVoucherElement) {
        return Boolean.parseBoolean(getElement(touristVoucherElement, "is-air-condition-available"));
    }


    //////TripPrice
    private double getFullPrice(final Element touristVoucherElement) {
        return Double.parseDouble(getElement(touristVoucherElement, "full-price"));
    }

    private double getTransportPrice(final Element touristVoucherElement) {
        return Double.parseDouble(getElement(touristVoucherElement, "transport-price"));
    }

    private double getHotelPrice(final Element touristVoucherElement) {
        return Double.parseDouble(getElement(touristVoucherElement, "hotel-price"));
    }


}
