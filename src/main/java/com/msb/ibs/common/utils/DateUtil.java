package com.msb.ibs.common.utils;

import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3 
 */
public class DateUtil {
	private static long HOUR_IN_MS = 60 * 60 * 1000;
	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
	public static final String FORMAT_DATE_dMMyy = "dMMyy";
	public static final String FORMAT_DATE_ddMMyy = "ddMMyy";
	public static final String FORMAT_DATE_yyyyMMdd = "yyyyMMdd";
	public static final String FORMAT_DATE_yyyyMMDD = "yyyy-MM-dd";
	public static final String FORMAT_DATE_TIME_HHmmss = "HHmmss";
	public static final String FORMAT_DATE_yyyyDDD = "yyyyDDD";
	public static final String FORMAT_DATE_ddMMyyyy = "dd/MM/yyyy";
	public static final String FORMAT_DATE_ddMMMyyyy = "dd/MMM/yyyy";
	public static final String FORMAT_DATE_ddMMyyyyHHmmss = "dd/MM/yyyy HH:mm:ss";
	public static final String FORMAT_DATE_ddMMyyyyHHmm = "dd/MM/yyyy HH:mm";
	public static final String HHmm = "HH:mm";
	public static final String FORMAT_DATE_ddMMyyHHmm = "dd/MM/yy HH:mm";
	public static final String FORMAT_DATE_ddMMHHmm = "dd/MM HH:mm";
	public static final String FORMAT_DATE_yyyyMMddTHHmmss = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String FORMAT_DATE_yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_DATE_yyyyMMDDHHmmss = "yyyyMMddHHmmss";
	public static final String FORMAT_DATE_yyyyMMDDHHmmssSSS = "yyyyMMddHHmmssSSS";
	public static final String END_TIME_TO_DAY = "23:59:59";
	public static final SimpleDateFormat tranDate6 = new SimpleDateFormat("ddMMyy");
	public static final SimpleDateFormat formatDateString = new SimpleDateFormat("yyyy-MM-dd");
	public static final String FORMAT_DATE_HHmmss = "HH:mm:ss";
	public static final String FORMAT_DATE_yyMM = "yyMM";
	public static final String FORMAT_DATE_MMyy = "MM/yyyy";
	public static final String FORMAT_DATE_MMMMddyyyy = "MMMM dd, yyyy hh:mm:ss aa";
	public static final String FORMAT_DATE_MMyyyy = "MM-yyyy";
	public static final String FORMAT_DATE_ddMMMMyy = "dd-MMMM-yy";
	/**
	 * Subtract days
	 * 
	 */
	public static int subtractDays(Date date1, Date date2) {
		GregorianCalendar gc1 = new GregorianCalendar();
		gc1.setTime(date1);
		GregorianCalendar gc2 = new GregorianCalendar();
		gc2.setTime(date2);
		int days1 = 0;
		int days2 = 0;
		int maxYear = Math.max(gc1.get(Calendar.YEAR), gc2.get(Calendar.YEAR));
		GregorianCalendar gctmp = (GregorianCalendar) gc1.clone();
		for (int f = gctmp.get(Calendar.YEAR); f < maxYear; f++) {
			days1 += gctmp.getActualMaximum(Calendar.DAY_OF_YEAR);
			gctmp.add(Calendar.YEAR, 1);
		}
		gctmp = (GregorianCalendar) gc2.clone();
		for (int f = gctmp.get(Calendar.YEAR); f < maxYear; f++) {
			days2 += gctmp.getActualMaximum(Calendar.DAY_OF_YEAR);
			gctmp.add(Calendar.YEAR, 1);
		}
		days1 += gc1.get(Calendar.DAY_OF_YEAR) - 1;
		days2 += gc2.get(Calendar.DAY_OF_YEAR) - 1;
		return (days1 - days2);
	}

