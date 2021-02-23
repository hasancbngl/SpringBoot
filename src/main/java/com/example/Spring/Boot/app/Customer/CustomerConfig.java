package com.example.Spring.Boot.app.Customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            Customer mariam = new Customer(
                    "Mariam",
                    25,
                    "1234@test.com"
            );

            Customer hasan = new Customer(
                    "Hasan",
                    24,
                    "1234@test.com"
            );

            customerRepository.saveAll(
                    List.of(mariam, hasan)
            );
        };
    }
}