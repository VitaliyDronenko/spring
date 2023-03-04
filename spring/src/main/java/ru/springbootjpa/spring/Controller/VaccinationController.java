package ru.springbootjpa.spring.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.springbootjpa.spring.Entity.Vaccination;
import ru.springbootjpa.spring.Repository.VaccinationRepository;

import java.util.List;

@RestController
public class VaccinationController {
    private final VaccinationRepository vaccinationRepository;

    public VaccinationController(VaccinationRepository vaccinationRepository) {
        this.vaccinationRepository = vaccinationRepository;
    }

    @GetMapping("/vaccination")
    List<Vaccination> allVaccinations () {
        return vaccinationRepository.findAll();
    }
}
