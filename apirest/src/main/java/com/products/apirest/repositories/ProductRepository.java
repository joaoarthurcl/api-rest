package com.products.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.apirest.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
