package com.valterApolinario.apiRest.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

	private Long id;
	private String name;
	private Double price;
	private String Description;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "UTF-8")
	private LocalDateTime creationDate;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "UTF-8")
	private LocalDateTime lastUpdateDate;
}
