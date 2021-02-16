package com.valterApolinario.apiRest.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

	private Long id;
	@NotBlank
	@NotNull
	private String name;
	@NotNull
	private Double price;
	@NotBlank
	@NotNull
	private String Description;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "UTF-8")
	private LocalDateTime creationDate;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "UTF-8")
	private LocalDateTime lastUpdateDate;
}
