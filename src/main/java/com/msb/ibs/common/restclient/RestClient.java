package com.msb.ibs.common.restclient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.msb.ibs.common.constant.AppConstants;
import com.msb.ibs.common.enums.ErrorCode;
import com.msb.ibs.common.exception.LogicException;
import com.msb.ibs.common.utils.CommonStringUtils;
import com.msb.ibs.common.utils.JsonUtil;
import com.msb.ibs.common.utils.UniRestApiClient;
import kong.unirest.HttpResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpMethod;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.Objects;

public final class RestClient {
    private static final Log LOGGER = LogFactory.getLog(RestClient.class);
    private static final Integer DEFAULT_TIME_OUT = 60000;
    private static final Gson gson = new Gson();

    public static <Response> Response makePostCall(PostClientData<Response> data) throws LogicException {
        return makePostOrPutCall(HttpMethod.POST, data.getUrl(), data.getBody(), data.getParameters(), data.getRouteParameters(), data.getHeaders(), data.getTypeReference(), data.getTimeout());
    }

    public static <Response> Response makePutCall(PostClientData<Response> data) throws LogicException {
        return makePostOrPutCall(HttpMethod.PUT, data.getUrl(), data.getBody(), data.getParameters(), data.getRouteParameters(), data.getHeaders(), data.getTypeReference(), data.getTimeout());
    }

    public static <Response> Response makeGetCall(GetClientData<Response> data) throws LogicException {
        return makeGetCall(data.getUrl(), data.getParameters(), data.getRouteParameters(), data.getHeaders(), data.getTypeReference(), data.getTimeout());
    }

    public static <Request, Response> Response makePostCall(String url, Request body, Map<String, String> headers, TypeReference<Response> tTypeReference) throws LogicException {
        return makePostOrPutCall(HttpMethod.POST, url, body, null, null, headers, tTypeReference, null);
    }

    public static <Request, Response> Response makePostCall(String url, Request body, Map<String, String> headers, TypeReference<Response> tTypeReference, Integer timeout) throws LogicException {
        return makePostOrPutCall(HttpMethod.POST, url, body, null, null, headers, tTypeReference, timeout);
    }

    public static <Request, Response> Response makePostCall(String url, Request body, Map<String, Object> parameters, Map<String, Object> routeParameters, Map<String, String> headers, TypeReference<Response> tTypeReference, Integer timeout) throws LogicException {
        return makePostOrPutCall(HttpMethod.POST, url, body, parameters, routeParameters, headers, tTypeReference, timeout);
    }

    public static <Request, Response> Response makePutCall(String url, Request body, Map<String, String> headers, TypeReference<Response> tTypeReference) throws LogicException {
        return makePostOrPutCall(HttpMethod.PUT, url, body, null, null, headers, tTypeReference, null);
    }

    public static <Request, Response> Response makePutCall(String url, Request body, Map<String, String> headers, TypeReference<Response> tTypeReference, Integer timeout) throws LogicException {
        return makePostOrPutCall(HttpMethod.PUT, url, body, null, null, headers, tTypeReference, timeout);
    }

    public static <Request, Response> Response makePutCall(String url, Request body, Map<String, Object> parameters, Map<String, Object> routeParameters, Map<String, String> headers, TypeReference<Response> tTypeReference, Integer timeout) throws LogicException {
        return makePostOrPutCall(HttpMethod.PUT, url, body, parameters, routeParameters, headers, tTypeReference, timeout);
    }

    public static <Response> Response makeGetCall(String url, Map<String, Object> parameters, Map<String, String> headers, TypeReference<Response> tTypeReference, Integer timeout) throws LogicException {
        return makeGetCall(url, parameters, null, headers, tTypeReference, timeout);
    }

    public static <Response> Response makeGetCall(String url, Map<String, String> headers, TypeReference<Response> tTypeReference) throws LogicException {
        return makeGetCall(url, null, null, headers, tTypeReference, null);
    }

    public static <Response> Response makeGetCall(String url, Map<String, String> headers, TypeReference<Response> tTypeReference, Integer timeout) throws LogicException {
        return makeGetCall(url, null, null, headers, tTypeReference, timeout);
    }

    public static <Response> Response makeGetCall(String url, Map<String, String> headers, TypeReference<Response> tTypeReference, Integer timeout, Map<String, Object> routeParameters) throws LogicException {
        return makeGetCall(url, null, routeParameters, headers, tTypeReference, timeout);
    }

    public static <Request, Response> Response makePostFormCall(String url, Map<String, String> headers, Map<String, Object> parameters, TypeReference<Response> tTypeReference, Integer timeout) throws LogicException {
        return makePostFormCall(url, parameters, null, headers, tTypeReference, timeout);
    }

    public static <Response> Response makeGetCall(String url, Map<String, Object> parameters, Map<String, Object> routeParameters, Map<String, String> headers, TypeReference<Response> tTypeReference, Integer timeout) throws LogicException {
        LOGGER.info("****** MakeGetCall Api: Url=" + url);
        printParameters(parameters, routeParameters);
        long startTime = System.currentTimeMillis();
        try {
            UniRestApiClient<String> client = new UniRestApiClient<>();
            HttpResponse<String> response = client.get(url, headers, parameters, routeParameters, setTimeout(timeout), setTimeout(timeout));
            LOGGER.info("****** Total Time ****** = " + (System.currentTimeMillis() - startTime) + " ms");
            if (response != null) {
                printLogResponse(response);
                return buildResponse(response, tTypeReference);
            }
        } catch (Exception e) {
            String message = ExceptionUtils.getMessage(e.getCause());
            LOGGER.info("Response Error" + message);
            LOGGER.info("****** Total Time ****** = " + (System.currentTimeMillis() - startTime) + " ms");
            throw new LogicException(message, ErrorCode.MS_RESPONSE_ERROR);
        }
        return null;
    }

