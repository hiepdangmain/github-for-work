package com.msb.ibs.common.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Clob;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;

/**
 * @author binhnt26
 *
 */
public class CommonTransformUtils {

	public static <T> T transformObject(Object item, Class<? extends T> input) {

		T result = null;
		try {
			result = input.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		if (result == null)
			return null;

		Field[] fields = null;

		Object[] o = null;

		fields = result.getClass().getDeclaredFields();

		o = (Object[]) item;

		int stt = 0;

		String fieldType = "";

		Object obj = null;

		for (Field field : fields) {
			if (stt >= o.length) {
				break;
			}

			field.setAccessible(true);

			if ("serialVersionUID".equals(field.getName())) {
				continue;
			}

			fieldType = field.getType().toString();

			try {

				obj = o[stt];

				if ("class java.lang.String".equals(fieldType)) {
					field.set(result, obj != null ? String.valueOf(obj) : "");
				} else if ("class java.lang.Long".equals(fieldType)) {
					field.set(result, obj != null ? Long.valueOf(obj.toString().trim()) : null);
				} else if ("class java.lang.Integer".equals(fieldType)) {
					field.set(result, obj != null ? Integer.valueOf(obj.toString().trim()) : null);
				} else if ("class java.math.BigInteger".equals(fieldType)) {
					field.set(result, obj != null ? (BigInteger) obj : null);
				} else if ("class java.math.BigDecimal".equals(fieldType)) {
					field.set(result, obj != null ? (BigDecimal) obj : null);
				} else if ("class java.util.Date".equals(fieldType)) {
					field.set(result, obj != null ? (Date) obj : null);
				} else if ("class java.lang.Float".equals(fieldType)) {
					field.set(result, obj != null ? (Float) obj : null);
				} else if ("interface java.sql.Clob".equals(fieldType)) {
					field.set(result, obj != null ? (Clob) obj : null);
				} else if ("class java.lang.Boolean".equals(fieldType)) {
					field.set(result, obj != null ? (Boolean) obj : null);
				} else if ("class java.util.UUID".equals(fieldType)) {
					field.set(result, obj != null ? UUID.fromString(obj.toString()) : null);
				} else if ("class java.lang.Double".equals(fieldType)) {
					field.set(result, obj != null ? (Double) obj : null);
				} else if ("class java.sql.Timestamp".equals(fieldType)) {
					field.set(result, obj != null ? (Timestamp) obj : null);
				} else if ("class java.sql.Time".equals(fieldType)) {
					field.set(result, obj != null ? (Time) obj : null);
				}

			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

			stt++;
		}

		return result;
	}

	@SuppressWarnings({ "rawtypes" })
	public static <T> List transformList(List list, Class<? extends T> input) {

		List<T> lstObject = new ArrayList<T>();
		for (int i = 0; i < list.size(); i++) {
			try {
				lstObject.add(input.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		List<Object> result = new ArrayList<>();

		Object item = null;

		Field[] fields = null;

		Object[] o = null;

		for (int i = 0; i < list.size(); i++) {

			fields = lstObject.get(i).getClass().getDeclaredFields();

			item = list.get(i);

			o = (Object[]) item;

			int stt = 0;

			String fieldType = "";

			Object obj = null;

			for (Field field : fields) {
				if (stt >= o.length)
					break;

				field.setAccessible(true);

				if ("serialVersionUID".equals(field.getName()))
					continue;

				fieldType = field.getType().toString();

				try {

					obj = o[stt];

					if ("class java.lang.String".equals(fieldType)) {
						field.set(lstObject.get(i), obj != null ? String.valueOf(obj) : "");
					} else if ("class java.lang.Long".equals(fieldType)) {
						field.set(lstObject.get(i), obj != null ? Long.valueOf(obj.toString()) : null);
					} else if ("class java.lang.Integer".equals(fieldType)) {
						field.set(lstObject.get(i), obj != null ? Integer.valueOf(obj.toString()) : null);
					} else if ("class java.math.BigDecimal".equals(fieldType)) {
						field.set(lstObject.get(i), obj != null ? (BigDecimal) obj : null);
					} else if ("class java.util.Date".equals(fieldType)) {
						field.set(lstObject.get(i), obj != null ? (Date) obj : null);
					} else if ("interface java.sql.Clob".equals(fieldType)) {
						field.set(lstObject.get(i), obj != null ? (Clob) obj : null);
					} else if ("class java.lang.Boolean".equals(fieldType)) {
						field.set(lstObject.get(i), obj != null ? (Boolean) obj : null);
					} else if ("class java.sql.Timestamp".equals(fieldType)) {
						field.set(lstObject.get(i), obj != null ? (Timestamp) obj : null);
					} else if ("class java.lang.Float".equals(fieldType)) {
						field.set(lstObject.get(i), obj != null ? (Float) obj : null);
					} else if ("class java.math.BigInteger".equals(fieldType)) {
						field.set(lstObject.get(i), obj != null ? (BigInteger) obj : null);
					} else if ("class java.util.UUID".equals(fieldType)) {
						field.set(lstObject.get(i), obj != null ? UUID.fromString(obj.toString()) : null);
					} else if ("class java.lang.Double".equals(fieldType)) {
						field.set(lstObject.get(i), obj != null ? (Double) obj : null);
					} else if ("class java.sql.Time".equals(fieldType)) {
						field.set(lstObject.get(i), obj != null ? (Time) obj : null);
					} else if ("class org.joda.time.DateTime".equals(fieldType)) {
						field.set(lstObject.get(i), obj != null ? (DateTime) obj : null);
					}

				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

				stt++;
			}

			result.add(lstObject.get(i));
		}
		return result;
	}

}
