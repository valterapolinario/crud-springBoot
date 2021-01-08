package com.valterApolinario.apiRest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valterApolinario.apiRest.model.Product;
import com.valterApolinario.apiRest.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/product")
public class ProductController {

	private final ProductService service;

	@GetMapping
	public ResponseEntity<List<Product>> findAllProducts() {
		return ResponseEntity.ok().body(service.findAll());

	}
}
