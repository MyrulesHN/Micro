package com.application.services.micro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private List<Address> address;

}
