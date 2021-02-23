package com.example.Spring.Boot.app.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {
       Optional<Customer> customerByEmail = customerRepository
               .findCustomerByEmail(customer.getEmail());
        Optional<Customer> customerByAgeGreaterNotContain =  customerRepository
                .findCustomerByAgeIsGreaterThanAndFullNameNotContaining(customer.getAge(),"e");
        if(customerByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId) {
       boolean exists =  customerRepository.existsById(customerId);

       if(!exists) {
           throw new IllegalStateException(customerId + "Customer doesnt exist!");
       }
       customerRepository.deleteById(customerId);
    }


    public void updateCustomer(Long customerId, String fullName, String email) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() ->new IllegalStateException(
                        customerId + " customer doesnt exists"
                ));

        if((fullName != null && fullName.length() > 0 && !Objects.equals(customer.getFullName(), fullName))) {
            customer.setFullName(fullName);
        }
        if((email != null && email.length() > 0 && !Objects.equals(customer.getEmail(), email))) {
            customer.setEmail(email);
        }
    }
}
