package ru.springbootjpa.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import ru.springbootjpa.spring.Entity.Customer;

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
