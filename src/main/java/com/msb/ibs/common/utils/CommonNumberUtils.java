package com.msb.ibs.common.utils;


/**
 * @author binhnt26
 *
 */
public class CommonNumberUtils extends org.apache.commons.lang3.math.NumberUtils {

	@SuppressWarnings("unused")
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
}
