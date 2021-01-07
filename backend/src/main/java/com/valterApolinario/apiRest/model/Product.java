package com.valterApolinario.apiRest.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double price;
	private String Description;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "UTF-8")
	@CreationTimestamp
	private LocalDate creationDate;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "UTF-8")
	@UpdateTimestamp
	private LocalDate lastUpdateDate;

}
