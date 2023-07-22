package com.cancodelah.productservice.productservice.repository;

import com.cancodelah.productservice.productservice.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    Products findByCardId(Long cardId);
}
