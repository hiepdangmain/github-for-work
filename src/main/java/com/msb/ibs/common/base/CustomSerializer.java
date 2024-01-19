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
import org.apache.kafka.common.serialization.Serializer;

/**
 * CustomSerializer
 *
 * @author binhnt26
 * @date 17/10/2021
 *
 */
public class CustomSerializer<T extends Serializable> implements Serializer<T> {

	public CustomSerializer() {
	}

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public byte[] serialize(String topic, T data) {
		return SerializationUtils.serialize(data);
	}

	@Override
	public void close() {
	}

}
