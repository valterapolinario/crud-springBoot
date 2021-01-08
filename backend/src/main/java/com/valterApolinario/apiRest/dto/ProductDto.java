package com.valterApolinario.apiRest.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class ProductDto {

	private Long id;
	private String name;
	private Double price;
	private String Description;
	private LocalDate creationDate;
	private LocalDate lastUpdateDate;
}
