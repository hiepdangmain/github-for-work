package com.msb.ibs.common.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JsonResponseBase<T> implements Serializable {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
	private LocalDateTime timestamp;
	private String code;
	private String message;
	private String debugMessage;
	private T data;

	public JsonResponseBase<T> success(T data) {
		this.timestamp = LocalDateTime.now();
		this.code = "200";
		this.message = "Success";
		this.data = data;
		return this;
	}

	public JsonResponseBase<T> error(String code, String message) {
		this.code = code;
		this.message = message;
		this.timestamp = LocalDateTime.now();
		return this;
	}

	public JsonResponseBase<T> error(String code, String message, String debugMessage) {
		this.code = code;
		this.message = message;
		this.debugMessage = debugMessage;
		this.timestamp = LocalDateTime.now();
		return this;
	}

	public JsonResponseBase<T> error(T data, String code, String message) {
		this.data = data;
		this.code = code;
		this.message = message;
		this.timestamp = LocalDateTime.now();
		return this;
	}

	public JsonResponseBase<T> error(T data, String code, String message, String debugMessage) {
		this.data = data;
		this.code = code;
		this.message = message;
		this.debugMessage = debugMessage;
		this.timestamp = LocalDateTime.now();
		return this;
	}

	public JsonResponseBase() {
		this.timestamp = LocalDateTime.now();
	}

	public JsonResponseBase(T data) {
		this.timestamp = LocalDateTime.now();
		this.data = data;
	}

	public JsonResponseBase(String message) {
		this.timestamp = LocalDateTime.now();
		this.message = message;
	}

	public JsonResponseBase(T data, String message) {
		this.timestamp = LocalDateTime.now();
		this.data = data;
		this.message = message;
	}

	public JsonResponseBase(T data, String message, String code) {
		this.timestamp = LocalDateTime.now();
		this.data = data;
		this.message = message;
		this.code = code;
	}
}
