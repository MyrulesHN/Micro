package com.application.services.micro.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductEntity {
    private int productId;
    private String description;
    private String name;
    private int amount;
    private String inStock;
    private String brand;

}
