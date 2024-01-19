package com.msb.ibs.common.enums;

import org.springframework.util.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
@Getter
@AllArgsConstructor
public enum LanguageEnum {
	VI("vi_VN", "vi-VN", "vi", "VN"), EN("en_US", "en-US", "en", "US");

	private final String key;
	private final String value;
	private final String lang;
	private final String country;

	public static boolean contains(String name) {
		if (!StringUtils.hasText(name)) {
			return false;
		}

		LanguageEnum[] lst = LanguageEnum.values();
		for (LanguageEnum obj : lst) {
			if (obj.getKey().equalsIgnoreCase(name.trim()) || obj.getValue().equalsIgnoreCase(name.trim())) {
				return true;
			}
		}
		return false;
	}
}
