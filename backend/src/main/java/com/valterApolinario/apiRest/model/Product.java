package com.valterApolinario.apiRest.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double price;
	private String Description;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "UTF-8")
	@CreationTimestamp
	@Column
	private LocalDateTime creationDate;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "UTF-8")
	@UpdateTimestamp
	private LocalDateTime lastUpdateDate;

}
