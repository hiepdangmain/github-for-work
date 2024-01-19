/**
 * TODO
 *
 * @author binhnt26
 * @date 17/10/2021
 *
 */
package com.msb.ibs.common.base;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.kafka.common.serialization.Deserializer;

/**
 * CustomDeserializer
 *
 * @author binhnt26
 * @date 17/10/2021
 *
 */
public class CustomDeserializer<T extends Serializable> implements Deserializer<T> {

	public static final String VALUE_CLASS_NAME_CONFIG = "value.class.name";

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@SuppressWarnings("unchecked")
	@Override
	public T deserialize(String topic, byte[] objectData) {
		return (objectData == null) ? null : (T) SerializationUtils.deserialize(objectData);
	}

	@Override
	public void close() {
	}

}
