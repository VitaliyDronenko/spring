package ru.springbootjpa.spring.Service;

import org.springframework.stereotype.Service;
import ru.springbootjpa.spring.Dto.CustomerDto;
import ru.springbootjpa.spring.Dto.VaccinationDto;
import ru.springbootjpa.spring.Entity.Customer;
import ru.springbootjpa.spring.Repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServices {
    private final CustomerRepository customerRepository;

    public CustomerServices(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDto> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        List<CustomerDto> customerDTOS = new ArrayList<>();
        customers=customerRepository.findAll();
        List<CustomerDto> collect = customers.stream()
                .map(e -> CustomerDto.builder()
                        .lName(e.getLName())
                        .fName(e.getFName())
                        .vaccinations(e.getVaccinations()
                                .stream().map(v-> new VaccinationDto(v.getType_v()))
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());

        return collect;
    }

    public Customer newCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> findByCity(String city) {
        return customerRepository.findCustomerByCity(city);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
