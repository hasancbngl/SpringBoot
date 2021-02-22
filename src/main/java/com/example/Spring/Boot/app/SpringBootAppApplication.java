package com.example.Spring.Boot.app;

import com.example.Spring.Boot.app.Customer.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

	@GetMapping
	public List<Customer> customerList() {
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
