package com.example.travelnotewebservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("profiles")
    private User user;

    @OneToOne
    @JoinColumn(name = "contacts_id", referencedColumnName = "id")
    @JsonIgnoreProperties("profiles")
    private Contacts contacts;

    @OneToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @JsonIgnoreProperties("profiles")
    private Country country;

    public Profile(User user, Contacts contacts) {
        this.user = user;
        this.contacts = contacts;
    }
}
