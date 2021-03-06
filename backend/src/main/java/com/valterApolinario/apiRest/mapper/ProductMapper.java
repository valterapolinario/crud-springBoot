package com.valterApolinario.apiRest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.valterApolinario.apiRest.dto.ProductDto;
import com.valterApolinario.apiRest.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	Product productDtoToProduct(ProductDto productDto);

	ProductDto ProductToProductrDto(Product product);

	List<ProductDto> productsToProductsDto(List<Product> productList);

	List<Product> productsDtoToProduct(List<ProductDto> productDtoList);
}
