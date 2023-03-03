package ru.springbootjpa.spring;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
@ToString(exclude = "customer")
@JsonIgnoreProperties(value = { "customer" })
@Entity
public class Vaccination {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="vaccination_seq")
    @SequenceGenerator(name="vaccination_seq",
            sequenceName="vaccination_seq", allocationSize=1)
    private long vaccinationId;
    private String type_v;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",
                referencedColumnName = "customer_id"
                )
    //@JsonBackReference
    private Customer customer;
}
