package com.zuhlke.bg.camp.api;

import com.zuhlke.bg.camp.data.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ZooManagerControllerComponentTest {

    @Autowired
    private ZooManagerController zooManagerController;

    @MockBean
    private DataLoadService dataLoadServiceMock;

    @Test
    void getAllAnimals_noAnimals_emptyList() {
        when(dataLoadServiceMock.getAnimals()).thenReturn(new ArrayList<>());

        ResponseEntity<List<AnimalDto>> response = zooManagerController.getAllAnimals();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().isEmpty());
    }

    @Test
    void getAllAnimals_animalsPresent_nonEmptyList() {
        when(dataLoadServiceMock.getAnimals()).thenReturn(Collections.singletonList(defaultAnimal()));

        ResponseEntity<List<AnimalDto>> response = zooManagerController.getAllAnimals();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    private AnimalDto defaultAnimal() {
        return new AnimalDto("Evgeni", AnimalType.TIGER, 1, Gender.M, 8, Collections.singletonList(FoodType.MEAT));
    }
}