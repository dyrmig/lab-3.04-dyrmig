package com.dyrmig.lab304.model;

import jakarta.persistence.*;

@Entity
public class Aircraft {
    @Id // hace que esta property sea una Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //= AUTO INCREMENT
    private Integer id;
    @Column(name = "aircraft_name")
    private String model;
    @Column(name = "aircraft_seats")
    private Integer seats;

    public Aircraft() {
    }

    public Aircraft(String model, Integer seats) {
        this.model = model;
        this.seats = seats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}
