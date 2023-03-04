package ru.springbootjpa.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.springbootjpa.spring.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
