package ru.springbootjpa.spring.Dto;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class CustomerDto {
//    private final long customerId;
    private String fName;
    private String lName;
//    private final Integer age;
//    private final String status;
//    private final String city;
    @Builder.Default
    private List<VaccinationDto> vaccinations = new ArrayList<>();

    public CustomerDto(String fName, String lName, List<VaccinationDto> vaccinations) {
        this.fName = fName;
        this.lName = lName;
        this.vaccinations = vaccinations;
    }
}
