package com.cancodelah.customer.service.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerAddress;
    private String customerCountry;
    private Date customerDob;
}
