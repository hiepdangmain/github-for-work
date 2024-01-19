package com.msb.ibs.common.crypto;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author quangtd5
 * <p>
 * Nov 9, 2021
 */
public class KeyGenerator {
    public static KeyGenerator singleton = new KeyGenerator();
    private final int RETRY_MAX_TIMES = 10;
    private final String PADDING_ZEROS = "000";
    private final int SUB_SEQUENCE_SIZE = "000".length();
    private long preTimestampLong = 0L;
    private long subSequence = 0L;

    public String getKey() {
        String result = null;
        for (int i = 0; i < 10; i++) {
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

    private String populateSubSequence(long subSeq) {
        String seqStr = "000" + Long.toString(this.subSequence);
        seqStr = seqStr.substring(seqStr.length() - this.SUB_SEQUENCE_SIZE);

        return seqStr;
    }

    private String populateTimestampKey() {
        StringBuffer resultBuf = new StringBuffer();

        Long timestampKey = getTimestampLong();
        long curTimestampLong = timestampKey.longValue();
        synchronized (KeyGenerator.class) {
            setPreTimestampLong(curTimestampLong);

            long subSeq = getSubSequence();
            subSeq += 1L;
            setSubSequence(subSeq);

            resultBuf.append(curTimestampLong).append(populateSubSequence(subSeq));
        }
        return resultBuf.toString();
    }

    private synchronized long getPreTimestampLong() {
        return this.preTimestampLong;
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


        SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(timestamp);
        long result = Long.parseLong(datetimeFormat.format(calendar.getTime()));
        return Long.valueOf(result);
    }
}



