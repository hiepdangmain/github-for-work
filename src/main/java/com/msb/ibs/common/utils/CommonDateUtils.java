package com.msb.ibs.common.utils;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;
import java.sql.Timestamp;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * @author binhnt26
 */
public class CommonDateUtils extends org.apache.commons.lang3.time.DateUtils {

	private static final String TIME_ZONE_VN = "Asia/Ho_Chi_Minh";
	public static final String FORMAT_DATETIME_TYPE1 = "dd/MM/yyyy HH:mm:ss.SSS";
	public static final String FORMAT_DATETIME_TYPE2 = "yyyyMMddHHmmssSSS";
	public static final String FORMAT_DATETIME_TYPE3 = "dd-MM-yyyy HH:mm:ss.SSS";

	private static Date getLocalDate(Date input) {
		return new DateTime(input).withZone(DateTimeZone.forTimeZone(TimeZone.getTimeZone(TIME_ZONE_VN)))
				.toLocalDateTime().toDate();
	}

	public static Date getEndOfDay(Date input) {
		Calendar out = Calendar.getInstance();
		out.setTime(input);
		out.setTimeZone(TimeZone.getTimeZone(TIME_ZONE_VN));
		out.set(Calendar.DATE, out.get(Calendar.DAY_OF_MONTH));
		out.set(Calendar.YEAR, out.get(Calendar.YEAR));
		out.set(Calendar.MONTH, out.get(Calendar.MONTH));
		out.set(Calendar.HOUR_OF_DAY, 23);
		out.set(Calendar.MINUTE, 59);
		out.set(Calendar.SECOND, 59);
		out.set(Calendar.MILLISECOND, 0);
		return getLocalDate(out.getTime());
	}

	public static Date getStartOfDay(Date input) {
		Calendar out = Calendar.getInstance();
		out.setTime(input);
		out.setTimeZone(TimeZone.getTimeZone(TIME_ZONE_VN));
		out.set(Calendar.DATE, out.get(Calendar.DAY_OF_MONTH));
		out.set(Calendar.YEAR, out.get(Calendar.YEAR));
		out.set(Calendar.MONTH, out.get(Calendar.MONTH));
		out.set(Calendar.HOUR_OF_DAY, 0);
		out.set(Calendar.MINUTE, 0);
		out.set(Calendar.SECOND, 0);
		out.set(Calendar.MILLISECOND, 0);
		return getLocalDate(out.getTime());
	}

	public static Date getCurrentDateOfVN() {
		return new DateTime().withZone(DateTimeZone.forTimeZone(TimeZone.getTimeZone(TIME_ZONE_VN))).toLocalDateTime()
				.toDate();
	}

	public static DateTime getCurrentDateTimeOfVN() {
		return DateTime.now(DateTimeZone.forTimeZone(TimeZone.getTimeZone(TIME_ZONE_VN)));
	}

	/**
	 * Time in the format by type
	 *
	 * @param input datetime
	 * @type
	 * @return string
	 */
	public static String formatDatetimeByType(Date input, String type) {
		SimpleDateFormat sdf = new SimpleDateFormat(type);
		return sdf.format(input);
	}
	
	public static String getCurrentDateOfVNByType(String type) {
		return new SimpleDateFormat(type).format(getCurrentDateOfVN());
	}

	/**
	 * Current time in the format dd/MM/yyyy HH:mm:ss.SSS
	 *
	 * @return string
	 */
	public static String formatDatetimeType1() {
		return new SimpleDateFormat(FORMAT_DATETIME_TYPE1).format(getCurrentDateOfVN());
	}

	/**
	 * Add for cache
	 *
	 * @author quangtd5
	 */
	public static Timestamp toTimestamp(String datetime, String pattern) {
		if (CommonStringUtils.isNullOrEmpty(datetime))
			return null;
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat(pattern);
			formatter.setLenient(false);
			date = (Date) formatter.parse(datetime);
		} catch (ParseException e) {
			return null;
		}

		if (date == null) {
			return null;
		}

		return new Timestamp(date.getTime());
	}

	/**
	 * Format date to string
	 * 
	 * @param input
	 * @param format
	 * @return
	 */
	public static String formatDateToString(Date input, String format) {
		if (input == null)
			return "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(input);
		} catch (Exception e) {
			return "";
		}
	}
	
	public static Long getTime(Date input, Long defaultTime) {
		try {
			if (Objects.isNull(input)) {
				return defaultTime;
			}
			return input.getTime();
		} catch (Exception e) {
			return 0L;
		}
	}
}
