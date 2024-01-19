package com.msb.ibs.common.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kong.unirest.HttpResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.CollectionUtils;

import java.util.Map;

public class RestApiSendMessage<T> {

    private static final Log LOGGER = LogFactory.getLog(RestApiSendMessage.class);

    protected T obj;
    protected String request;
    protected String response;
    protected Integer httpStatus;
    protected String url;
    protected Integer connectTimeout = 60000;
    protected Integer socketTimeout = 30000;
    protected Map<String, Object> parameters = null;
    protected Map<String, Object> routeParameters = null;
    protected Map<String, String> headers = null;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private UniRestApiClient<T> client = new UniRestApiClient<>();

    public RestApiSendMessage(String url, Map<String, String> headers) {
        this.url = url;
        this.headers = headers;
    }

    public RestApiSendMessage(String url, T bodyObject, Map<String, String> headers) {
        this.obj = bodyObject;
        this.url = url;
        this.headers = headers;
    }

    public RestApiSendMessage(String url, T bodyObject, Map<String, String> headers, Map<String, Object> parameters) {
        this.obj = bodyObject;
        this.url = url;
        this.headers = headers;
        this.parameters = parameters;
    }

    public RestApiSendMessage(String url, Map<String, String> headers, Map<String, Object> routeParameters) {
        this.url = url;
        this.headers = headers;
        this.routeParameters = routeParameters;
    }

    public RestApiSendMessage(String url, Map<String, String> headers, Map<String, Object> parameters, Map<String, Object> routeParameters) {
        this.url = url;
        this.headers = headers;
        this.parameters = parameters;
        this.routeParameters = routeParameters;
    }

    public RestApiSendMessage(String url, T bodyObject, Map<String, String> headers, Map<String, Object> parameters,
                              Integer connectTimeout, Integer socketTimeout) {
        this.obj = bodyObject;
        this.url = url;
        this.headers = headers;
        this.parameters = parameters;
        this.connectTimeout = connectTimeout;
        this.socketTimeout = socketTimeout;
    }

    public <Response> Response get(TypeReference<Response> tTypeReference) throws Exception {
        LOGGER.info("****** Call Api: Url="+ url);
        if (!CollectionUtils.isEmpty(parameters)) {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                LOGGER.info("Param: " + entry.getKey() + "=" + entry.getValue().toString());
            }
        }
        if (!CollectionUtils.isEmpty(routeParameters)) {
            for (Map.Entry<String, Object> entry : routeParameters.entrySet()) {
                LOGGER.info("Route param: " + entry.getKey() + "=" + entry.getValue().toString());
            }
        }

