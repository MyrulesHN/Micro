package com.application.services.micro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderEntity {
    String orderId;
    Date deliverDate;
    Date arrivalDate;
    int total;
    String status;
    int productId;

}