    public static <Response> Response makePostFormCall(String url, Map<String, Object> parameters, Map<String, Object> routeParameters, Map<String, String> headers, TypeReference<Response> tTypeReference, Integer timeout) throws LogicException {
        LOGGER.info("****** MakePostFormCall Api: Url=" + url);
        printParameters(parameters, routeParameters);
        long startTime = System.currentTimeMillis();
        try {
            UniRestApiClient<String> client = new UniRestApiClient<>();
            HttpResponse<String> response = client.postForm(url, headers, parameters, routeParameters, setTimeout(timeout), setTimeout(timeout));
            LOGGER.info("****** Total Time ****** = " + (System.currentTimeMillis() - startTime) + " ms");
            if (response != null) {
                printLogResponse(response);
                return buildResponse(response, tTypeReference);
            }
        } catch (Exception e) {
            String message = ExceptionUtils.getMessage(e.getCause());
            LOGGER.info("Response Error" + message);
            LOGGER.info("****** Total Time ****** = " + (System.currentTimeMillis() - startTime) + " ms");
            throw new LogicException(message, ErrorCode.MS_RESPONSE_ERROR);
        }
        return null;
    }

    private static <Request, Response> Response makePostOrPutCall(HttpMethod httpMethod, String url, Request body, Map<String, Object> parameters, Map<String, Object> routeParameters, Map<String, String> headers, TypeReference<Response> tTypeReference, Integer timeout) throws LogicException {
        LOGGER.info("****** MakePostOrPutCall Api: Url=" + url);
        LOGGER.info("****** HttpMethod ******: " + httpMethod);
        LOGGER.info("****** Request Body ****** : " + gson.toJson(body));
        printParameters(parameters, routeParameters);
        long startTime = System.currentTimeMillis();
        try {
            UniRestApiClient<Request> client = new UniRestApiClient<>();
            HttpResponse<String> response;
            if (HttpMethod.POST.equals(httpMethod)) {
                response = client.post(url, headers, body, parameters, routeParameters, setTimeout(timeout), setTimeout(timeout));
            } else {
                response = client.put(url, headers, body, parameters, routeParameters, setTimeout(timeout), setTimeout(timeout));
            }
            LOGGER.info("****** Total Time ****** = " + (System.currentTimeMillis() - startTime) + " ms");
            if (response != null) {
                printLogResponse(response);
                return buildResponse(response, tTypeReference);
            }
        } catch (Exception e) {
            String message = ExceptionUtils.getMessage(e.getCause());
            LOGGER.info("Response Error" + message);
            LOGGER.info("****** Total Time ****** = " + (System.currentTimeMillis() - startTime) + " ms");
            throw new LogicException(message, ErrorCode.MS_RESPONSE_ERROR);
        }
        return null;
    }

    private static void printParameters(Map<String, Object> parameters, Map<String, Object> routeParameters) {
        if (!CollectionUtils.isEmpty(parameters)) {
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                LOGGER.info("Param: " + entry.getKey() + "=" + (!Objects.isNull(entry.getValue()) ? entry.getValue().toString() : ""));
            }
        }
        if (!CollectionUtils.isEmpty(routeParameters)) {
            for (Map.Entry<String, Object> entry : routeParameters.entrySet()) {
                LOGGER.info("Route param: " + entry.getKey() + "=" + (!Objects.isNull(entry.getValue()) ? entry.getValue().toString() : ""));
            }
        }
    }

    private static Integer setTimeout(Integer timeout) {
        return timeout == null ? DEFAULT_TIME_OUT : timeout;
    }

    private static <Response> Response buildResponse(HttpResponse<String> response, TypeReference<Response> tTypeReference) {
        String data = response.getBody();
        if (!CommonStringUtils.isNullOrEmpty(data)) {
            try {
                JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
                jsonObject.addProperty("httpStatus", response.getStatus());
                jsonObject.addProperty("requestId", getRequestId(response));
                return JsonUtil.toObject(jsonObject.toString(), tTypeReference);
            } catch (Exception e) {
                JsonArray jsonArray = gson.fromJson(data, JsonArray.class);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("httpStatus", response.getStatus());
                jsonObject.addProperty("requestId", getRequestId(response));
                jsonObject.add("data", jsonArray);
                return JsonUtil.toObject(jsonObject.toString(), tTypeReference);
            }
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("httpStatus", response.getStatus());
        return JsonUtil.toObject(jsonObject.toString(), tTypeReference);
    }

    private static void printLogResponse(HttpResponse<String> response) {
        LOGGER.info("****** HttpStatus ******: " + response.getStatus());
        LOGGER.info("****** Response ******:" + response.getBody());
        LOGGER.info("****** End Executed ******");
    }

    private static String getRequestId(HttpResponse<String> response) {
        try {
            if (response != null && !CollectionUtils.isEmpty(response.getHeaders().get(AppConstants.Header.Request_Id))) {
                return response.getHeaders().get(AppConstants.Header.Request_Id).get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
