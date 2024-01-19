/**
 * TODO
 *
 * @author binhnt26
 * @since Sep 16, 2021
 */
package com.msb.ibs.common.dispatcher;

import java.lang.reflect.Field;

/**
 * @author binhnt26
 * 
 *         Utility interface that trims all String fields of the implementing
 *         class.
 * 
 */
public interface Trimmable {

	/**
	 * Trim all Strings
	 */
	default void trim() {
		for (Field field : this.getClass().getDeclaredFields()) {
			try {
				field.setAccessible(true);
				Object value = field.get(this);
				if (value != null) {
					if (value instanceof String) {
						String trimmed = (String) value;
						field.set(this, trimmed.trim());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	default void nullDefault() {
		for (Field field : this.getClass().getDeclaredFields()) {
			try {
				field.setAccessible(true);
				Object value = field.get(this);
				if (value == "") {
					if (value instanceof String) {
						field.set(this, null);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	default void emptyDefault() {
		for (Field field : this.getClass().getDeclaredFields()) {
			try {
				field.setAccessible(true);
				Object value = field.get(this);
				if (value == null) {
					field.set(this, "");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
