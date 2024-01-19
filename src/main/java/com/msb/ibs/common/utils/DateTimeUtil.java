package com.msb.ibs.common.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3 
 */
public class DateTimeUtil {
	public static final SimpleDateFormat tranDate = new SimpleDateFormat("ddMMyy");
	public static final SimpleDateFormat forESB = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
	public static final SimpleDateFormat forESB2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
	public static final SimpleDateFormat forESBRequestId = new SimpleDateFormat("HHmmssSSS");
	public static final SimpleDateFormat forESBRequestId2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	public static final SimpleDateFormat forESBRequestId3 = new SimpleDateFormat("yyyyMMddHHmmss");
	public static final SimpleDateFormat yyMMddHHmmSS = new SimpleDateFormat("yyMMddHHmmSS");
	public static final String FORMAT_DATE_dMMyy = "dMMyy";
	public static final String FORMAT_DATE_ddMMyy = "ddMMyy";
	public static final String FORMAT_DATE_yyyyMMdd = "yyyyMMdd";
	public static final String FORMAT_DATE_yyyyDDD = "yyyyDDD";
	public static final String FORMAT_DATE_ddMMyyyy = "dd/MM/yyyy";
	public static final String FORMAT_DATE_ddMMMyyyy = "dd/MMM/yyyy";
	public static final String FORMAT_DATE_ddMMyyyyHHmmss = "dd/MM/yyyy HH:mm:ss";
	public static final String FORMAT_DATE_yyyyMMddTHHmmss = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String FORMAT_DATE_yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_DATE_yyyyMMDDHHmmss = "yyyyMMddHHmmss";
	public static final String FORMAT_DATE_yyyyMMDDHHmmssSSS = "yyyyMMddHHmmssSSS";
	public static final String FORMAT_DATE_HHmmss = "HH:mm:ss";
	public static final String FORMAT_DATE_HHmm = "HH:mm";
	public static final String END_TIME_TO_DAY = "23:59:59";
	
	public static Date concatDateTime(Date ccDate, Date ccTime) {
		SimpleDateFormat dfDateTime = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat dfDate = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dfTime = new SimpleDateFormat("HHmmss");
		String dateStr = dfDate.format(ccDate);
		String timeStr = ccTime == null ? "000000" : dfTime.format(ccTime);
		try {
			return dfDateTime.parse(dateStr + timeStr);
		} catch (ParseException e) {
		}
		return null;
	}

	public static String getTimeForESB() {
		return forESB.format(new Date());
	}

	public static String getTimeForESB2() {
		return forESB2.format(new Date());
	}

	public static String getTimeForESBRequestId() {
		return forESBRequestId.format(new Date());
	}

	public static String getTimeForESBRequestId2() {
		return forESBRequestId2.format(new Date());
	}

	public static String getTimeForESBRequestId3() {
		return forESBRequestId3.format(new Date());
	}

