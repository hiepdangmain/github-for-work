package com.msb.ibs.common.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponseData<T> extends JsonResponseBase<T> {
    private int httpStatus;
    private String requestId;
}
