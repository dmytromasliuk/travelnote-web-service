package com.example.travelnotewebservice.controllers.requests;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProfileUpdateRequest {

    private final String phone;
    private final Long countryId;

}
