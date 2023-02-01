package com.dyrmig.lab304.repository;

import com.dyrmig.lab304.model.Aircraft;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AircraftRepositoryTest {
    @Autowired //nos va a traer la implementacion de la siguente interfaz
    private AircraftRepository aircraftRepository;
    private Aircraft aircraft1;
    private Aircraft aircraft2;
    private Aircraft aircraft3;
    @BeforeEach
    void setUp() {
        aircraft1 = new Aircraft("Boeing 747", 400);
        aircraft2 = new Aircraft("Airbus A330", 236);
        aircraft3 = new Aircraft("Boeing 777", 264);
    }

    @AfterEach
    void tearDown() {
        aircraftRepository.deleteAll();
    }
    @Test
    void save_aircraft_insertAircraft(){
        aircraftRepository.save(aircraft1);
        List<Aircraft> aircraftList = aircraftRepository.findAll();
        assertEquals(1,aircraftList.size());
    }
    @Test
    void findByModelLike() {
        aircraftRepository.save(aircraft1);
        aircraftRepository.save(aircraft2);
        aircraftRepository.save(aircraft3);
        List<Aircraft> aircraftList = aircraftRepository.findByModelLike("%boeing%");
        assertEquals(2, aircraftList.size());
    }
}