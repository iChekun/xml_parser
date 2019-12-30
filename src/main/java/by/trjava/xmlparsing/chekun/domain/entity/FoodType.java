package by.trjava.xmlparsing.chekun.domain.entity;

public enum FoodType {
    BB("Bed&Breakfast"),
    НВ("Нalf-Board"),
    FB("Full-Board"),
    AI("All-Inclusive"),
    UAI("Ultra-All-Inclusive"),
    NA("Not-Available"),
    RO("Room-Only");


    private String name;

    private FoodType(final String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return this.name;
    }

}
