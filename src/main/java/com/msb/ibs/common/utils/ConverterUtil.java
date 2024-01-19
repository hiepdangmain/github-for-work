package com.msb.ibs.common.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
//import org.simpleframework.xml.core.Persister;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ConverterUtil {
	private static final SimpleDateFormat calendarDatetimeSdf = new SimpleDateFormat("yyyyMMdd'T'HHmm'00'");
	private static final DecimalFormat numberDf = new DecimalFormat("######");
	private static final DecimalFormat doubleDf = new DecimalFormat("######.#########");
	private static final DecimalFormat numberCommaDf = new DecimalFormat("###,###");
	private static final DecimalFormat doubleCommaDf = new DecimalFormat("###,###.#########");
	private static final DecimalFormat percentDf = new DecimalFormat("#%");
	private static final Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
	private static final Map<String, String[]> MAP_SIGNED_CHAR = new HashMap<String, String[]>();
	private static Set<String> KEY_SET_MAP_SIGNED_CHAR;

	static {
		MAP_SIGNED_CHAR.put("a",
				new String[] { "à", "á", "ạ", "ả", "ã", "â", "ầ", "ấ", "ậ", "ẩ", "ẫ", "ă", "ằ", "ắ", "ặ", "ẳ", "ẵ" });
		MAP_SIGNED_CHAR.put("e", new String[] { "è", "é", "ẹ", "ẻ", "ẽ", "ê", "ề", "ế", "ệ", "ể", "ễ" });
		MAP_SIGNED_CHAR.put("i", new String[] { "ì", "í", "ị", "ỉ", "ĩ" });
		MAP_SIGNED_CHAR.put("o",
				new String[] { "ò", "ó", "ọ", "ỏ", "õ", "ô", "ồ", "ố", "ộ", "ổ", "ỗ", "ơ", "ờ", "ớ", "ợ", "ở", "ỡ" });
		MAP_SIGNED_CHAR.put("u", new String[] { "ù", "ú", "ụ", "ủ", "ũ", "ư", "ừ", "ứ", "ự", "ử", "ữ" });
		MAP_SIGNED_CHAR.put("y", new String[] { "ỳ", "ý", "ỵ", "ỷ", "ỹ" });
		MAP_SIGNED_CHAR.put("d", new String[] { "đ" });
		MAP_SIGNED_CHAR.put("A",
				new String[] { "À", "Á", "Ạ", "Ả", "Ã", "Â", "Ầ", "Ấ", "Ậ", "Ẩ", "Ẫ", "Ă", "Ằ", "Ắ", "Ặ", "Ẳ", "Ẵ" });
		MAP_SIGNED_CHAR.put("E", new String[] { "È", "É", "Ẹ", "Ẻ", "Ẽ", "Ê", "Ề", "Ế", "Ệ", "Ể", "Ễ" });
		MAP_SIGNED_CHAR.put("I", new String[] { "Ì", "Í", "Ị", "Ỉ", "Ĩ" });
		MAP_SIGNED_CHAR.put("O",
				new String[] { "Ò", "Ó", "Ọ", "Ỏ", "Õ", "Ô", "Ồ", "Ố", "Ộ", "Ổ", "Ỗ", "Ơ", "Ờ", "Ớ", "Ợ", "Ở", "Ỡ" });
		MAP_SIGNED_CHAR.put("U", new String[] { "Ù", "Ú", "Ụ", "Ủ", "Ũ", "Ư", "Ừ", "Ứ", "Ự", "Ử", "Ữ" });
		MAP_SIGNED_CHAR.put("Y", new String[] { "Ỳ", "Ý", "Ỵ", "Ỷ", "Ỹ" });
		MAP_SIGNED_CHAR.put("D", new String[] { "Đ" });
		KEY_SET_MAP_SIGNED_CHAR = MAP_SIGNED_CHAR.keySet();
	}

	public static String getMapSignedCharKey(char c) {
		String[] values;
		for (String key : KEY_SET_MAP_SIGNED_CHAR) {
			values = MAP_SIGNED_CHAR.get(key);
			for (String value : values) {
				if (value.equals(c))
					return key;
			}
		}
		return null;
	}

	public static String toUnsignedChar(String s) {
		if (s == null)
			return null;
		if (s.length() == 0)
			return "";
		String[] values;
		for (String key : KEY_SET_MAP_SIGNED_CHAR) {
			values = MAP_SIGNED_CHAR.get(key);
			for (String value : values) {
				s = s.replace(value, key);
			}
		}
		return s;
	}

	/**
	 * Convert format abcDefGhi to abc_def_ghi
	 * 
	 * @param entityName
	 * @return
	 */
	public static String entityNameToTableName(String entityName) {
		if (entityName == null || entityName.length() <= 1) {
			return entityName;
		}
		StringBuffer tmp = new StringBuffer(entityName);
		StringBuffer rs = new StringBuffer();
		rs.append(tmp.charAt(0));
		for (int i = 1; i < tmp.length(); i++) {
			char c = tmp.charAt(i);
			if (Character.isUpperCase(c)) {
				rs.append("_");
			}
			rs.append(c);
		}
		return rs.toString().toLowerCase();
	}

	/**
	 * Convert Object to ByteArray
	 * 
	 * @param o
	 * @return
	 */
	public static byte[] toByteArray(Object o) {
		if (o == null)
			return null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(o);
			byte[] buf = baos.toByteArray();
			return buf;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Convert ByteArray to Object
	 * 
	 * @param b
	 * @return
	 */
	public static Object toObject(byte[] b) {
		if (b == null) {
			return null;
		}
		try {
			ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(b));
			Object object = ois.readObject();
			ois.close();
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Convert first letter to lower case
	 * 
	 * @param s
	 * @return
	 */
	public static String toLowerCaseFirstLetter(String s) {
		if (s == null) {
			return null;
		}
		String firstLetter = s.substring(0, 1).toLowerCase();
		return firstLetter + s.substring(1, s.length());
	}

	/**
	 * Convert first letter to upper case
	 * 
	 * @param s
	 * @return
	 */
	public static String toUppperCaseFirstLetter(String s) {
		if (s == null) {
			return null;
		}
		String firstLetter = s.substring(0, 1).toUpperCase();
		return firstLetter + s.substring(1, s.length());
	}

	/**
	 * Convert String to Date manual format
	 * 
	 * @param s
	 * @param format
	 * @return
	 */
	public static Date toDate(String s, String format) {
		if (CommonUtil.isEmpty(s)) {
			return null;
		}
		try {
			SimpleDateFormat df = new SimpleDateFormat(format);
			return df.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Convert string of milisecond to date
	 * 
	 * @param s
	 * @return
	 */
	public static Date toDateMilisecond(String s) {
		try {
			Date date = new Date();
			date.setTime(Long.valueOf(s));
			return date;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Convert date to string manual format
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String toString(Date date, String format) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * Convert date time to string for calendar date time
	 * 
	 * @param date
	 * @return
	 */
	public static String toStringCalendarDatetime(Date date) {
		if (date == null) {
			return "";
		}
		return calendarDatetimeSdf.format(date);
	}

	/**
	 * Convert date time to string of milisecond
	 * 
	 * @param date
	 * @return
	 */
	public static String toStringMilisecond(Date date) {
		if (date == null) {
			return "";
		}
		return String.valueOf(date.getTime());
	}

	/**
	 * Convert number to string with prefix zero
	 * 
	 * @param n
	 * @param length
	 * @return
	 */
	public static String numberToString(Number n, int length) {
		String s = new String();
		if (n == null) {
			return s;
		}
		for (int i = 0; i < length; i++) {
			if (n.longValue() < Math.pow(10, i)) {
				s += "0";
			}
		}
		if (n.longValue() > 0) {
			s += n.toString();
		}
		return s;
	}

	/**
	 * Convert java.util.Date to java.sql.Date
	 * 
	 * @param date
	 * @return
	 */
	public static java.sql.Date toSqlDate(Date date) {
		if (date == null) {
			return null;
		}
		return new java.sql.Date(date.getTime());
	}

	/**
	 * Convert Array to ArrayList
	 * 
	 * @param a
	 * @return
	 */
	public static <T> List<T> toArrayList(T[] a) {
		return Arrays.asList(a);
	}

	/**
	 * Convert Collection to ArrayList
	 * 
	 * @param c
	 * @return
	 */
	public static <T> List<T> toArrayList(Collection<T> c) {
		return new ArrayList(c);
	}

	/**
	 * Convert Map to JSON
	 * 
	 * @param map
	 * @return
	 */
	public static String toJsonString(Map<String, String> map) {
		String json = "";
		if (map == null)
			return json;
		try {
			json = new ObjectMapper().writeValueAsString(map);
		} catch (Exception e) {
		}
		return json;
	}

	/**
	 * Convert JSON to Map
	 * 
	 * @param json
	 * @return
	 */
	public static Map<String, String> toMap(String json) {
		Map<String, String> map = new HashMap<String, String>();
		if (json == null)
			return map;
		try {
			map = new ObjectMapper().readValue(json, new TypeReference<HashMap<String, String>>() {
			});
		} catch (Exception e) {
		}
		return map;
	}

	/**
	 * Convert Object to JSON
	 *
	 * @return
	 */
	public static String toJsonString(Object obj) {
		String json = "";
		if (obj == null)
			return json;
		return gson.toJson(obj);
	}

	/**
	 * Convert List to JSON
	 *
	 * @return
	 */
	public static String toJsonString(List<Object> objs) {
		String json = "";
		if (objs == null)
			return json;
		return gson.toJson(objs);
	}

	/**
	 * Convert string to object
	 * 
	 * @param c
	 * @param json
	 * @return
	 */
	public static <T> T fromJSON(Class<T> c, String json) {
		return gson.fromJson(json, c);
	}

	/**
	 * Convert string to object
	 *
	 * @param json
	 * @return
	 */
	public static <T> List<T> fromJSON(String json) {
		return gson.fromJson(json, new TypeToken<List<T>>() {
		}.getType());
	}

	/**
	 * Convert string to object
	 * 
	 * @param c
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public static <T> T json2object(Class<T> c, String json) throws Exception {
		return new ObjectMapper().readValue(json, c);
	}

	/**
	 * 
	 * @param d
	 * @return
	 */
	public static String formatNumber(Long d) {
		if (d == null) {
			return "";
		} else {
			return numberDf.format(d);
		}
	}

	/**
	 * 
	 * @param d
	 * @return
	 */
	public static String formatNumber(Double d) {
		if (d == null) {
			return "";
		} else {
			return doubleDf.format(d);
		}
	}

	/**
	 * 
	 * @param d
	 * @return
	 */
	public static String formatCommaNumber(Long d) {
		if (d == null) {
			return "";
		} else {
			return numberCommaDf.format(d);
		}
	}

	/**
	 * 
	 * @param d
	 * @return
	 */
	public static String formatCommaNumber(Double d) {
		if (d == null) {
			return "";
		} else {
			return doubleCommaDf.format(d);
		}
	}

	/**
	 * 
	 * @param d
	 * @param format
	 * @return
	 */
	public static String formatCommaNumber(Double d, String format) {
		if (d == null) {
			return "";
		} else {
			DecimalFormat decimalFormat = new DecimalFormat(format);
			return decimalFormat.format(d);
		}
	}

	/**
	 * 
	 * @param d
	 * @return
	 */
	public static String formatPercent(Double d) {
		if (d == null) {
			return "";
		} else {
			return percentDf.format(d / 100);
		}
	}

	/**
	 * 
	 * @param s
	 * @param l
	 * @return
	 * @throws Exception
	 */
	public static String formatMaxLength(String s, int l) throws Exception {
		if (s == null)
			return null;
		if (s.length() <= l)
			return s;
		return s.substring(0, l) + "...";
	}

	/**
	 * Convert Exception to String
	 * 
	 * @param ex
	 * @return
	 * @throws Exception
	 */
	public static String toString(Exception ex) throws Exception {
		try {
			StringWriter errors = new StringWriter();
			ex.printStackTrace(new PrintWriter(errors));
			return errors.toString();
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * Convert BigDecimal to Long
	 * 
	 * @param num
	 * @return
	 */
	public static Long toLongValue(Object num) {
		if (num == null)
			return null;
		return ((BigDecimal) num).longValue();
	}

	/**
	 * Convert BigDecimal to Integer
	 * 
	 * @param num
	 * @return
	 */
	public static Integer toIntValue(Object num) {
		if (num == null)
			return null;
		return ((BigDecimal) num).intValue();
	}

	/**
	 * Convert BigDecimal to Double
	 * 
	 * @param num
	 * @return
	 */
	public static Double toDoubleValue(Object num) {
		if (num == null)
			return null;
		return ((BigDecimal) num).doubleValue();
	}

	/**
	 * 
	 * @param num
	 * @return
	 */
	public static BigDecimal getBigDecimalAmount(BigDecimal num) {
		if (num == null) {
			return null;
		}
		return num.setScale(0, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 
	 * @param <T>
	 * @param jArr
	 * @return
	 */
	public static <T> ArrayList<T> convertJSONArrayToList(JSONArray jArr) {
		ArrayList<T> list = new ArrayList<T>();
		try {
			for (int i = 0, l = jArr.length(); i < l; i++) {
				list.add((T) jArr.get(i));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public static JSONArray convertconvertListToJSONArray(Collection<Object> list) {
		return new JSONArray(list);
	}

	/**
	 *
	 * @return
	 */
//	public static String convertObjectXMLToString(Object o) {
//		StringWriter strWriter = new StringWriter();
//		Persister persis = new Persister();
//		String result = "";
//		try {
//			persis.write(o, strWriter);
//			result = strWriter.toString();
//		} catch (Exception e1) {
//			System.out.println("convertObjectXMLToString: " + e1.getMessage());
//		}
//		return result;
//	}

//	public static <T> T convertStringXMLToObject(Class<T> c, String input) {
//		Persister persis = new Persister();
//		try {
//			return persis.read(c, input);
//		} catch (Exception e1) {
//			System.out.println("convertStringXMLToObject: " + e1.getMessage());
//		}
//		return null;
//	}
	
	public static String convertRequestBodyHidePass(String requestBodyParam) {
		if (StringUtils.isEmpty(requestBodyParam)) {
			return "";
		}
		String requestBody = requestBodyParam;
		try {
			List<String> hideArr = Arrays.asList("password", "oldPassword", "newPassword", "rePassword");
			for (int i = 0; i < hideArr.size(); i++) {
				if (requestBodyParam.contains(hideArr.get(i))) {
					int lengthPass = requestBody.indexOf(hideArr.get(i));
					if (lengthPass < 0) continue;
					String strSub = requestBody.substring(lengthPass, requestBody.length());
					int lengthStart = lengthPass + hideArr.get(i).length() + 3;
					int lengthEnd =  lengthPass + (strSub.indexOf("\",") > 0 ? strSub.indexOf("\",") : strSub.indexOf("\"}"));
					if (lengthStart < lengthEnd) {
						StringBuffer buf = new StringBuffer(requestBody);
						requestBody = buf.replace(lengthStart, lengthEnd, "*****").toString();
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return requestBody;
	}
	
	public static BufferedImage generateQrCodeImage(String qrString) throws Exception {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
	    BitMatrix matrix = qrCodeWriter.encode(qrString, BarcodeFormat.QR_CODE, 128, 128);
	    
		return MatrixToImageWriter.toBufferedImage(matrix);
	}

	public static byte[] toByteArray(BufferedImage img, String imageFileType) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ImageIO.write(img, imageFileType, os);
			return os.toByteArray();
		} catch (Throwable e) {
			throw new RuntimeException();
		}
	}
	
	public static void main(String[] args) {
		try {
			String qrString = "0009890325714010650000002068505080303VN";
			BufferedImage imageQr = generateQrCodeImage(qrString);
			String base64 = Base64.getEncoder().encodeToString(toByteArray(imageQr, "jpeg"));
			System.out.println("base64: " + base64);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}
}
