package com.valterApolinario.apiRest.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.valterApolinario.apiRest.dao.ProductDao;
import com.valterApolinario.apiRest.dto.ProductDto;
import com.valterApolinario.apiRest.exception.ObjectNotFoundException;
import com.valterApolinario.apiRest.mapper.ProductMapper;
import com.valterApolinario.apiRest.model.Product;
import com.valterApolinario.apiRest.util.ErrorMessagesEnum;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductDao dao;


	public Page<ProductDto> findAllProducts(final Pageable page) {
		return dao.findAll(page).map(this::parseModelToDto);
	}

	public Page<ProductDto> findOneProduct(final Pageable page, final Long id) {

		return dao.findById(page, id).map(this::parseModelToDto);
	}

	public Page<ProductDto> findProduct(Pageable page, Long id) {
		return (id == null) ? findAllProducts(page) : findOneProduct(page, id);
	}

	public ProductDto saveProduct(ProductDto dto) {
		return parseModelToDto(dao.save(parseDtoToModel(dto)));
	}

	public ProductDto updateProduct(final Long id, final ProductDto dto) {

		final Optional<Product> entity = dao.findById(id);
		dto.setId(id);
		dto.setCreationDate(entity.get().getCreationDate());
		;
		return parseModelToDto(dao.save(parseDtoToModel(dto)));
	}

	public void deleteProduct(Long id) {
		if (isExistsProduct(id)) {
			dao.deleteById(id);
		} else {
			throw new ObjectNotFoundException(ErrorMessagesEnum.PRODUCT_NOT_FOUND.getMessage());
		}

	}

	private Product parseDtoToModel(final ProductDto dto) {
		return Product.builder()
				.id(dto.getId())
				.name(dto.getName())
				.price(dto.getPrice())
				.Description(dto.getDescription())
				.creationDate(dto.getCreationDate())
				.build();

	}

	private ProductDto parseModelToDto(final Product product) {
		return ProductDto.builder()
				.id(product.getId())
				.name(product.getName())
				.Description(product.getDescription()) 
				.price(product.getPrice())
				.creationDate(product.getCreationDate())
				.lastUpdateDate(product.getLastUpdateDate())
				.build();
	}

	/*
	 * private List<Product> parseDtoListToModelList(final List<ProductDto>
	 * productsDto) { return productsDto.stream().map(product ->
	 * parseDtoToModel(product)).collect(Collectors.toList()); }
	 * 
	 * private List<ProductDto> parseModelListToDtoList(final List<Product>
	 * products) { return products.stream().map(product ->
	 * parseModelToDto(product)).collect(Collectors.toList()); }
	 */

	private Boolean isExistsProduct(Long id) {
		return dao.existsById(id);
	}
}
