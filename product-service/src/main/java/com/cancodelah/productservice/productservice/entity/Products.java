package com.cancodelah.productservice.productservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cardId;
    private String cardType;
    private String cardName;
    private String bank;
    private Date validityFrom;
    private Date validityTo;
}
