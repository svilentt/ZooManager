package com.zuhlke.bg.camp.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataLoadService {
    private final ObjectMapper objectMapper;
    private final ArrayList<AnimalDto> animals;
    private final ArrayList<FoodDto> foods;

    DataLoadService(ObjectMapper objectMapper) throws IOException {
        this.objectMapper = objectMapper;
        animals = loadAnimals();
        foods = loadFoods();
    }

    public List<AnimalDto> getAnimals() {
        return animals;
    }

    public List<FoodDto> getFoods() {
        return foods;
    }

    private ArrayList<AnimalDto> loadAnimals() throws IOException {
        File animals = new ClassPathResource("data/animals.json").getFile();
        return objectMapper.readValue(animals, new TypeReference<>() {});
    }

    private ArrayList<FoodDto> loadFoods() throws IOException {
        File foods = new ClassPathResource("data/foods.json").getFile();
        return objectMapper.readValue(foods, new TypeReference<>() {});
    }

}
