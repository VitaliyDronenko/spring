package ru.springbootjpa.spring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Data
public class VaccinationDTO {
    private String typeV;

    public VaccinationDTO(String typeV) {
        this.typeV = typeV;
    }
}
