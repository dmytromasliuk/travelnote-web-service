package com.example.travelnotewebservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("countries")
    private Set<City> cities = new HashSet<City>();

    @OneToOne(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("contacts")
    private Profile profile;

}
