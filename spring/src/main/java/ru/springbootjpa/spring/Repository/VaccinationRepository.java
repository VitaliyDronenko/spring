package ru.springbootjpa.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.springbootjpa.spring.Entity.Vaccination;

public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {
}
