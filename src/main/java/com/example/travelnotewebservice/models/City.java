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
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonIgnoreProperties("cities")
    private Country country;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("cities")
    private Set<Address> addresses = new HashSet<Address>();

}
