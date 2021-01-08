package com.valterApolinario.apiRest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.valterApolinario.apiRest.dao.ProductDao;
import com.valterApolinario.apiRest.model.Product;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductDao dao;

	public List<Product> findAll() {
		return dao.findAll();
	}
}
