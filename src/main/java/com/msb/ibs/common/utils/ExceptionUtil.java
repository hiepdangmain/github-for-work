package com.msb.ibs.common.utils;

public class ExceptionUtil
{

    public static String getExceptionStackTraceElement(Exception pException)
    {
        StringBuffer bf= new StringBuffer();
        bf.append(pException.getMessage());
        StackTraceElement st[] = pException.getStackTrace();
        for(int i = 0; i < st.length; i++)
        {
            StackTraceElement stackTraceElement = st[i];
            bf.append("\n");
            bf.append(stackTraceElement.toString());
        }

        return bf.toString();
    }
}