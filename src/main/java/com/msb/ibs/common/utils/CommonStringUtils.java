package com.msb.ibs.common.utils;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;

import lombok.SneakyThrows;

/**
 * @author binhnt26
 */
public class CommonStringUtils extends StringUtils {

	/**
	 * Add for cache
	 *
	 * @author quangtd5
	 */
	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f' };

	public static String join(Object[] array, String separator) {
		if (array == null) {
			return null;
		}
		int arraySize = array.length;
		StringBuilder buffer = new StringBuilder();

		for (int i = 0; i < arraySize; i++) {
			if (i > 0) {
				buffer.append(separator);
			}
			if (array[i] != null) {
				buffer.append(array[i]);
			}
		}
		return buffer.toString();
	}

	public static String md5Hex(String data) {
		if (data == null) {
			throw new IllegalArgumentException("data must not be null");
		}

		byte[] bytes = digest("MD5", data);

		return toHexString(bytes);
	}

	public static String sha1Hex(String data) {
		if (data == null) {
			throw new IllegalArgumentException("data must not be null");
		}

		byte[] bytes = digest("SHA1", data);

		return toHexString(bytes);
	}

	private static String toHexString(byte[] bytes) {
		int l = bytes.length;

		char[] out = new char[l << 1];

		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS[(0xF0 & bytes[i]) >>> 4];
			out[j++] = DIGITS[0x0F & bytes[i]];
		}

		return new String(out);
	}

	private static byte[] digest(String algorithm, String data) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		return digest.digest(data.getBytes());
	}

	/**
	 * end add for cache
	 *
	 * @author quangtd5
	 */

	public static boolean isNullOrEmpty(String input) {
		return StringUtils.isEmpty(input) && StringUtils.isBlank(input);
	}

	public static boolean isNotNullOrEmpty(String input) {
		return StringUtils.isNotEmpty(input) && StringUtils.isNotBlank(input);
	}

	public static String removeLastIndexCharacter(String input, String character) {
		if (isNotNullOrEmpty(input)) {
			input = input.substring(0, input.lastIndexOf(character));
		}

		return input;
	}

	public static String removeDuplicates(String input, String character) {
		if (isNotNullOrEmpty(input)) {
			input = Arrays.stream(input.split(character)).distinct().collect(Collectors.joining(character));
		}

		return input;
	}

	public static String escapeJava(String input) {
		if (isNotNullOrEmpty(input)) {
			input = StringEscapeUtils.escapeJava(input);
		}

		return input;
	}

	public static String escapeJson(String input) {
		if (isNotNullOrEmpty(input)) {
			input = StringEscapeUtils.escapeJson(input);
		}

		return input;
	}

	public static String escapeHtml4(String input) {
		if (isNotNullOrEmpty(input)) {
			input = StringEscapeUtils.escapeHtml4(input);
		}
		return input;
	}

	public static String unescapeJava(String input) {
		if (isNotNullOrEmpty(input)) {
			input = StringEscapeUtils.unescapeJava(input);
		}

		return input;
	}

	public static String unescapeJson(String input) {
		if (isNotNullOrEmpty(input)) {
			input = StringEscapeUtils.unescapeJson(input);
		}

		return input;
	}

	public static String unescapeHtml4(String input) {
		if (isNotNullOrEmpty(input)) {
			input = StringEscapeUtils.unescapeHtml4(input);
		}

		return input;
	}

	@SneakyThrows
	public static String encode(String input) {
		if (isNotNullOrEmpty(input)) {
			input = URLEncoder.encode(input, StandardCharsets.UTF_8.toString());
		}

		return input;
	}

	@SneakyThrows
	private String decode(String input) {
		if (isNotNullOrEmpty(input)) {
			input = URLDecoder.decode(input, StandardCharsets.UTF_8.toString());
		}

		return input;
	}
}