	/**
	 * Get days between 2 dates
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	public static long getDaysBetween2Dates(Date fromDate, Date toDate) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(fromDate);
		c2.setTime(toDate);
		long day = (c2.getTime().getTime() - c1.getTime().getTime())
				/ (24 * 3600 * 1000);
		return day;
	}

	/**
	 * Get month between 2 dates
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getMonthSubtractDays(Date date1, Date date2) {
		int year1 = getYear(date1);
		int year2 = getYear(date2);
		int month1 = getMonth(date1);
		int month2 = getMonth(date2);
		return ((year1 - year2) * 12 + (month1 - month2));
	}

	/**
	 * Get days in month
	 * 
	 * @param date
	 * @return
	 */
	public static short getDaysInMonth(Date date) {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(date);
		return (short) c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Get days in month
	 * 
	 * @param month
	 * @param year
	 * @return
	 */
	public static int getDaysInMonth(int month, int year) {
		Date date = createDate(year, month, 1);
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * Get number in year
	 * 1 2 ...365
	 * 
	 * @param date
	 * @return
	 */
	public static int getNumberInYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return calendar.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * Get system date
	 * 
	 * @return
	 */
	public static Date getSystemDate() {
		Calendar calendar = new GregorianCalendar();
		return calendar.getTime();
	}
	
	/**
	 * Get system date
	 * 
	 * @return
	 */
	public static String getSysDateString(String partern) {
		SimpleDateFormat format = new SimpleDateFormat(partern);
		Calendar calendar = new GregorianCalendar();
		return format.format(calendar.getTime());
	}

	/**
	 * Add month
	 * 
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date addMonth(Date date, int month) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, month);
		return c.getTime();
	}

	/**
	 * Add date
	 * 
	 * @param date
	 * @param num
	 * @return
	 */
	public static Date addDate(Date date, int num) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, num);
		return c.getTime();
	}