        long startTime = System.currentTimeMillis();
        try {
            response = client.get(url, headers, parameters, routeParameters, connectTimeout, socketTimeout).getBody();
            LOGGER.info("Time = " + (System.currentTimeMillis() - startTime) + " ms");
            LOGGER.info("****** Response: \n" + convertJson(response));
        } catch (Exception ex) {
            LOGGER.info("****** Response error: \n" + ex.getMessage());
        }
        if (response == null || response.length() == 0) {
            throw new Exception("No response...");
        }
        return JsonUtil.toObject(response, tTypeReference);
    }

    public <Response> Response post(TypeReference<Response> tTypeReference) throws Exception {
        LOGGER.info("****** Call Api: Url="+ url);
        LOGGER.info("Request Body: " + gson.toJson(obj));
        if (!CollectionUtils.isEmpty(parameters)) {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                LOGGER.info("Param: " + entry.getKey() + "=" + entry.getValue().toString());
            }
        }
        if (!CollectionUtils.isEmpty(routeParameters)) {
            for (Map.Entry<String, Object> entry : routeParameters.entrySet()) {
                LOGGER.info("Route param: " + entry.getKey() + "=" + entry.getValue().toString());
            }
        }
        long startTime = System.currentTimeMillis();
        try {
            response = client.post(url, headers, obj, parameters, routeParameters, connectTimeout, socketTimeout).getBody();
            LOGGER.info("Time = " + (System.currentTimeMillis() - startTime) + " ms");
            LOGGER.info("Response: \n" + convertJson(response));
        } catch (Exception ex) {
            LOGGER.info("Response error: \n" + ex.getMessage());
        }
        if (response == null || response.length() == 0) {
            throw new Exception("No response...");
        }
        return JsonUtil.toObject(response, tTypeReference);
    }

    public <Response> Response put(TypeReference<Response> tTypeReference) throws Exception {
        LOGGER.info("****** Call Api: Url="+ url);
        LOGGER.info("Request Body: " + gson.toJson(obj));
        if (!CollectionUtils.isEmpty(parameters)) {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                LOGGER.info("Param: " + entry.getKey() + "=" + entry.getValue().toString());
            }
        }
        if (!CollectionUtils.isEmpty(routeParameters)) {
            for (Map.Entry<String, Object> entry : routeParameters.entrySet()) {
                LOGGER.info("Route param: " + entry.getKey() + "=" + entry.getValue().toString());
            }
        }

        long startTime = System.currentTimeMillis();
        try {
            response = client.put(url, headers, obj, parameters, routeParameters, connectTimeout, socketTimeout).getBody();
            LOGGER.info("Time = " + (System.currentTimeMillis() - startTime) + " ms");
            LOGGER.info("Response: \n" + convertJson(response));
        } catch (Exception ex) {
            LOGGER.info("Response error: \n" + ex.getMessage());
        }
        if (response == null || response.length() == 0) {
            throw new Exception("No response...");
        }
        return JsonUtil.toObject(response, tTypeReference);
    }

    public <Response> Response postForm(TypeReference<Response> tTypeReference) throws Exception {
        LOGGER.info("****** Call Api: Url="+ url);
        if (!CollectionUtils.isEmpty(parameters)) {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                LOGGER.info("Field: " + entry.getKey() + "=" + entry.getValue().toString());
            }
        }
        if (!CollectionUtils.isEmpty(routeParameters)) {
            for (Map.Entry<String, Object> entry : routeParameters.entrySet()) {
                LOGGER.info("Route param: " + entry.getKey() + "=" + entry.getValue().toString());
            }
        }
        long startTime = System.currentTimeMillis();
        try {
            response = client.postForm(url, headers, parameters, routeParameters, connectTimeout, socketTimeout).getBody();
            LOGGER.info("Time = " + (System.currentTimeMillis() - startTime) + " ms");
            LOGGER.info("Response: \n" + convertJson(response));
        } catch (Exception ex) {
            LOGGER.info("Response error: \n" + ex.getMessage());
        }
        if (response == null || response.length() == 0) {
            throw new Exception("No response...");
        }
        return JsonUtil.toObject(response, tTypeReference);
    }

    public HttpResponse<String> get() throws Exception {
        LOGGER.info("****** Call Api: Url="+ url);
        if (!CollectionUtils.isEmpty(parameters)) {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                LOGGER.info("Param: " + entry.getKey() + "=" + entry.getValue().toString());
            }
        }
        if (!CollectionUtils.isEmpty(routeParameters)) {
            for (Map.Entry<String, Object> entry : routeParameters.entrySet()) {
                LOGGER.info("Route param: " + entry.getKey() + "=" + entry.getValue().toString());
            }
        }

        long startTime = System.currentTimeMillis();
        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = client.get(url, headers, parameters, routeParameters, connectTimeout, socketTimeout);
            LOGGER.info("Time = " + (System.currentTimeMillis() - startTime) + " ms");
            LOGGER.info("Response Body: \n" + convertJson(httpResponse.getBody()));
            LOGGER.info("HttpStatus: " + httpResponse.getStatus());
        } catch (Exception ex) {
            LOGGER.info("****** Response error: \n" + ex.getMessage());
        }
        if (httpResponse == null) {
            throw new Exception("No response...");
        }
        return httpResponse;
    }

    public HttpResponse<String> post() throws Exception {
        LOGGER.info("****** Call Api: Url="+ url);
        LOGGER.info("Request Body: " + gson.toJson(obj));
        if (!CollectionUtils.isEmpty(parameters)) {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                LOGGER.info("Param: " + entry.getKey() + "=" + entry.getValue().toString());
            }
        }
        if (!CollectionUtils.isEmpty(routeParameters)) {
            for (Map.Entry<String, Object> entry : routeParameters.entrySet()) {
                LOGGER.info("Route param: " + entry.getKey() + "=" + entry.getValue().toString());
            }
        }
        long startTime = System.currentTimeMillis();
        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = client.post(url, headers, obj, parameters, routeParameters, connectTimeout, socketTimeout);
            LOGGER.info("Time = " + (System.currentTimeMillis() - startTime) + " ms");
            LOGGER.info("Response Body: \n" + convertJson(httpResponse.getBody()));
            LOGGER.info("HttpStatus: " + httpResponse.getStatus());
        } catch (Exception ex) {
            LOGGER.info("Response error: \n" + ex.getMessage());
        }
        if (httpResponse == null) {
            throw new Exception("No response...");
        }
        return httpResponse;
    }

    public HttpResponse<String> put() throws Exception {
        LOGGER.info("****** Call Api: Url="+ url);
        LOGGER.info("Request Body: " + gson.toJson(obj));
        if (!CollectionUtils.isEmpty(parameters)) {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                LOGGER.info("Param: " + entry.getKey() + "=" + entry.getValue().toString());
            }
        }
        if (!CollectionUtils.isEmpty(routeParameters)) {
            for (Map.Entry<String, Object> entry : routeParameters.entrySet()) {
                LOGGER.info("Route param: " + entry.getKey() + "=" + entry.getValue().toString());
            }
        }

        long startTime = System.currentTimeMillis();
        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = client.put(url, headers, obj, parameters, routeParameters, connectTimeout, socketTimeout);
            LOGGER.info("Time = " + (System.currentTimeMillis() - startTime) + " ms");
            LOGGER.info("Response Body: \n" + convertJson(httpResponse.getBody()));
            LOGGER.info("HttpStatus: " + httpResponse.getStatus());
        } catch (Exception ex) {
            LOGGER.info("Response error: \n" + ex.getMessage());
        }
        if (httpResponse == null) {
            throw new Exception("No response...");
        }
        return httpResponse;
    }

    public HttpResponse<String> delete() throws Exception {
        LOGGER.info("****** Call Api: Url="+ url);
        LOGGER.info("Request Body: " + gson.toJson(obj));
        if (!CollectionUtils.isEmpty(parameters)) {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                LOGGER.info("Param: " + entry.getKey() + "=" + entry.getValue().toString());
            }
        }
        if (!CollectionUtils.isEmpty(routeParameters)) {
            for (Map.Entry<String, Object> entry : routeParameters.entrySet()) {
                LOGGER.info("Route param: " + entry.getKey() + "=" + entry.getValue().toString());
            }
        }

        long startTime = System.currentTimeMillis();
        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = client.delete(url, headers, obj, parameters, routeParameters, connectTimeout, socketTimeout);
            LOGGER.info("Time = " + (System.currentTimeMillis() - startTime) + " ms");
            LOGGER.info("Response Body: \n" + convertJson(httpResponse.getBody()));
            LOGGER.info("HttpStatus: " + httpResponse.getStatus());
        } catch (Exception ex) {
            LOGGER.info("Response error: \n" + ex.getMessage());
        }
        if (httpResponse == null) {
            throw new Exception("No response...");
        }
        return httpResponse;
    }

    public String convertJson(String jsonString) {
        try {
            if (StringUtil.isNotEmpty(jsonString)) {
                return gson.toJson(gson.fromJson(jsonString, Object.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
