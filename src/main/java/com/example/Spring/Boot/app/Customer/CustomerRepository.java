package com.example.Spring.Boot.app.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //find customer by se<rching their email

    //SELECT * FROM customer where email=?
    Optional<Customer> findCustomerByEmail(String email);

    //SELECT * FROM customer where age=? and name not containing =?
    Optional<Customer> findCustomerByAgeIsGreaterThanAndFullNameNotContaining(int age, String ch);
}