package com.zuhlke.bg.camp.service;

import com.zuhlke.bg.camp.api.exception.AnimalNotFoundException;
import com.zuhlke.bg.camp.data.AnimalDto;
import com.zuhlke.bg.camp.data.DataLoadService;
import com.zuhlke.bg.camp.data.FoodDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
@Service
public class ZooManagerService {
    private final DataLoadService dataLoadService;

    ZooManagerService(DataLoadService dataLoadService) {
        this.dataLoadService = dataLoadService;
    }

    public List<AnimalDto> getAnimals() {
        return dataLoadService.getAnimals();
    }

    public AnimalDetails getAnimalDetails(String name) {
        AnimalDto animalDto = getAnimals().stream()
                .filter(currentAnimal -> currentAnimal.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new AnimalNotFoundException("Couldn't find animal with name=" + name));

        List<FoodDto> possibleFoods = dataLoadService.getFoods().stream()
                .filter(food -> animalDto.getFoodTypes().contains(food.getType()))
                .collect(Collectors.toList());

        return new AnimalDetails(animalDto, possibleFoods);
    }
}
