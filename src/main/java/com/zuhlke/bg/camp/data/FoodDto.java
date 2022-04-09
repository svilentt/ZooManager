package com.zuhlke.bg.camp.data;

public class FoodDto {
    private final String name;
    private final FoodType type;
    private final double pricePerKg;

    public FoodDto(String name, FoodType type, double pricePerKg) {
        this.name = name;
        this.type = type;
        this.pricePerKg = pricePerKg;
    }

    public String getName() {
        return name;
    }

    public FoodType getType() {
        return type;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }
}
