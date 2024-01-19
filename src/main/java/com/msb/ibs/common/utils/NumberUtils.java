package com.msb.ibs.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.commons.lang3.StringUtils;


/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
public class NumberUtils {
	
	public static final String FORMAT_NUMBER_CURRENCY_VN = "###,###,###"; 
	
	public static Double parseDouble(final String str) {
		if (StringUtils.isNotBlank(str)) {
			try {
				return Double.parseDouble(str.trim());
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public static String formatDouble(Double number, int minFractionDigits, int maxFractionDigits, boolean isGrouping) {
		String value = "";

		if ((number != null) && (!number.isNaN()) && (!number.isInfinite())) {
			final NumberFormat nf = NumberFormat.getInstance();

			try {
				nf.setMinimumFractionDigits(minFractionDigits);
				nf.setMaximumFractionDigits(maxFractionDigits);
				nf.setGroupingUsed(isGrouping);
				value = nf.format(number);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}

		return value;
	}
	
	public static BigDecimal parseBigDecimal(String str) {
		if (StringUtils.isNotBlank(str)) {
			try {
				return BigDecimal.valueOf(Double.parseDouble(str.trim()));
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return null;
	}
	
	public static BigDecimal parseBigDecimalString(String str) {
		char kyTu = '0';
		if (StringUtils.isNotBlank(str)) {
			try {
				if(str.contains(".")) {
					String[] arrStr = str.split("\\.");
					String decimalAmount = arrStr[0];
					String decimalStr = arrStr[1];
					boolean checkStr0= true;
					boolean decimalCheck = org.apache.commons.lang3.math.NumberUtils.isNumber(decimalStr);
					if(decimalCheck=true) {
						 for (int i = 0; i < decimalStr.length(); i++) {
						        // Nếu ký tự tại vị trí thứ i bằng \\0' thì  rerutn
						        if (decimalStr.charAt(i) != kyTu) {
						        	checkStr0 = false;
						        	return new BigDecimal(str.trim());
						        	
						        }
						    }
						if(checkStr0 ==true) {
							return new BigDecimal(decimalAmount.trim());
						}
					}
				}else {
					return new  BigDecimal(str.trim());
				}
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return null;
	}
	
	public static String formatNumber(BigDecimal value, String pattern) {
		if (value != null) {
			try {
				NumberFormat formatter = new DecimalFormat(pattern);
				return formatter.format(value);
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return null;
	}
}
