package ru.springbootjpa.spring.Dto;

import lombok.*;

@Data
public class VaccinationDto {
    private String typeV;

    public VaccinationDto(String typeV) {
        this.typeV = typeV;
    }
}
