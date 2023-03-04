package ru.springbootjpa.spring.Controller;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.springbootjpa.spring.Dto.CustomerDto;
import ru.springbootjpa.spring.Repository.CustomerRepository;
import ru.springbootjpa.spring.Service.CustomerServices;

import java.util.List;
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
        logger.info("Get mapping!");
        return customerServices.getAllCustomer();
    }
}
