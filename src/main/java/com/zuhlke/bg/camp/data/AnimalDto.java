package com.zuhlke.bg.camp.data;

import java.util.List;

public class AnimalDto {
    private final String name;
    private final AnimalType type;
    private final int age;
    private final Gender gender;
    private final int cageNumber;
    private final List<FoodType> foodTypes;

    public AnimalDto(String name, AnimalType type, int age, Gender gender, int cageNumber, List<FoodType> foodTypes) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.gender = gender;
        this.cageNumber = cageNumber;
        this.foodTypes = foodTypes;
    }

    public String getName() {
        return name;
    }

    public AnimalType getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public int getCageNumber() {
        return cageNumber;
    }

    public List<FoodType> getFoodTypes() {
        return foodTypes;
    }
}
