package com.msb.ibs.common.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
public class SequenceGenerator {
	public static SequenceGenerator singleton = new SequenceGenerator();
	private final int RETRY_MAX_TIMES = 10;
	private long preTimestampLong = 0L;
	private long subSequence = 0L;

	public String getKey() {
		String result = null;
		for (int i = 0; i < RETRY_MAX_TIMES; i++) {
			try {
				result = populateTimestampKey();
			} finally {
				if (result != null) {
					break;
				}
				try {
					Thread.sleep(5L);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
		return result;
	}

	private String populateSubSequence() {
		String seqStr = "000" + Long.toString(this.subSequence);
		seqStr = seqStr.substring(seqStr.length() - 3);
		return seqStr;
	}

	private String populateTimestampKey() {
		StringBuffer resultBuf = new StringBuffer();

		Long timestampKey = getTimestampLong();
		long curTimestampLong = timestampKey.longValue();
		synchronized (SequenceGenerator.class) {
			setPreTimestampLong(curTimestampLong);

			long subSeq = getSubSequence();
			subSeq += 1L;
			setSubSequence(subSeq);
			resultBuf.append(curTimestampLong).append(populateSubSequence());
		}
		return resultBuf.toString();
	}

	private synchronized void setPreTimestampLong(long preTimestampLong) {
		this.preTimestampLong = preTimestampLong;
	}

	private synchronized long getSubSequence() {
		return this.subSequence;
	}

	private synchronized void setSubSequence(long subSequence) {
		if ((subSequence < 0L) || (subSequence >= 999L)) {
			this.subSequence = 0L;
		} else {
			this.subSequence = subSequence;
		}
	}

	private Long getTimestampLong() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat datetimeFormat = new SimpleDateFormat("HHmmssSSSS");
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(timestamp);
		long result = Long.parseLong(datetimeFormat.format(calendar.getTime()));
		return new Long(result);
	}
}
