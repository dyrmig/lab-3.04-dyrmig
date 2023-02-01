package com.dyrmig.lab304.repository;

import com.dyrmig.lab304.model.Customer;
import com.dyrmig.lab304.model.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer1;
    private Customer customer2;
    private Customer customer3;
    @BeforeEach
    void setUp() {
        customer1 = new Customer("Pepito", Status.GOLD);
        customer2 = new Customer("Lolito", Status.SILVER);
        customer3 = new Customer("Juanito", Status.SILVER);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void save_customer_insertCustomer(){
        customerRepository.save(customer1);
        List<Customer> allCustomers = customerRepository.findAll();
        assertEquals(1,allCustomers.size());
        assertEquals("Pepito", allCustomers.get(0).getName());
    }

    @Test
    void findByName_name_customer() {
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        List<Customer> customers = customerRepository.findByName("Lolito");
        assertEquals(1, customers.size());
        assertEquals("Lolito", customers.get(0).getName());
    }
    @Test
    void findByStatus_status_customers() {
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        List<Customer> customers = customerRepository.findByStatus(Status.SILVER);
        assertEquals(2, customers.size());
    }
}