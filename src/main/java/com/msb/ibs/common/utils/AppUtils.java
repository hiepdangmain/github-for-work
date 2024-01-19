package com.msb.ibs.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
public class AppUtils {
	/**
	 * Convert array of character to string,each item separate by '|' character.
	 */
	public static String convertArrayToString(String[] listOfField) {
		StringBuffer buffSendMessage = new StringBuffer();
		if (listOfField != null) {
			for (int i = 1; i < listOfField.length; i++) {
				buffSendMessage.append((listOfField[i] == null ? "" : listOfField[i]) + "|");
			}
		} else {
			return "";
		}
		return buffSendMessage.toString();
	}

	/**
	 * Append from the left string n character
	 */
	public static String padLeft(String s, int minLen, char ch) {
		int numPadChars = minLen - s.length();
		if (numPadChars <= 0)
			return s; // nothing to pad
		StringBuffer sb = new StringBuffer(minLen);
		for (int i = 0; i < numPadChars; i++)
			sb.append(ch);
		sb.append(s);
		return sb.toString();
	}

	/**
	 * Append from the Right string n character
	 */
	public static String padRight(String s, int minLen, char ch) {
		int numPadChars = minLen - s.length();
		if (numPadChars <= 0)
			return s; // nothing to pad
		StringBuffer sb = new StringBuffer(minLen);
		sb.append(s);
		for (int i = 0; i < numPadChars; i++)
			sb.append(ch);
		return sb.toString();
	}

	/**
	 * Converts java.util.Date to JulianDate format(yyyyD)
	 */
	public static Date getDateFromJulian7(String julianDate) throws ParseException {
		return new SimpleDateFormat("yyyyD").parse(julianDate);
	}

	/**
	 * Converts java.util.Date to JulianDate format(yyyyD)
	 */
	public static String getJulian7FromDate(Date date) {
		StringBuilder sb = new StringBuilder();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		return sb.append(cal.get(Calendar.YEAR)).append(String.format("%03d", cal.get(Calendar.DAY_OF_YEAR)))
				.toString();
	}

	/**
	 * Get current date time in specified format.
	 */
	public static String now(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(cal.getTime());
	}

	/*
	 * Replace special character of message before send to host
	 */
	public static String ReplaceCorebankSpecChar(String input) {
		// deny characters ~`#^*_<>;'{}[]|\
		if (input != null) {
			input = input.replace("}", "");
			input = input.replace("{", "");
			input = input.replace(";", "");
			input = input.replace("\\", "");
			// input = input.replace("_", "");
			input = input.replace("#", "");
			input = input.replace("*", "");
			input = input.replace("~", "");
			input = input.replace("`", "");
			input = input.replace("^", "");
			input = input.replace("'", "");
			input = input.replace("\\<", "");
			input = input.replace("<", "");
			input = input.replace("\\>", "");
			input = input.replace(">", "");
			input = input.replace("[", "");
			input = input.replace("]", "");
			input = input.replace("|", "");
			return input;
		} else {
			return "";
		}
	}

	/**
	 * Get branch length 3
	 */
	public static String subBranch(String branch) {
		if (branch != null && branch.length() == 5) {
			return branch.substring(3);
		} else {
			return branch;
		}

	}

	/**
	 * Check input string is valid number or not
	 */
	public static boolean isValidNumber(String str) {
		if (str == null || str.length() == 0)
			return false;
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}
	
	public static String convertJsonRespCode(String responseValue) {
		if (StringUtils.isEmpty(responseValue)) {
			return "";
		}
		String response = responseValue;
		try {
			String respCodeOld = "";
			String respCodeNew = "";
			String match = "respCode";
			if (responseValue.contains(match)) {
				int lengthPass = response.indexOf(match);
				String strSub = response.substring(lengthPass, response.length());
				int lengthStart = lengthPass + match.length() + 3;
				int lengthEnd =  lengthPass + (strSub.indexOf("\",") > 0 ? strSub.indexOf("\",") : strSub.indexOf("\"}"));
				if (lengthStart < lengthEnd) {
					StringBuffer buf = new StringBuffer(response);
					respCodeOld = response.substring(lengthStart, lengthEnd);
					if (!"000".contains(respCodeOld)) {
						if (StringUtils.isNumeric(respCodeOld)) {
							respCodeNew = String.valueOf((Integer.parseInt(respCodeOld) + 1000));
							response = buf.replace(lengthStart, lengthEnd, respCodeNew).toString();
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}
}
