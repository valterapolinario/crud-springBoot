package com.valterApolinario.apiRest.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.valterApolinario.apiRest.dao.ProductDao;
import com.valterApolinario.apiRest.dto.ProductDto;
import com.valterApolinario.apiRest.model.Product;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductDao dao;
	
	


	public Page<ProductDto> findAllProducts(final Pageable page) {
		return dao.findAll(page).map(this::parseModelToDto);
	}

	public Page<ProductDto> findOneProduct(final Pageable page , final Long id) {
		
		return dao.findById(page, id).map(this::parseModelToDto);
	}
	
	public Page<ProductDto>findProduct(Pageable page, Long id){
		return (id == null) ? findAllProducts(page) : findOneProduct(page, id);
	}

	public Product saveProduct(Product entity) {
		return dao.save(entity);
	}

	public Product updateProduct(final Long id, final Product entity) {
		entity.setId(id);
		return dao.save(entity);
	}

	public void deleteProduct(Long id) {
		dao.deleteById(id);

	}

	private Product parseDtoToModel(final ProductDto dto) {
		return Product.builder().id(dto.getId()).name(dto.getName()).price(dto.getPrice()).lastUpdateDate(null)
				.creationDate(null).build();

	}

	private ProductDto parseModelToDto(final Product product) {
		return ProductDto.builder().id(product.getId()).name(product.getName()).Description(product.getDescription())
				.creationDate(null).lastUpdateDate(null).build();
	}

	private List<Product> parseDtoListToModelList(final List<ProductDto> productsDto) {
		return productsDto.stream().map(product -> parseDtoToModel(product)).collect(Collectors.toList());
	}

	private List<ProductDto> parseModelListToDtoList(final List<Product> products) {
		return products.stream().map(product -> parseModelToDto(product)).collect(Collectors.toList());
	}
	
	private Boolean isExistsProduct(Long id) {
		return dao.existsById(id);
	}
}
