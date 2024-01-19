package com.msb.ibs.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

public class CommonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    public static <T> T stringToBean(String value, Class<T> aClass) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        try {
            return String.class.equals(aClass) ? (T) value :mapper.readValue(value, aClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String beanToString(Object object) {
        if (object == null) {
            return "";
        }
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Can't build json from object";
        }
    }

    public static <T> T stringToBean(String value, TypeReference<T> tTypeReference) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        try {
            return String.class.equals(tTypeReference.getType()) ? (T) value : mapper.readValue(value, tTypeReference);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String buildKeyRedis(String prefix, Object... keys) {
        StringBuilder str = new StringBuilder(prefix);
        for (Object key : keys) {
            if (ObjectUtils.isNotEmpty(key)) {
                str.append("_").append(key);
            }
        }
        return str.toString();
    }
}
