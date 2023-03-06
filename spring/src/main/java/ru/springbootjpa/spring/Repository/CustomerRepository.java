package ru.springbootjpa.spring.Repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.springbootjpa.spring.Entity.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findCustomerByCity(String city);
}