	public static boolean sameDay(Date oneDate, Date anotherDate) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(oneDate);
		int oneYear = gc.get(1);
		int oneMonth = gc.get(2);
		int oneDay = gc.get(5);
		gc.clear();
		gc.setTime(anotherDate);
		int anotherYear = gc.get(1);
		int anotherMonth = gc.get(2);
		int anotherDay = gc.get(5);
		if ((oneYear == anotherYear) && (oneMonth == anotherMonth) && (oneDay == anotherDay)) {
			return true;
		}
		return false;
	}

	public static boolean sameWeek(Date oneDate, Date anotherDate) {
		if (sameDay(oneDate, anotherDate)) {
			return true;
		}
		Date firstTime = null;
		Date secondTime = null;
		if (oneDate.after(anotherDate)) {
			firstTime = anotherDate;
			secondTime = oneDate;
		} else {
			firstTime = oneDate;
			secondTime = anotherDate;
		}
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(firstTime);
		gc.add(3, 1);
		Date tempTime = gc.getTime();
		if (!tempTime.after(secondTime)) {
			return false;
		}
		gc.clear();
		gc.setTime(firstTime);
		int firstWeekDay = gc.get(7);
		gc.clear();
		gc.setTime(secondTime);
		int secondWeekDay = gc.get(7);
		if (firstWeekDay < secondWeekDay) {
			return true;
		}
		return false;
	}

	public static boolean sameMonth(Date oneDate, Date anotherDate) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(oneDate);
		int oneYear = gc.get(1);
		int oneMonth = gc.get(2);
		gc.clear();
		gc.setTime(anotherDate);
		int anotherYear = gc.get(1);
		int anotherMonth = gc.get(2);
		if ((oneYear == anotherYear) && (oneMonth == anotherMonth)) {
			return true;
		}
		return false;
	}

	public static Date getDate(String str) {
		if ((str == null) || ("".equals(str))) {
			return null;
		}
		int date = Integer.parseInt(str.substring(0, 2));
		int month = Integer.parseInt(str.substring(3, 5)) - 1;
		int year = Integer.parseInt(str.substring(6, 10));
		Calendar newDate = Calendar.getInstance();
		newDate.set(year, month, date);
		return newDate.getTime();
	}

	public static Date getNextYearDate(String str) {
		if ((str == null) || ("".equals(str))) {
			return null;
		}
		int day = Integer.parseInt(str.substring(0, 2));
		int month = Integer.parseInt(str.substring(3, 5)) - 1;
		int year = Integer.parseInt(str.substring(6, 10));
		Calendar newDate = Calendar.getInstance();
		newDate.set(year + 1, month, day);
		newDate.set(Calendar.HOUR_OF_DAY, 23);
		newDate.set(Calendar.MINUTE, 59);
		newDate.set(Calendar.SECOND, 59);
		newDate.set(Calendar.MILLISECOND, 0);
		return newDate.getTime();
	}

	public String getFixPatternDate(Timestamp timestamp, int type) {
		if (timestamp == null) {
			return null;
		}
		SimpleDateFormat sdf = null;
		if (type == 1) {
			sdf = new SimpleDateFormat("yyyyMMdd");
		} else if (type == 2) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		} else if (type == 3) {
			sdf = new SimpleDateFormat("dd/MM/yyyy");
		} else {
			return null;
		}
		Date date = new Date(timestamp.getTime());
		String formateDate = sdf.format(date);
		return formateDate;
	}

	public static String getCurrentDate(int type) {
		SimpleDateFormat sdf = null;
		if (type == 1) {
			sdf = new SimpleDateFormat("yyyyMMdd");
		} else if (type == 2) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		} else if (type == 3) {
			sdf = new SimpleDateFormat("dd/MM/yyyy");
		} else if (type == 4) {
			sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		} else {
			return null;
		}
		Date date = new Date(System.currentTimeMillis());
		String formateDate = sdf.format(date);
		return formateDate;
	}

	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String formateDate = sdf.format(date);
		return formateDate.substring(9, 17);
	}

	public static String getCurrentDateTime() {
		return getCurrentDateTime("dd/MM/yyyy HH:mm:ss");
	}

	public static String getCurrentDateTime(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}

	public static long getDimdd(Date oneDate, Date anotherDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date _oneDate = oneDate;
		Date _anotherDate = anotherDate;
		try {
			_oneDate = sdf.parse(sdf.format(oneDate));
			_anotherDate = sdf.parse(sdf.format(anotherDate));
		} catch (ParseException localParseException) {
		}
		long dimdd = (_anotherDate.getTime() - _oneDate.getTime()) / 86400000L;
		return dimdd;
	}

	public static Date getDate(Date oneDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date _oneDate = oneDate;
		try {
			_oneDate = sdf.parse(sdf.format(oneDate));
		} catch (ParseException localParseException) {
		}
		return _oneDate;
	}
	
	public static String formatDate(Date date, String format) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(date);
	}

	public static void main(String[] args) {
		try {
			Date nowTime = new Date(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date toTime = sdf.parse("2011-07-31");

			long days = getDimdd(nowTime, toTime);

			System.out.println(getTimeForESBRequestId());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	static SimpleDateFormat datetimeFormat = new SimpleDateFormat("DDDHHmmssSSS");
	public static String getKeyFlowTime() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(timestamp);
		return datetimeFormat.format(calendar.getTime());
	}
	
	public static boolean checkRequestTime(String requestTimePartner) {
		try {
			Date timePartner = yyMMddHHmmSS.parse(requestTimePartner);
			if (Math.abs(TimestampFactory.singleton().getTimestamp().getTime() - timePartner.getTime()) > 3000000) {
				return false;
			}
		} catch (Exception e) {
			System.err.println("Loi parse requestTimePartner");
			return false;
		}

		return true;
	}

	public static Date truncateTime(Date dateObject) {
		Calendar cal = Calendar.getInstance(); // locale-specific
		cal.setTime(dateObject);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
}
