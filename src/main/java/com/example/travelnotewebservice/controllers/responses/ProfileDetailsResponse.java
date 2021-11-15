package com.example.travelnotewebservice.controllers.responses;

import jdk.jfr.ContentType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProfileDetailsResponse {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final String country;

}
