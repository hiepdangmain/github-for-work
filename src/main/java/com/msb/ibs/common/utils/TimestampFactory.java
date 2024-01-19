package com.msb.ibs.common.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampFactory
{

    private TimestampFactory()
    {
    }

    public static TimestampFactory singleton()
    {
        return singleton;
    }

    public Timestamp getTimestamp()
    {
        return new Timestamp(System.currentTimeMillis());
    }

    public Date getTimestamp(String aDateTime)
    {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
			return fmt.parse(aDateTime);
		} catch (ParseException e) {
			e.printStackTrace();
			try{
				return getDate(aDateTime);
				
			}catch(Exception exx){
				exx.printStackTrace();
				return null;
			}
			
			
			
		}
    }
    public Date getDate(String aDateTime)
    {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        try {
			return fmt.parse(aDateTime);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
       return null;
    }

    public static void main(String args[])
        throws Exception
    {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println((new TimestampFactory()).getTimestamp("06/06/2011"));
    }

    private static TimestampFactory singleton = new TimestampFactory();

}