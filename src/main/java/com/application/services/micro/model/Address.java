package com.application.services.micro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Address {

    private int houseNumber;
    private String streetNumber;
    private String streetName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipcode;
    private String country;
    private String phone;
}
