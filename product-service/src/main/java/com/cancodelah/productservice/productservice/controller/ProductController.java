package com.cancodelah.productservice.productservice.controller;


import com.cancodelah.productservice.productservice.entity.Products;
import com.cancodelah.productservice.productservice.service.ProductService;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Table(name="products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping("/")
    public Products saveCard(@RequestBody Products products){
        return productService.saveCard(products);
    }

    @GetMapping("/{id}")
    public Products findCardById(@PathVariable("id") Long cardId){
        return productService.findCardById(cardId);

    }
}