	/**
	 * Add date
	 * 
	 * @param date
	 * @param num
	 * @return
	 */
	public static Date addHours(Date date, int num) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR_OF_DAY, num);
		return c.getTime();
	}

	public static java.sql.Date convertDateUtil2Sql(Date date) {
		return new java.sql.Date(date.getTime());
	}

	public static java.sql.Timestamp convertDateUtil2TimestampSql(Date date) {
		return new java.sql.Timestamp(date.getTime());
	}

	public static java.sql.Timestamp convertDate2TimestampSql(Date date,
			boolean isFirstTimeOfDate, boolean isLastTimeOfDate) {
		String defaultFormat = "dd/MM/yyyy";
		String dateStr = new SimpleDateFormat(defaultFormat).format(date);
		if (isFirstTimeOfDate) {
			dateStr += " 00:00:00";
		}
		if (isLastTimeOfDate) {
			dateStr += " 23:59:59";
		}
		String convertedPattern = "dd/MM/yyyy HH:mm:ss";
		Date _converted;
		try {
			_converted = new SimpleDateFormat(convertedPattern).parse(dateStr);
		} catch (ParseException e) {
			_converted = date;
		}
		return convertDateUtil2TimestampSql(_converted);
	}

	public static Short getQuarterByMonth(Short month) {
		return (short) (((month - 1) / 3) + 1);
	}

	public static int getStartMonthByQuarter(int quarter) {
		return quarter * 3 - 2;
	}

	public static java.sql.Date stringToDateSQL(String dateDMY) {
		if (CommonUtil.isEmpty(dateDMY)) {
			return null;
		}
		int posDay = dateDMY.indexOf("/");
		if (posDay < 0) {
			return null;
		}
		String strDay = dateDMY.substring(0, posDay);
		if (!CommonUtil.isDigitString(strDay)) {
			return null;
		}
		int day = Integer.parseInt(strDay);
		if (day < 1 || day > 31) {
			return null;
		}
		int posMonth = dateDMY.indexOf("/", posDay + 1);
		if (posMonth < 0) {
			return null;
		}
		String strMonth = dateDMY.substring(posDay + 1, posMonth);
		if (!CommonUtil.isDigitString(strMonth)) {
			return null;
		}
		int month = Integer.parseInt(strMonth);
		if (month < 1 || month > 12) {
			return null;
		}
		String strYear = dateDMY.substring(posMonth + 1);
		if (!CommonUtil.isDigitString(strYear)) {
			return null;
		}
		int year = Integer.parseInt(strYear);
		if (month == 2) {
			if (year % 4 == 0) {
				if (day > 29) {
					return null;
				}
			} else {
				if (day > 28) {
					return null;
				}
			}
		}
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			if (day > 30) {
				return null;
			}
		}
		return java.sql.Date.valueOf(year + "-"
				+ (month < 10 ? ("0" + month) : month) + "-"
				+ (day < 10 ? ("0" + day) : day));
	}

	public static Date stringToDate(String dateDMY) {
		if (CommonUtil.isEmpty(dateDMY)) {
			return null;
		}

		String[] array = dateDMY.split("/");
		String result = array[array.length - 1];
		if (result.length() == 2) {
			result = "20" + result;
			int index = dateDMY.lastIndexOf("/");
			String temp = dateDMY.substring(0, index + 1);
			result = temp + result;
		} else {
			result = dateDMY;
		}
		java.sql.Date date = stringToDateSQL(result);
		if (date == null) {
			return null;
		}
		Date temp = new Date(date.getTime());
		return temp;
	}

	public static boolean isDMYDate(String dateDMY) {
		Date date = stringToDateSQL(dateDMY);
		return (date != null);
	}

	public static int getCurrentYear() {
		Calendar calendar = new GregorianCalendar();
		return calendar.get(Calendar.YEAR);
	}

	public static int getYear(Date date) {
		if (date == null) {
			return 0;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		return year;
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static short getDate(Date date) {
		if (date == null) {
			return 0;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dateInt = cal.get(Calendar.DATE);
		return ((Integer) dateInt).shortValue();
	}

	public static String getStringYear(Date date) {
		String sYear = "";
		if (date == null) {
			return sYear;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		sYear = year + "";
		return sYear;
	}

	public static int getCurrentMonth() {
		Calendar calendar = new GregorianCalendar();
		return calendar.get(Calendar.MONTH) + 1;
	}

	public static int getMonth(Date date) {
		if (date == null) {
			return 0;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		return month;
	}

	public static String getStringMonth(Date date) {
		String sMonth = "";
		if (date == null) {
			return sMonth;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		if (month < 10) {
			sMonth = "0" + month;
		} else {
			sMonth = month + "";
		}
		return sMonth;
	}

	public static int getCurrentDay() {
		Calendar calendar = new GregorianCalendar();
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	public static int getDay(Date date) {
		if (date == null) {
			return 0;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		return day;
	}

	public static String getStringDay(Date date) {
		String sDay = "";
		if (date == null) {
			return sDay;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		if (day < 10) {
			sDay = "0" + day;
		} else {
			sDay = day + "";
		}
		return sDay;
	}

	public static int getCurrentHour() {
		Calendar calendar = new GregorianCalendar();
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	public static int getHour(Date date) {
		if (date == null) {
			return 0;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		return hour;
	}

	public static int getMinute(Date date) {
		if (date == null) {
			return 0;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int minute = cal.get(Calendar.MINUTE);
		return minute;
	}

	public static int getSecond(Date date) {
		if (date == null) {
			return 0;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int second = cal.get(Calendar.SECOND);
		return second;
	}

	public static Date createDate(int year, int month, int dayOfMonth, int hour) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, dayOfMonth, hour, 0, 0);
		return cal.getTime();
	}

	public static Date createDate(int year, int month, int dayOfMonth,
			int hour, int minute, int second) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, dayOfMonth, hour, minute, second);
		return cal.getTime();
	}

	public static Date createDate(int year, int month, int dayOfMonth) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, dayOfMonth);
		return cal.getTime();
	}

	public static Date createDate(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1);
		return cal.getTime();
	}

	public static Date createDate(int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, 0, 1, 0, 0, 0);
		return cal.getTime();
	}

	/**
	 * Ngay dau tien cua nam
	 * 
	 * @param year
	 * @return
	 */
	public static Date createLastDate(String year) {
		String dateDMY = "31/12/" + year;
		return stringToDate(dateDMY);
	}

	/**
	 * Ngay hien tai
	 * 
	 * @return
	 */
	public static Date getCurrentTime() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}

	public static String getDayHourMinute(Date date) {
		DateUtil.getStringMonth(date);
		DateUtil.getStringDay(date);
		DateUtil.getStringYear(date);
		String hourminute = ":" + String.valueOf(DateUtil.getHour(date));
		if (DateUtil.getHour(date) == 0)
			hourminute = "";
		String targetString = DateUtil.getStringDay(date) + "/"
				+ DateUtil.getStringMonth(date) + "/"
				+ DateUtil.getStringYear(date) + hourminute;
		return targetString;
	}

	/**
	 * Danh sach nam tinh den nam hien tai
	 * 
	 * @param startYear
	 * @return
	 */
	public static final List<Integer> createYearList(int startYear) {
		List<Integer> result = new Vector<Integer>();
		Date currentDate = new Date();
		int currentYear = DateUtil.getYear(currentDate);
		if (currentYear < startYear) {
			result.add(currentYear);
		} else {
			for (int i = startYear; i <= currentYear + 1; i++) {
				result.add(i);
			}
		}
		return result;
	}

	/**
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date addDayByMonth(Date date, short month) {
		String rets = "";

		int thang = DateUtil.getMonth(date) + month;
		int phanle = thang % 12;
		int phannguyen = thang / 12;

		rets = rets + String.valueOf(DateUtil.getDay(date));
		rets = rets + "/";
		rets = rets + String.valueOf(phanle == 0 ? 12 : phanle);
		rets = rets + "/";
		rets = rets
				+ String.valueOf(DateUtil.getYear(date)
						+ (phanle == 0 ? phannguyen - 1 : phannguyen));

		return DateUtil.stringToDate(rets);
	}

	/**
	 * ngay hom truoc
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDayBefore(Date date) {
		long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;

		Date dayBefore = new Date(date.getTime() - MILLIS_IN_A_DAY);
		return dayBefore;
	}

	/**
	 * Ngay hom sau
	 * 
	 * @param ngay
	 * @param soNgay
	 * @return
	 */
	public static Date getDayAfter(Date ngay, int soNgay) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(ngay);
		gc.add(Calendar.DAY_OF_YEAR, soNgay);
		Date dayAfter = gc.getTime();

		return dayAfter;
	}

	/**
	 * Ngay hom truoc
	 * 
	 * @param ngay
	 * @param soNgay
	 * @return
	 */
	public static Date getDayBefore(Date ngay, int soNgay) {
		GregorianCalendar gcSau = new GregorianCalendar();
		gcSau.setTime(ngay);
		gcSau.add(Calendar.DAY_OF_YEAR, -soNgay);
		Date dayBefore = gcSau.getTime();

		return dayBefore;
	}

	/**
	 * Compare date
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareDate(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		int month1 = cal1.get(Calendar.MONTH);
		int month2 = cal2.get(Calendar.MONTH);
		int day1 = cal1.get(Calendar.DAY_OF_MONTH);
		int day2 = cal2.get(Calendar.DAY_OF_MONTH);
		if (year1 > year2) {
			return 1;
		} else if (year1 < year2) {
			return -1;
		}
		if (month1 > month2) {
			return 1;
		} else if (month1 < month2) {
			return -1;
		}
		if (day1 > day2) {
			return 1;
		} else if (day1 < day2) {
			return -1;
		}
		return 0;
	}

	/**
	 * Compare month
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compare2Month(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		int y1 = cal1.get(Calendar.YEAR);
		int y2 = cal2.get(Calendar.YEAR);
		int m1 = cal1.get(Calendar.MONTH);
		int m2 = cal2.get(Calendar.MONTH);
		if (y1 != y2) {
			return y1 - y2;
		}
		return m1 - m2;
	}

	/**
	 * so ngay giua hai thoi diem
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long laySoNgayGiuaHaiThoiDiem(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		c1.set(Calendar.HOUR_OF_DAY, 0);

		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);
		c2.set(Calendar.HOUR_OF_DAY, 0);

		long ONE_HOUR = 60 * 60 * 1000L;
		// long day = ((d2.getTime() - d1.getTime() + ONE_HOUR) / (ONE_HOUR *
		// 24));
		long day = ((c2.getTimeInMillis() - c1.getTimeInMillis() + ONE_HOUR) / (ONE_HOUR * 24));
		return day < 0 ? -day : day;

	}

	/**
	 * So thang giua hai thoi diem
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int laySoThangGiuaHaiThoiDiem(Date d1, Date d2) {
		int ret = (getMonth(d2) + getYear(d2) * 12 - (getMonth(d1) + getYear(d1) * 12));
		return ret;
	}

	/**
	 * So ngay tinh den thoi diem hien tai
	 * 
	 * @param thang
	 * @param nam
	 * @param ngay
	 * @return
	 */
	public static int layDay(int thang, int nam, int ngay) {

		Date ngayGoc = DateUtil.stringToDate("1/" + String.valueOf(thang) + "/"
				+ String.valueOf(nam));

		int day = DateUtil.getDaysInMonth(ngayGoc);

		if (ngay <= day) {
			return ngay;
		} else {
			return day;
		}
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.AM_PM, Calendar.AM);
		cal.set(Calendar.HOUR, 11);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	public static Date getSameDayLastYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, -1);
		return cal.getTime();
	}

	public static void main(String args[]) {
		System.out.println(getSameDayLastYear(createDate(2012, 2, 29)));

	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH,
				cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.AM_PM, Calendar.PM);
		cal.set(Calendar.HOUR, 11);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	/**
	 * 
	 * @param quarter
	 * @param year
	 * @return
	 */
	public static Date getFirstDayOfQuarter(int quarter, int year) {
		int month = quarter * 3 - 2;
		return createDate((short) year, (short) month);
	}

	/**
	 * 
	 * @param sixMonth
	 * @param year
	 * @return
	 */
	public static Date getFirstDayOfSixMonth(int sixMonth, int year) {
		int month = sixMonth * 6 - 5;
		return createDate((short) year, (short) month);
	}

	/**
	 * 
	 * @param year
	 * @return
	 */
	public static Date getFirstDayOfYear(int year) {
		return getFirstDayOfMonth(createDate(year, 1));
	}

	/**
	 * 
	 * @param quarter
	 * @param year
	 * @return
	 */
	public static Date getLastDayOfQuarter(int quarter, int year) {
		int month = quarter * 3;
		return getLastDayOfMonth(createDate((short) year, (short) month));
	}

	/**
	 * 
	 * @param sixMonth
	 * @param year
	 * @return
	 */
	public static Date getLastDayOfSixMonth(int sixMonth, int year) {
		int month = sixMonth * 6;
		return getLastDayOfMonth(createDate((short) year, (short) month));
	}

	/**
	 * Láº¥y ngÃ y cuá»‘i cÃ¹ng cá»§a nÄƒm
	 * 
	 * @author ducln1
	 * @Time: Mar 6, 2013
	 * @param year
	 * @return
	 */
	public static Date getLastDayOfYear(int year) {
		return getLastDayOfMonth(createDate((short) year, (short) 12));
	}

	/**
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDate(Date date, String format) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(date);
	}
	public static long longDate(Date date,long defaultvalue) {
		if (date == null) {
			return defaultvalue;
		}
		return date.getTime();
	}

	public static Date getDateSubHour(Date date, int hour) {
		try {
			return new Date(date.getTime() - hour * HOUR_IN_MS);
		} catch (Exception e) {
			return null;
		}

	}

	public static Date getMondayThisWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		calendar.set(Calendar.AM_PM, Calendar.AM);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return new Date(calendar.getTimeInMillis());
	}
	
	public static Date getFridayThisWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		calendar.set(Calendar.AM_PM, Calendar.AM);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return new Date(calendar.getTimeInMillis());
	}

	public static Date getSundayThisWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		calendar.set(Calendar.AM_PM, Calendar.PM);
		calendar.set(Calendar.HOUR, 11);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return new Date(calendar.getTimeInMillis());
	}

	public static Long getTime(Date date) {
		Calendar cal = Calendar.getInstance(); // locale-specific
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}

	public static Date truncDate(Date date) {
		if (date == null)
			return null;
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	public static Date addingDate(Date date, int addDate) {
		if (date == null)
			return null;
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, addDate);
		return c.getTime();
	}

	/**
	 * Add date minute
	 * 
	 * @param date
	 * @param hour
	 * @param min
	 * @return
	 */
	public static Date addHourMinute(Date date, int hour, int min) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR_OF_DAY, hour);
		c.add(Calendar.MINUTE, min);
		return c.getTime();
	}

	/**
	 * Create Date Hourse Minute
	 * 
	 * @author khanhnn12
	 * @param date
	 * @param hour
	 * @param minute
	 * @return
	 */
	public static Date createDateOfHoursMinute(Date date, int hour, int minute) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, minute);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekDaysThisWeek(Date date) {
		String dayNames[] = new DateFormatSymbols().getWeekdays();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		String results = dayNames[c.get(Calendar.DAY_OF_WEEK)];
		return results;
	}

	public static Date getStartTimeOfDate(Date date) throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getStartTimeOfDate(String dateStr, String pattern) {
		try {
			Date date = stringToDate(dateStr, pattern);
			if (date != null) {
				return getStartTimeOfDate(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date getEndTimeOfDate(Date date) throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	public static Date getEndTimeOfDate(String dateStr, String pattern) {
		try {
			Date date = stringToDate(dateStr, pattern);
			if (date != null) {
				return getEndTimeOfDate(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Compare time
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static String compareTimeString(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return "now";
		}
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		int month1 = cal1.get(Calendar.MONTH);
		int month2 = cal2.get(Calendar.MONTH);
		int day1 = cal1.get(Calendar.DAY_OF_MONTH);
		int day2 = cal2.get(Calendar.DAY_OF_MONTH);
		int hour1 = cal1.get(Calendar.HOUR_OF_DAY);
		int hour2 = cal2.get(Calendar.HOUR_OF_DAY);
		int minute1 = cal1.get(Calendar.MINUTE);
		int minute2 = cal2.get(Calendar.MINUTE);
		if (year1 > year2) {
			return String.valueOf((year1 - year2)) + " year";
		} else if (year1 < year2) {
			return String.valueOf((year2 - year1)) + " year";
		}
		if (month1 > month2) {
			return String.valueOf((month1 - month2)) + " month";
		} else if (month1 < month2) {
			return String.valueOf((month2 - month1)) + " month";
		}
		if (day1 > day2) {
			return String.valueOf((day1 - day2)) + " day";
		} else if (day1 < day2) {
			return String.valueOf((day2 - day1)) + " day";
		}
		if (hour1 > hour2) {
			return String.valueOf((hour1 - hour2)) + " hour";
		} else if (hour1 < hour2) {
			return String.valueOf((hour2 - hour1)) + " hour";
		}
		if (minute1 > minute2) {
			return String.valueOf((minute1 - minute2)) + " minute";
		} else if (minute1 < minute2) {
			return String.valueOf((minute2 - minute1)) + " minute";
		}
		return "now";
	}

	public static int getIntDayOfWeek(String dayOfWeek) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("EEE");
			Date date = (Date) formatter.parse(dayOfWeek);
			GregorianCalendar g = new GregorianCalendar();
			g.setTime(date);
			return g.get(Calendar.DAY_OF_WEEK);
		} catch (ParseException e) {
			System.out.println("Exception :" + e);
		}
		return 0;
	}
	
	/* SONNA1 - 03/10/2017 */ 
	 public static Date getYearinNumber (int year, int num) {
	  Calendar calendar = Calendar.getInstance();
	  calendar.set(Calendar.YEAR, year);
	  calendar.set(Calendar.DAY_OF_YEAR, num);
	  return calendar.getTime();
	 }
	 
	 public int convertDateToCjDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String strDayOfYear = String.format("%1$03d", calendar.get(Calendar.DAY_OF_YEAR));
		String strYear = String.valueOf(calendar.get(Calendar.YEAR));
		return Integer.parseInt(strYear + strDayOfYear);
	}
	 
	 /**
		 * Add date
		 * 
		 * @param date
		 * @param num
		 * @return
		 */
	public static Date addMinutes(Date date, int num) {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.MINUTE, num);
			return c.getTime();
		}
	
	public static Date stringToDate(String strDate, String pattern) {

		if (strDate == null || strDate.isEmpty()) {
			return null;
		}
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			sdf.setLenient(false);
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			return null;
		}
		return date;
	}
	
	public static Date stringToDate(String strDate, SimpleDateFormat sdf) {

		if (strDate == null || strDate.isEmpty()) {
			return null;
		}
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			return null;
		}
		return date;
	}
	
	public static String stringToString(String strDate, String patternFrom, String patternTo) {
		if (strDate == null || strDate.isEmpty()) {
			return null;
		}
		try {
			SimpleDateFormat sdfFrom = new SimpleDateFormat(patternFrom);
			SimpleDateFormat sdfTo = new SimpleDateFormat(patternTo);
			Date date = sdfFrom.parse(strDate);
			return sdfTo.format(date).toString();
		} catch (ParseException e) {
			LOGGER.debug("stringToString error: " + e.getMessage());
		}
		return "";
	}
	
	public static String formatDate(Date date, SimpleDateFormat dateFormat) {
		try {
			return dateFormat.format(date).toString();
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
		}
		return "";
	}
	
	public static String getStringDate(int type, Date dateT) {
		SimpleDateFormat sdf = null;
		if (type == 1) {
			sdf = new SimpleDateFormat("yyyyMMdd");
		} else if (type == 2) {
			sdf = new SimpleDateFormat("dd-MM-yyyy");
		} else if (type == 3) {
			sdf = new SimpleDateFormat("dd/MM/yyyy");
		} else if (type == 4) {
			sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		} else if (type == 5) {
			sdf = new SimpleDateFormat("dd/MM HH:mm");
		} else if (type == 6) {
			sdf = new SimpleDateFormat("ddMMyy");
		} else if (type == 7) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		} else if (type == 8) {
			sdf = new SimpleDateFormat("M/d/yyyy h:m:s a");
		} else {
			return null;
		}
		if(dateT == null){
			dateT = new Date(System.currentTimeMillis());;
		}
		String formateDate = sdf.format(dateT);
		return formateDate;
	}
	
	public static String getCurTimeFormat(String format) {
		SimpleDateFormat sdf = null;
		sdf = new SimpleDateFormat(format);		
		Date date = new Date(System.currentTimeMillis());
		String formateDate = sdf.format(date);
		return formateDate;
	}

	public static Timestamp getMonthFirst() {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(lastDate.get(1), lastDate.get(2), 1, 0, 0, 0);
		lastDate.set(14, 0);
		return new Timestamp(lastDate.getTimeInMillis());
	}

	public static Timestamp getMonthEnd() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.add(2, 0);
		lastDate.set(5, 1);
		lastDate.roll(5, -1);
		str = sdf.format(lastDate.getTime());
		return Timestamp.valueOf((new StringBuilder(String.valueOf(str))).append(" 23:59:59.999999").toString());
	}
}
