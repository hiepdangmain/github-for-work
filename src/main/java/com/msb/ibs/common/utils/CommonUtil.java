package com.msb.ibs.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
public class CommonUtil {
	public static final SimpleDateFormat sdfTimeFormat = new SimpleDateFormat("HH:mm:ss");

	/**
	 * Convert Array to ArrayList
	 * 
	 * @param a
	 * @return
	 */
	public static <T> List<T> arrayToArrayList(T[] a) {
		return Arrays.asList(a);
	}

	/**
	 * Convert Collection to ArrayList
	 * 
	 * @param c
	 * @return
	 */
	public static <T> List<T> collectionToArrayList(Collection<T> c) {
		return new ArrayList<T>(c);
	}

	/**
	 * Check email
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmail(String s) {
		if (CommonUtil.isEmpty(s)) {
			return false;
		}
		try {
			Pattern pattern = Pattern.compile("(\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6})");
			Matcher matcher = pattern.matcher(s.trim());
			if (matcher.find()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isInteger(String str) {
		if (str == null || !str.matches("[0-9]+$")) {
			return false;
		}
		return true;
	}

	public static boolean isPhoneNumber(String str) {
		if (str == null || (str != null && str.length() > 1 && str.charAt(0) != '8' && str.charAt(1) != '4')) {
			return false;
		}
		return true;
	}

	/**
	 * QuynhNV
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public static boolean validatePhoneNumber(String phoneNumber) {
		if (phoneNumber != null && !phoneNumber.isEmpty()) {
			boolean isValid = false;
			String expression = "([+]?[-]?[0-9\\-]?){9,11}[0-9]$";
			CharSequence inputStr = phoneNumber;
			Pattern pattern = Pattern.compile(expression);
			Matcher matcher = pattern.matcher(inputStr);
			if (phoneNumber.length() >= 9 || phoneNumber.length() <= 11) {
				if (matcher.matches()) {
					isValid = true;
				}
			} else {
				isValid = false;
			}
			return isValid;
		}
		return false;
	}

	public static boolean isWhiteSpace(String str) {
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	}

	/**
	 * Check empty
	 * 
	 * @param h
	 * @return
	 */
	public static boolean isEmpty(Hashtable<?, ?> h) {
		if (h == null || h.size() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Object[] o) {
		if (o == null || o.length == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Vector<?> v) {
		if (v == null || v.size() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(String s) {
		if (s == null || s.trim().equalsIgnoreCase("")) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(List<?> l) {
		if (l == null || l.size() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Set<?> s) {
		if (s == null || s.size() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(Map<?, ?> m) {
		if (m == null || m.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Check equal
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isEqual(String str1, String str2) {
		boolean b1 = str1 == null;
		boolean b2 = str2 == null;
		if (b1 && b2) {
			return true;
		}
		if ((b1 & !b2) || (!b1 & b2)) {
			return false;
		}
		return str1.equals(str2);
	}

	/**
	 * Check digit string
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDigitString(String str) {
		if (CommonUtil.isEmpty(str)) {
			return false;
		}
		char[] arrChar = str.toCharArray();
		for (int i = 0; i < arrChar.length; i++) {
			if (!Character.isDigit(arrChar[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Create random long
	 * 
	 * @return
	 */
	public static Long randomLongNumber() {
		Long rs = 0L;
		Double d = Math.random();
		rs = Math.round(d * 1000000000000000L);
		return rs;
	}

	/**
	 * Convert So sang string
	 * 
	 * @param bigDecimal
	 * @param format
	 * @return
	 */
	public static String formatNumber(BigDecimal bigDecimal, String format) {
		NumberFormat numberFormat = new DecimalFormat(format);
		return numberFormat.format(bigDecimal);
	}

	/**
	 * Replace blank spaces
	 * 
	 * @param s
	 * @return
	 */
	public static String trimBlankSpaces(String s) {
		if (s == null) {
			return null;
		}
		s = s.trim();
		s = s.replaceAll("\\s+", " ");
		return s;
	}

	/**
	 * Replace blank spaces
	 * 
	 * @param s
	 * @return
	 */
	public static String trimBlankSpacesSpecial(String s) {
		if (s == null) {
			return null;
		}
		s = s.trim();
		s = s.replaceAll("\\s", "");
		return s;
	}

	/**
	 * Return default value if object is null
	 * 
	 * @param value
	 * @param nullValue
	 * @param notNullValue
	 * @return
	 */
	public static Long NVL(Long value, Long nullValue, Long notNullValue) {
		return value == null ? nullValue : notNullValue;
	}

	public static Long NVL(Long value, Long defaultValue) {
		return NVL(value, defaultValue, value);
	}

	public static Long NVL(Long value) {
		return NVL(value, 0L);
	}

	public static Number NVL(Number value, Number nullValue, Number notNullValue) {
		return value == null ? nullValue : notNullValue;
	}

	public static Number NVL(Number value, Number defaultValue) {
		return NVL(value, defaultValue, value);
	}

	public static Number NVL(Number value) {
		if (value instanceof Long) {
			return NVL(value, 0L);
		} else if (value instanceof Double) {
			return NVL(value, 0D);
		}
		return NVL(value, 0);
	}

	public static Double NVL(Double value, Double nullValue, Double notNullValue) {
		return value == null ? nullValue : notNullValue;
	}

	public static Double NVL(Double value, Double defaultValue) {
		return NVL(value, defaultValue, value);
	}

	public static Double NVL(Double value) {
		return NVL(value, new Double(0));
	}

	public static String NVL(String value, String nullValue, String notNullValue) {
		return value == null ? nullValue : notNullValue;
	}

	public static String NVL(String value, String defaultValue) {
		return NVL(value, defaultValue, value);
	}

	public static String NVL(String value) {
		return NVL(value, "");
	}

	public static Object NVL(Object value, Object nullValue, Object notNullValue) {
		return value == null ? nullValue : notNullValue;
	}

	public static Object NVL(Object value, Object defaultValue) {
		return NVL(value, defaultValue, value);
	}

	public static Integer getKeyFromMap(Map<Integer, Object[]> map, Object[] values) throws Exception {
		Set<Integer> keySet = map.keySet();
		for (Integer key : keySet) {
			Object[] vs = map.get(key);
			if (vs.length != values.length)
				continue;
			int length = vs.length;
			boolean valid = true;
			for (int i = 0; i < length; i++) {
				if ((vs[i] != null && values[i] == null) || (vs[i] == null && values[i] != null)
						|| (vs[i] != null && !vs[i].equals(values[i])))
					valid = false;
			}
			if (valid)
				return key;
		}
		throw new Exception("Key not found!");
	}

	public static String convertValueToJson(Map<String, Object> params) {
		JSONObject json = new JSONObject();
		if (params != null) {
			for (Map.Entry<String, Object> param : params.entrySet()) {
				try {
					json.put(param.getKey(), param.getValue());
				} catch (JSONException e) {
					return "";
				}
			}
		}
		return json.toString();
	}

	public static Object getItemInJson(String item, String strJsonData) {
		Object result = null;
		try {
			JSONObject obj = new JSONObject(strJsonData);
			result = obj.get(item);
		} catch (Exception e) {
			return null;
		}
		return result;
	}

	public static String maskCardNumber(String ccnum, char mask) {
		int total = ccnum.length();
		int startlen = 4, endlen = 4;
		int masklen = total - (startlen + endlen);
		StringBuffer maskedbuf = new StringBuffer(ccnum.substring(0, startlen));
		for (int i = 0; i < masklen; i++) {
			maskedbuf.append(mask);
		}
		maskedbuf.append(ccnum.substring(startlen + masklen, total));
		String masked = maskedbuf.toString();
		return masked;
	}

	public static boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	public static int calFromRecordNumber(int pCurPageNO, int pPageSize) {
		return pPageSize * (pCurPageNO - 1) + 1;
	}

	public static int calToRecordNumber(int pCurPageNO, int pPageSize) {
		return pPageSize * pCurPageNO;
	}

	public static String createURLforGet(Object inputObject) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost");
		try {
			Class c = inputObject.getClass();
			java.lang.reflect.Method[] m = c.getDeclaredMethods();

			for (java.lang.reflect.Method e : m) {
				String property = e.getName();
				if (property.startsWith("get")) {
					Object value = e.invoke(inputObject);
					if (value != null) {
						String pro = (StringUtil.decapitalize(property.substring(3)));
						builder.queryParam(pro, value);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.toUriString().replace("http://localhost", "");
	}

	public static String unescape(String s) {
		StringBuffer sbuf = new StringBuffer();
		int l = s.length();
		int ch = -1;
		int b, sumb = 0;
		for (int i = 0, more = -1; i < l; i++) {
			/* Get next byte b from URL segment s */
			switch (ch = s.charAt(i)) {
			case '%':
				ch = s.charAt(++i);
				int hb = (Character.isDigit((char) ch) ? ch - '0' : 10 + Character.toLowerCase((char) ch) - 'a') & 0xF;
				ch = s.charAt(++i);
				int lb = (Character.isDigit((char) ch) ? ch - '0' : 10 + Character.toLowerCase((char) ch) - 'a') & 0xF;
				b = (hb << 4) | lb;
				break;
			case '+':
				b = ' ';
				break;
			default:
				b = ch;
			}
			/* Decode byte b as UTF-8, sumb collects incomplete chars */
			if ((b & 0xc0) == 0x80) { // 10xxxxxx (continuation byte)
				sumb = (sumb << 6) | (b & 0x3f); // Add 6 bits to sumb
				if (--more == 0)
					sbuf.append((char) sumb); // Add char to sbuf
			} else if ((b & 0x80) == 0x00) { // 0xxxxxxx (yields 7 bits)
				sbuf.append((char) b); // Store in sbuf
			} else if ((b & 0xe0) == 0xc0) { // 110xxxxx (yields 5 bits)
				sumb = b & 0x1f;
				more = 1; // Expect 1 more byte
			} else if ((b & 0xf0) == 0xe0) { // 1110xxxx (yields 4 bits)
				sumb = b & 0x0f;
				more = 2; // Expect 2 more bytes
			} else if ((b & 0xf8) == 0xf0) { // 11110xxx (yields 3 bits)
				sumb = b & 0x07;
				more = 3; // Expect 3 more bytes
			} else if ((b & 0xfc) == 0xf8) { // 111110xx (yields 2 bits)
				sumb = b & 0x03;
				more = 4; // Expect 4 more bytes
			} else /* if ((b & 0xfe) == 0xfc) */ { // 1111110x (yields 1 bit)
				sumb = b & 0x01;
				more = 5; // Expect 5 more bytes
			}
			/* We don't test if the UTF-8 encoding is well-formed */
		}
		return sbuf.toString();
	}

	public static String genWorkflowTaskId(String workflowName, String tranSn) {
		return workflowName + "." + tranSn;
	}
}
