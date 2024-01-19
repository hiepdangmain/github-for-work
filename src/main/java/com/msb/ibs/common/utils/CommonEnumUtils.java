/**
 * TODO
 *
 * @author binhnt26
 * @since Aug 25, 2021
 */
package com.msb.ibs.common.utils;

/**
 * @author binhnt26
 *
 */
public class CommonEnumUtils extends org.apache.commons.lang3.EnumUtils {

	public static <E extends Enum<E>> boolean isInEnum(String value, Class<E> enumClass) {
		for (E e : enumClass.getEnumConstants()) {
			if (e.name().equalsIgnoreCase(value)) {
				return true;
			}
		}
		return false;
	}

	public static <T extends Enum<T>> T getEnumFromString(Class<T> c, String string) {
		if (c != null && string != null) {
			try {
				return Enum.valueOf(c, string.trim().toUpperCase());
			} catch (IllegalArgumentException ex) {
			}
		}
		return null;
	}

}
