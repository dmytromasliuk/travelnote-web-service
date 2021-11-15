package com.example.travelnotewebservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Data
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street;
    private String building;
    private String apartment;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonIgnoreProperties("addresses")
    private City city;

    public Address(String street, String building, String apartment, City city) {
        this.street = street;
        this.building = building;
        this.apartment = apartment;
        this.city = city;
    }

}
