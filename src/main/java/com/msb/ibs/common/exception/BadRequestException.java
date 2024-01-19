package com.msb.ibs.common.exception;

import lombok.Data;

import java.util.Map;

@SuppressWarnings("serial")
@Data
public class BadRequestException extends RuntimeException {

	private String message;
	private String lang;
	private String code = "400";
	private Object data;
	private Object[] args;

	public BadRequestException() {
		super();
	}

	public BadRequestException(String message) {
		super();
		this.message = message;
	}

	public BadRequestException(String message, Object[] args) {
		super();
		this.message = message;
		this.args = args;
	}

	public BadRequestException(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}

	public BadRequestException(Object data, String message, String lang, String code) {
		super();
		this.data = data;
		this.message = message;
		this.lang = lang;
		this.code = code;
	}
}
