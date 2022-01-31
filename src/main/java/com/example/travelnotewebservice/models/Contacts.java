package com.example.travelnotewebservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String phone;

    @OneToOne(mappedBy = "contacts", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("contacts")
    private Profile profile;

    public Contacts(String email) {
        this.email = email;
    }
}
