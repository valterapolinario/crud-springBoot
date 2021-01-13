package com.valterApolinario.apiRest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.valterApolinario.apiRest.dto.ProductDto;
import com.valterApolinario.apiRest.model.Product;
import com.valterApolinario.apiRest.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/product")
public class ProductController {

	private final ProductService service;

	@GetMapping
	public ResponseEntity<List<ProductDto>> findAllProducts() {
		return ResponseEntity.ok().body(service.findAll());

	}

	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody final Product objectProduct) {
		return ResponseEntity.ok(service.saveProduct(objectProduct));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> findOneProduct(@PathVariable("id") final Long id) {
		return ResponseEntity.ok(service.findOneProduct(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") final Long id,
			@RequestBody final Product objectProduct) {

		return ResponseEntity.ok(service.updateProduct(id, objectProduct));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable final Long id) {
		service.deleteProduct(id);

		return ResponseEntity.noContent().build();

	}

}
