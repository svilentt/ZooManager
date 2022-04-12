package com.zuhlke.bg.camp.service;

import com.zuhlke.bg.camp.data.AnimalDto;
import com.zuhlke.bg.camp.data.AnimalType;
import com.zuhlke.bg.camp.data.FoodDto;
import com.zuhlke.bg.camp.data.Gender;

import java.util.List;

public class AnimalDetails {
    private final String name;
    private final AnimalType animalType;
    private final int age;
    private final Gender gender;
    private final int cageNumber;
    private final List<FoodDto> acceptableFood;

    public AnimalDetails(AnimalDto animalDto, List<FoodDto> acceptableFood) {
        this.name = animalDto.getName();
        this.animalType = animalDto.getType();
        this.age = animalDto.getAge();
        this.gender = animalDto.getGender();
        this.cageNumber = animalDto.getCageNumber();
        this.acceptableFood = acceptableFood;
    }

    public String getName() {
        return name;
    }

    public AnimalType getAnimalType() {
        return animalType;
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

    public List<FoodDto> getAcceptableFood() {
        return acceptableFood;
    }
}
