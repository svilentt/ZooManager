package com.zuhlke.bg.camp.api;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;
import com.zuhlke.bg.camp.data.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@Provider("ZooManager")
@PactFolder("pacts")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ZooManagerControllerContractTest {

    @MockBean
    private DataLoadService dataLoadService;

    @BeforeEach
    void setUp(PactVerificationContext context, @Value("${local.server.port}") int port) {
        context.setTarget(new HttpTestTarget("localhost", port));
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void verifyPact(PactVerificationContext context) {
        context.verifyInteraction();
    }

    @State("Existing animal with one suitable food")
    void existingAnimalWithOneSuitableFood(Map<String, Object> params) {
        String animalName = (String) params.get("animalName");
        when(dataLoadService.getAnimals()).thenReturn(Arrays.asList(suitableFoodAnimal(animalName), defaultAnimal()));
        when(dataLoadService.getFoods()).thenReturn(Arrays.asList(suitableFood(), notSuitableFood()));
    }

    @State("Existing animal without suitable food")
    void existingAnimalWithoutSuitableFood(Map<String, Object> params) {
        String animalName = (String) params.get("animalName");
        when(dataLoadService.getAnimals()).thenReturn(Arrays.asList(suitableFoodAnimal(animalName), defaultAnimal()));
        when(dataLoadService.getFoods()).thenReturn(List.of(notSuitableFood()));
    }

    @State("Animal not found")
    void animalNotFound() {
        when(dataLoadService.getAnimals()).thenReturn(Collections.emptyList());
    }

    private AnimalDto suitableFoodAnimal(String name) {
        return new AnimalDto(name, AnimalType.TIGER, 1, Gender.M, 8, Collections.singletonList(FoodType.MEAT));
    }

    private AnimalDto defaultAnimal() {
        return new AnimalDto("Garga", AnimalType.HAWK, 4, Gender.F, 10, Collections.singletonList(FoodType.PLANT));
    }

    private FoodDto suitableFood() {
        return new FoodDto("Pork", FoodType.MEAT, 5.64, PriceUnit.KG);
    }

    private FoodDto notSuitableFood() {
        return new FoodDto("Corn", FoodType.PLANT, 2.34, PriceUnit.KG);
    }

}