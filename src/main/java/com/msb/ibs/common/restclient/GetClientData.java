package com.msb.ibs.common.restclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.msb.ibs.common.exception.LogicException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;


@Data
@AllArgsConstructor
@Builder
public class GetClientData<Response> {
    private String url;
    private TypeReference<Response> typeReference;
    private Map<String, Object> parameters;
    private Map<String, Object> routeParameters;
    private Map<String, String> headers;
    private Integer timeout;

    public Response send() throws LogicException {
        return RestClient.makeGetCall(this);
    }
}
