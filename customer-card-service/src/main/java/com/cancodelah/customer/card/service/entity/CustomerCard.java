package com.cancodelah.customer.card.service.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCard {
    private long customerId;
    private String cardId;
    private String cardTypeId;

}
