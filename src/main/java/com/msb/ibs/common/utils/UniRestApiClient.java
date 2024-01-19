package com.msb.ibs.common.utils;

import kong.unirest.*;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

public class UniRestApiClient<T> {

    public String post(T object, String url) {
        String response = Unirest.post(url.trim()).header("Content-Type", ContentType.APPLICATION_JSON.toString())
                .body(object).asString().getBody();
        return response;
    }

    public HttpResponse<String> put(String url, Map<String, String> headers, T object, Map<String, Object> parameters, Map<String, Object> routeParameters,
                      Integer connectTimeout, Integer socketTimeout)  {
        if (!CollectionUtils.isEmpty(headers)) {
            if (!headers.containsKey("Content-Type"))
                headers.put("Content-Type", ContentType.APPLICATION_JSON.toString());
        } else {
            headers = new HashMap<>();
            headers.put("Content-Type", ContentType.APPLICATION_JSON.toString());
        }
        HttpRequestWithBody request = Unirest.put(url.trim()).headers(headers);
        if (!CollectionUtils.isEmpty(parameters))
            request.queryString(parameters);
        if (!CollectionUtils.isEmpty(routeParameters))
            request.routeParam(routeParameters);
        if (socketTimeout != null)
            request.socketTimeout(socketTimeout);
        if (connectTimeout != null)
            request.connectTimeout(connectTimeout);

        HttpResponse<String> response;
        if (object != null) {
            response = request.body(object).asString();
        } else {
            response = request.asString();
        }
        return response;
    }

    public HttpResponse<String> get(String url, Map<String, String> headers, Map<String, Object> parameters, Map<String, Object> routeParameters,
                      Integer connectTimeout, Integer socketTimeout)  {
        if (!CollectionUtils.isEmpty(headers)) {
            if (!headers.containsKey("Content-Type"))
                headers.put("Content-Type", ContentType.APPLICATION_JSON.toString());
        } else {
            headers = new HashMap<>();
            headers.put("Content-Type", ContentType.APPLICATION_JSON.toString());
        }
        GetRequest request = Unirest.get(url.trim()).headers(headers);
        if (!CollectionUtils.isEmpty(parameters))
            request.queryString(parameters);
        if (!CollectionUtils.isEmpty(routeParameters))
            request.routeParam(routeParameters);
        if (socketTimeout != null)
            request.socketTimeout(socketTimeout);
        if (connectTimeout != null)
            request.connectTimeout(connectTimeout);

        return request.asString();
    }

    public HttpResponse<String> post(String url, Map<String, String> headers, T object, Map<String, Object> parameters, Map<String, Object> routeParameters,
                       Integer connectTimeout, Integer socketTimeout)  {
        if (!CollectionUtils.isEmpty(headers)) {
            if (!headers.containsKey("Content-Type"))
                headers.put("Content-Type", ContentType.APPLICATION_JSON.toString());
        } else {
            headers = new HashMap<>();
            headers.put("Content-Type", ContentType.APPLICATION_JSON.toString());
        }
        HttpRequestWithBody request = Unirest.post(url.trim()).headers(headers);
        if (!CollectionUtils.isEmpty(parameters))
            request.queryString(parameters);
        if (!CollectionUtils.isEmpty(routeParameters))
            request.routeParam(routeParameters);
        if (socketTimeout != null)
            request.socketTimeout(socketTimeout);
        if (connectTimeout != null)
            request.connectTimeout(connectTimeout);

        HttpResponse<String> response;
        if (object != null) {
            response = request.body(object).asString();
        } else {
            response = request.asString();
        }
        return response;
    }

    public HttpResponse<String> postForm(String url, Map<String, String> headers, Map<String, Object> parameters, Map<String, Object> routeParameters,
                       Integer connectTimeout, Integer socketTimeout) throws Exception {
        if (!CollectionUtils.isEmpty(headers)) {
            if (!headers.containsKey("Content-Type"))
                headers.put("Content-Type", ContentType.APPLICATION_FORM_URLENCODED.toString());
        } else {
            headers = new HashMap<>();
            headers.put("Content-Type", ContentType.APPLICATION_FORM_URLENCODED.toString());
        }
        MultipartBody request = Unirest.post(url.trim()).headers(headers).fields(parameters);
        if (!CollectionUtils.isEmpty(routeParameters))
            request.routeParam(routeParameters);
        if (socketTimeout != null)
            request.socketTimeout(socketTimeout);
        if (connectTimeout != null)
            request.connectTimeout(connectTimeout);

        return request.asString();
    }

    public HttpResponse<String> delete(String url, Map<String, String> headers, T object, Map<String, Object> parameters, Map<String, Object> routeParameters,
                                    Integer connectTimeout, Integer socketTimeout) throws Exception {
        if (!CollectionUtils.isEmpty(headers)) {
            if (!headers.containsKey("Content-Type"))
                headers.put("Content-Type", ContentType.APPLICATION_JSON.toString());
        } else {
            headers = new HashMap<>();
            headers.put("Content-Type", ContentType.APPLICATION_JSON.toString());
        }
        HttpRequestWithBody request = Unirest.delete(url.trim()).headers(headers);
        if (!CollectionUtils.isEmpty(parameters))
            request.queryString(parameters);
        if (!CollectionUtils.isEmpty(routeParameters))
            request.routeParam(routeParameters);
        if (socketTimeout != null)
            request.socketTimeout(socketTimeout);
        if (connectTimeout != null)
            request.connectTimeout(connectTimeout);

        HttpResponse<String> response;
        if (object != null) {
            response = request.body(object).asString();
        } else {
            response = request.asString();
        }
        return response;
    }

}
