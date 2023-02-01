package com.dyrmig.lab304.model;

import jakarta.persistence.*;

@Entity
public class Flight {
    @Id // hace que esta property sea una Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //= AUTO INCREMENT
    private Integer id;
    @Column(name = "flight_number")
    private String number;
    @Column(name = "flight_mileage")
    private Integer mileage;
    @Column(name = "aircraft_id")
    private Integer aircraft;

    public Flight() {
    }
    public Flight(String number, Integer mileage, Integer aircraft) {
        this.number = number;
        this.mileage = mileage;
        this.aircraft = aircraft;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getAircraft() {
        return aircraft;
    }

    public void setAircraft(Integer aircraft) {
        this.aircraft = aircraft;
    }
}