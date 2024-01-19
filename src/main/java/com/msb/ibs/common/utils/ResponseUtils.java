package com.msb.ibs.common.utils;

import com.msb.ibs.common.constant.AppConstants;
import com.msb.ibs.common.response.ApiResponseData;
import com.msb.ibs.common.response.JsonResponseBase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtils {
    public static ResponseEntity<JsonResponseBase<Object>> success(Object data) {
        return ResponseEntity.ok().body(new JsonResponseBase<>().success(data));
    }

    public static ResponseEntity<Object> error(String errorCode, String message, HttpStatus status) {
        return new ResponseEntity<>(new JsonResponseBase<>().error(errorCode, message), status);
    }

    public static ResponseEntity<Object> error(String errorCode, String message, String debugMessage, HttpStatus status) {
        return new ResponseEntity<>(new JsonResponseBase<>().error(errorCode, message, debugMessage), status);
    }

    public static ResponseEntity<Object> error(Object data, String errorCode, String message, HttpStatus status) {
        return new ResponseEntity<>(new JsonResponseBase<>().error(data, errorCode, message), status);
    }

    public static ResponseEntity<Object> error(Object data, String errorCode, String message, String debugMessage, HttpStatus status) {
        return new ResponseEntity<>(new JsonResponseBase<>().error(data, errorCode, message, debugMessage), status);
    }

    public static boolean isSuccess(ApiResponseData<?> responseData) {
        if (responseData != null && HttpStatus.OK.value() == responseData.getHttpStatus()) {
            return true;
        }
        return false;
    }

    public static boolean isCreated(ApiResponseData<?> responseData) {
        if (responseData != null && HttpStatus.CREATED.value() == responseData.getHttpStatus()) {
            return true;
        }
        return false;
    }
}
