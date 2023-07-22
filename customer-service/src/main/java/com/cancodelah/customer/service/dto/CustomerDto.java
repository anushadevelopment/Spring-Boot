package com.cancodelah.customer.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class CustomerDto {
    private long customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerAddress;
    private String customerCountry;
    private Date customerDob;

}

