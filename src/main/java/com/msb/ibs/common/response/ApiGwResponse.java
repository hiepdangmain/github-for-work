package com.msb.ibs.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiGwResponse<T> implements Serializable {
    String timestamp;
    String status;
    String error;
    String message;
    String path;
    boolean success;
    List<Error> errors;
    private T data;
    private int httpStatus;

}
