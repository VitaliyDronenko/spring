package ru.springbootjpa.spring.Controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import ru.springbootjpa.spring.Dto.CustomerDto;
import ru.springbootjpa.spring.Entity.Customer;
import ru.springbootjpa.spring.Repository.CustomerRepository;
import ru.springbootjpa.spring.Service.CustomerServices;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    Properties prop = new Properties();
    public CustomerController(CustomerRepository customerRepository, CustomerServices customerServices) {
        this.customerRepository = customerRepository;
        this.customerServices = customerServices;
    }
    static Logger logger = Logger.getLogger(CustomerController.class);

    private final CustomerServices customerServices;
    @GetMapping("/customer")
    List<CustomerDto> allCustomer () {
        logger.info("Get - customer!");
        return customerServices.getAllCustomer();
    }

    @PostMapping("/customer_add")
    Customer newCustomer(@RequestBody Customer customer) {
        logger.info("Post - customer_add");
        return customerServices.newCustomer(customer);
    }

    @GetMapping("/customer/{city}")
    Optional<Customer> findByCity (@PathVariable String city) {
        logger.info("Get - " + city);
        return customerServices.findByCity(city);
    }

    @DeleteMapping("/customer/{id}")
    void deleteCustomer(@PathVariable Long id) {
        logger.info("Delete customer id = " + id);
        customerServices.deleteCustomer(id);
    }
}
