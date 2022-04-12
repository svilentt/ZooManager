package com.zuhlke.bg.camp.data;

public class FoodDto {
    private final String name;
    private final FoodType type;
    private final double price;
    private final PriceUnit priceUnit;

    public FoodDto(String name, FoodType type, double price, PriceUnit priceUnit) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.priceUnit = priceUnit;
    }

    public String getName() {
        return name;
    }

    public FoodType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public PriceUnit getPriceUnit() {
        return priceUnit;
    }
}
