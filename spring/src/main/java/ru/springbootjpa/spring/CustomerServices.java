package ru.springbootjpa.spring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServices {
    private final CustomerRepository customerRepository;

    public CustomerServices(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        customers=customerRepository.findAll();
        List<CustomerDTO> collect = customers.stream()
                .map(e -> CustomerDTO.builder()
                        .lName(e.getLName())
                        .fName(e.getFName())
                        .vaccinations(e.getVaccinations()
                                .stream().map(v-> new VaccinationDTO(v.getType_v()))
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());

        return collect;
    }
}
