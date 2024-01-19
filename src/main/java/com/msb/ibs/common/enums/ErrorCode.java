package com.msb.ibs.common.enums;

import com.msb.ibs.common.base.BaseErrorCode;
import org.springframework.http.HttpStatus;

public enum ErrorCode implements BaseErrorCode {
	MS_RESPONSE_ERROR("999", "", HttpStatus.INTERNAL_SERVER_ERROR),
	MS_BAD_REQUEST("400", "Bad Request", HttpStatus.BAD_REQUEST),
	MS_ERROR("111", "", HttpStatus.BAD_REQUEST);

	ErrorCode(String code, String message, HttpStatus httpStatus) {
		this.code = code;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	private final String code;
	private final String message;
	private final HttpStatus httpStatus;

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public HttpStatus getHttpStatus() {
		return this.httpStatus;
	}
}
