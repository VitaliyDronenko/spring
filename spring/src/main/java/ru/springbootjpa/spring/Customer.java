package ru.springbootjpa.spring;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer {
    @Id
    @Column(name="customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;

    private String fName;
    private String lName;
    private Integer age;
    private String status;
    private String city;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",
                referencedColumnName = "customer_id")
    //@JsonManagedReference
    private List<Vaccination> vaccinations;
}
