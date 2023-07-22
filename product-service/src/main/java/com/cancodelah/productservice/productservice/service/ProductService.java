package com.cancodelah.productservice.productservice.service;

import com.cancodelah.productservice.productservice.entity.Products;
import com.cancodelah.productservice.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Products saveCard(Products products) {
        return productRepository.save(products);
    }

    public Products findCardById(Long cardId) {
        return productRepository.findByCardId(cardId);
    }
}
