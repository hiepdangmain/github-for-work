package com.msb.ibs.common.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
public class JsonUtil {
	private static final ObjectMapper mapper = new ObjectMapper();
	static {
		// mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}

	public static String toString(Object object) {
		if(object==null) {
			return "";
		}
		try {
			mapper.registerModule(new JavaTimeModule());
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static <T> T toObject(String stringObject, Class<T> clazz) {
		try {
			return mapper.readValue(stringObject, clazz);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public static <T> T toObject(String stringObject, TypeReference<T> type) {
		try {
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			mapper.registerModule(new JavaTimeModule());
			return String.class.equals(type.getType()) ? (T) stringObject : mapper.readValue(stringObject, type);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static JsonNode toJsonObject(String input) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode actualObj = null;
		try {
			actualObj = mapper.readTree(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return actualObj;
	}
}
