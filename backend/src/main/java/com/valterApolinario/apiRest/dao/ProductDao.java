package com.valterApolinario.apiRest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.valterApolinario.apiRest.model.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

	Page<Product> findById(Pageable page, Long id);

}
