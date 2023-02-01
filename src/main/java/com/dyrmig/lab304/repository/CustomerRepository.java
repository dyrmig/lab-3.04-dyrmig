package com.dyrmig.lab304.repository;

import com.dyrmig.lab304.model.Customer;
import com.dyrmig.lab304.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByName(String name);
    List<Customer> findByStatus(Status status);
}
