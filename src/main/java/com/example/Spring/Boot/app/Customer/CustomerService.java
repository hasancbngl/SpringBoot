package com.example.Spring.Boot.app.Customer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    public List<Customer> getCustomers() {
        return List.of(
                new Customer(
                        1L,
                        "Mariam",
                        25,
                        "1234@test.com"
                )
        );
    }
}
