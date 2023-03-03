package ru.springbootjpa.spring;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class CustomerDTO {
//    private final long customerId;
    private String fName;
    private String lName;
//    private final Integer age;
//    private final String status;
//    private final String city;
    @Builder.Default
    private List<VaccinationDTO> vaccinations = new ArrayList<>();

    public CustomerDTO(String fName, String lName, List<VaccinationDTO> vaccinations) {
        this.fName = fName;
        this.lName = lName;
        this.vaccinations = vaccinations;
    }
}
