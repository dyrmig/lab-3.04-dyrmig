package com.dyrmig.lab304.repository;

import com.dyrmig.lab304.model.Customer;
import com.dyrmig.lab304.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FlightRepositoryTest {
    @Autowired
    private FlightRepository flightRepository;
    private Flight flight1;
    private Flight flight2;
    private Flight flight3;
    @BeforeEach
    void setUp() {
        flight1 = new Flight("DS12",234,1);
        flight2 = new Flight("DS13",501,1);
        flight3 = new Flight("DS14",1234,1);
    }

    @AfterEach
    void tearDown() {
        flightRepository.deleteAll();
    }
    @Test
    void save_flight_insertFlight(){
        flightRepository.save(flight1);
        List<Flight> flightList = flightRepository.findAll();
        assertEquals(1, flightList.size());
        assertEquals("DS12", flightList.get(0).getNumber());
    }
    @Test
    void findByNumber() {
        flightRepository.save(flight1);
        flightRepository.save(flight2);
        List<Flight> flightList = flightRepository.findByNumber("DS12");
        assertEquals(1, flightList.size());
    }

    @Test
    void findByMileageGreaterThan() {
        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);
        List<Flight> flightList = flightRepository.findByMileageGreaterThan(500);
        assertEquals(2, flightList.size());
    }
}