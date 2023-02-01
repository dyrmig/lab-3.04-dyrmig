package com.dyrmig.lab304.model;

import jakarta.persistence.*;

import java.util.logging.Level;

@Entity
public class Customer {
    @Id // hace que esta property sea una Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //= AUTO INCREMENT
    private Integer id;
    @Column(name = "customer_name")
    private String name;
    @Column(name = "customer_status")
    private Status status;

    public Customer() {
    }

    public Customer(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
