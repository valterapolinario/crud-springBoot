package com.valterApolinario.apiRest.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

import com.valterApolinario.apiRest.dto.ProductDto;
import com.valterApolinario.apiRest.service.ProductService;

@Data
@RestController
@RequestMapping(value = "/product")
public class ProductController {


	private final ProductService service;

	@GetMapping
	public ResponseEntity<Page<ProductDto>> getProducts(
			@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable page,
			@RequestParam(value = "id", required = false) final Long id) {

		return ResponseEntity.ok().body(service.findProduct(page, id));
	}

	@PostMapping
	public ResponseEntity<ProductDto> saveNewProduct(@RequestBody final ProductDto objectProductDto) {
		return ResponseEntity.ok(service.saveProduct(objectProductDto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") final Long id,
			@RequestBody final ProductDto objectProductDto) {

		return ResponseEntity.ok(service.updateProduct(id, objectProductDto));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable final Long id) {
		service.deleteProduct(id);

		return ResponseEntity.noContent().build();

	}

}
