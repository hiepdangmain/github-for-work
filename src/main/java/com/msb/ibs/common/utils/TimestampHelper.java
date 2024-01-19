package com.msb.ibs.common.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
public class TimestampHelper {
	public TimestampHelper() {
	}

	public static Boolean isTimeout(Timestamp oldTimestamp, int minutes) {
		if (oldTimestamp == null)
			return Boolean.valueOf(true);
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(System.currentTimeMillis());
		now.add(12, -minutes);
		Timestamp time = new Timestamp(now.getTimeInMillis());
		boolean isTimeout = false;
		if (time.after(oldTimestamp))
			isTimeout = true;
		return Boolean.valueOf(isTimeout);
	}

	public static Boolean isTimeout(Date oldDate, int minutes) {
		if (oldDate == null)
			return Boolean.valueOf(true);
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(System.currentTimeMillis());
		now.add(12, -minutes);
		Date calDate = now.getTime();
		boolean isTimeout = false;
		if (calDate.after(oldDate))
			isTimeout = true;
		return Boolean.valueOf(isTimeout);
	}

	public static Boolean isTimeout(long oldTime, int minutes) {
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(System.currentTimeMillis());
		now.add(12, -minutes);
		long calTime = now.getTime().getTime();
		boolean isTimeout = false;
		if (calTime > oldTime)
			isTimeout = true;
		return Boolean.valueOf(isTimeout);
	}
}
