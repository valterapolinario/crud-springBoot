package com.valterApolinario.apiRest.util;

import lombok.Getter;

@Getter
public enum ErrorMessagesEnum {

	PRODUCT_NOT_FOUND("Produto não encontrado.");
	
	private final String message;
	
	private ErrorMessagesEnum(final String message) {
		this.message = message;
	}
}
