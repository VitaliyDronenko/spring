package ru.springbootjpa.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository, CustomerServices customerServices) {
        this.customerRepository = customerRepository;
        this.customerServices = customerServices;
    }

    private final CustomerServices customerServices;
    @GetMapping("/customer")
    List<CustomerDTO> allCustomer () {
        return customerServices.getAllCustomer();
    }
}
