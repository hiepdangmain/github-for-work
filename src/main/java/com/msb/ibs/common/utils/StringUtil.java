package com.msb.ibs.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.type.TypeReference;

public class StringUtil {
	public static DecimalFormat decimalFomatVND = new DecimalFormat("###,###,##0");
	public static DecimalFormat decimalFomatUSD = new DecimalFormat("###,###,##0.00");
	public static DecimalFormat rateFormat = new DecimalFormat("0000000000");
	// public static String regexVietnamese = "^[a-zA-Z0-9ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ._,'\\/ -]+";
	public static String regexVietnamese = "^[ a-zA-Z0-9ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳýỵỷỹ]+";
	
	public static String regexVietnameseSuggest = "^[ a-zA-Z0-9ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳýỵỷỹ.\\-,]+";
	
	public static String regexNumberAndLetter = "[A-Za-z0-9]+";

	public static String regexNumberHaveDot = "[0-9.]+";

	public static String regexNumber = "[0-9]+";

	private static String phangNguyen;

	private static String phanThapPhan;
	
	public static String dealNull(Object object) {
		String returnstr = "";
		if (object == null)
			returnstr = "";
		else if ("null".equals(object))
			returnstr = "";
		else
			returnstr = (String) object;
		return returnstr.trim();
	}

	public static String[] splitString(String stringList, String delimiter) {
		if (stringList == null)
			return null;
		if (stringList.length() == 0)
			return null;
		StringTokenizer st = new StringTokenizer(stringList, delimiter);
		String result[] = new String[st.countTokens()];
		for (int i = 0; st.hasMoreTokens(); i++)
			result[i] = st.nextToken();

		return result;
	}

	public static String getI18NNamePath(String locale, String pNamePath) {
		return (new StringBuilder("/")).append(locale).append(pNamePath).toString();
	}

	public static String getNamePath(String pI18NNamePath) {
		String ret = "/";
		if (pI18NNamePath != null) {
			int start = pI18NNamePath.indexOf("/home");
			if (start != -1)
				ret = pI18NNamePath.substring(start);
		}
		return ret;
	}

	public static String decapitalize(String string) {
		if (string == null || string.length() == 0) {
			return string;
		}
		char c[] = string.toCharArray();
		c[0] = Character.toLowerCase(c[0]);
		return new String(c);
	}

	public static String getTranInfo(String tranSn, String beneficiaryName, String amount, Date updateTime) {
		if (StringUtils.isEmpty(tranSn) && updateTime == null && StringUtils.isEmpty(beneficiaryName)
				&& StringUtils.isEmpty(amount)) {
			return "";
		}
		return tranSn + "|" + DateUtil.longDate(updateTime, 0) + "|" + beneficiaryName + "|" + amount;
	}

	public static String convertQrString(Integer userId, BigDecimal amount, String tranId, String currencyCode) {
		String stringValue = "";
		if (userId != null) {
			String temp1 = String.valueOf(userId);
			stringValue += "00" + getLength(temp1) + temp1;
		}
		if (amount != null) {
			String temp1 = String.valueOf(amount);
			stringValue += "01" + getLength(temp1) + temp1;
		}
		if (StringUtils.isNotEmpty(tranId)) {
			String temp1 = String.valueOf(tranId);
			stringValue += "02" + getLength(temp1) + temp1;
		}
		if (StringUtils.isNotEmpty(currencyCode)) {
			String temp1 = String.valueOf(currencyCode);
			stringValue += "03" + getLength(temp1) + temp1;
		}
		return stringValue;
	}

	private static String getLength(String value) {
		if (value.length() < 10) {
			return "0" + value.length();
		} else {
			return value.length() + "";
		}
	}

	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		}
		if (str.trim().length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmptyBigDecimal(BigDecimal big) {
		if (big == null) {
			return true;
		}
		if (big.intValue() > 0) {
			return true;
		}
		return false;
	}

	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	public static boolean isEmail(String email) {
		String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		return email.matches(emailPattern);
	}

	public static boolean validateSpecialCharacters(String s) {
		try {
			String reg = "^[a-zA-Z0-9]+$";
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(s);
			if (m.matches()) {
				return true;
			}
		} catch (Exception ex) {
		}
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String messageReplace(String messageContent, Map params) {
		List list = new ArrayList();
		list.add("%userName%");
		list.add("%dateTime%");
		list.add("%accountNo%");
		list.add("%maturityDate%");
		list.add("%message%");
		list.add("%url%");
		list.add("%password%");
		list.add("%roleName%");
		String content = messageContent;
		if (content != null && params != null) {
			Set set = params.keySet();
			for (Iterator it = set.iterator(); it.hasNext();) {
				String key = (String) it.next();
				if (params.get(key) != null) {
					content = content.replaceAll(key, params.get(key).toString());
				} else {
					content = content.replaceAll(key, "");
				}
			}

			for (Iterator its = list.iterator(); its.hasNext();) {
				String key = (String) its.next();
				content = content.replaceAll(key, "");
			}

		}
		return content;
	}
	
	public static boolean isRegexMatches(String value, String format) {
		// chuyen ve khong dau r compare
		String nfdNormalizedString = Normalizer.normalize(value, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		String checkValue = pattern.matcher(nfdNormalizedString).replaceAll("");
		return checkValue.matches(format);
	}

	// validate string chan bank
	public static boolean unicodeParse(String unicode, String pattern) {
		// String pattern = "";
		return unicode.matches(pattern);
	}

	public static String getStringAmount(String a, String currency) {
		String amountInword = "";
		String moneyCurency = getMoneyCurrency(currency);
		String newString = a.replace(".", ",");
		ArrayList<String> parts = new ArrayList<>(Arrays.asList(newString.split(",")));
		long poi1 = Long.parseLong(parts.get(0));
		long poi2;
		phangNguyen = AmountVN.convertTtr(poi1, "");
		if (parts.size() > 1) {
			if(parts.get(1).length() > 1)
				poi2 = Long.parseLong(parts.get(1));
			else
				poi2 = Long.parseLong(parts.get(1).concat("0"));
			String readDecimal = getDecimal(currency, poi1, "VN");
			phanThapPhan = AmountVN.convertTtr(poi2, "XU");
			if(poi2 == 0)
				amountInword = phangNguyen + readDecimal;
			else
				amountInword = phangNguyen + readDecimal + " VÀ " + phanThapPhan;
		} else {
			amountInword = phangNguyen + moneyCurency;
		}
		return amountInword;
	}

	public static String getStringAmountEN(String a, String currency) {
//		String moneyCurency = getMoneyCurrency(currency);
		String amountInwordEN = "";
		String newString = a.replace(".", ",");
		ArrayList<String> parts = new ArrayList<>(Arrays.asList(newString.split(",")));
		long poi1 = Long.parseLong(parts.get(0));
		long poi2;
		phangNguyen = AmountEN.convert(poi1);
		if (parts.size() > 1) {
			if(parts.get(1).length() > 1)
				poi2 = Long.parseLong(parts.get(1));
			else
				poi2 = Long.parseLong(parts.get(1).concat("0"));
			String readDecimal = " "+ getDecimal(currency, poi1, "EN");
			String docSothapphan = " "+ getDocsothapphan(currency, poi2);
			phanThapPhan = AmountEN.convert(poi2);
			if(poi2 == 0)
				amountInwordEN = phangNguyen + readDecimal;
			else
				amountInwordEN = phangNguyen + readDecimal + " AND " + phanThapPhan + " "+docSothapphan;

			/*if(phanThapPhan.equalsIgnoreCase(readDecimal)) {
				amountInwordEN = phangNguyen + " "+ currency;
			} else {
				amountInwordEN = phangNguyen + " "+ currency + " and " + phanThapPhan + docSothapphan;
			}*/
		} else {
			amountInwordEN = phangNguyen + " "+ currency;
		}
		return amountInwordEN;
	}

	public static String getMoneyCurrency(String currency) {
		String currencyName = "";
		switch (currency) {
			case "USD":
				currencyName = "ĐÔ LA MỸ";
				break;
			case "VND":
				currencyName = "Việt Nam Đồng";
				break;
			case "AUD":
				currencyName = "Đô la Úc";
				break;
			case "CAD":
				currencyName = "Đô la Canada";
				break;
			case "CHF":
				currencyName = "Franc Thụy Sĩ";
				break;
			case "DKK":
				currencyName = "Krone Đan Mạch";
				break;
			case "EUR":
				currencyName = "Euro";
				break;
			case "GBP":
				currencyName = "Bảng Anh";
				break;
			case "HKD":
				currencyName = "Đô la Hồng Kông";
				break;
			case "JPY":
				currencyName = "Yên Nhật";
				break;
			case "NOK":
				currencyName = "Krone Na Uy";
				break;
			case "SEK":
				currencyName = "Krona Thụy Điển";
				break;
			case "SGD":
				currencyName = "Đô la Singapore";
				break;
			case "THB":
				currencyName = "Bạt Thái Lan";
				break;
			case "CNY":
				currencyName = "Nhân dân tệ";
				break;
			case "KRW":
				currencyName = "Won Hàn Quốc";
				break;
			case "NZD":
				currencyName = "Đô la New Zealand";
				break;
			case "TWD":
				currencyName = "Tân Đài tệ";
				break;
			case "MYR":
				currencyName = "Ringgit Malaysia";
				break;
			default:
				break;
		}
		if(StringUtils.isNotEmpty(currencyName))
			return currencyName.toUpperCase();
		else
			return currencyName;
	}

	public static String getDecimal(String currency, long amount, String language) {
		String currencyName = "";
		switch (currency) {
			case "USD":
				if("EN".equalsIgnoreCase(language)) {
					if(amount > 1)
						currencyName = "US Dollars";
					else
						currencyName = "US Dollar";
				} else {
					currencyName = "Đô la Mỹ";
				}
				break;
			case "VND":
				if("EN".equalsIgnoreCase(language)) {
					currencyName = "Vietnamese dong";
				}
				break;
			case "AUD":
				if("EN".equalsIgnoreCase(language)) {
					if(amount > 1)
						currencyName = "Australian Dollar";
					else
						currencyName = "Australian Dollars";
				} else {
					currencyName = "Đô la Úc";
				}
				break;
			case "CAD":
				if("EN".equalsIgnoreCase(language)) {
					if(amount > 1)
						currencyName = "Canadian Dollars";
					else
						currencyName = "Canadian Dollar";
				} else {
					currencyName = "Đô la Canada";
				}

				break;
			case "CHF":
				if("EN".equalsIgnoreCase(language)) {
					if(amount > 1)
						currencyName = "Swiss Francs";
					else
						currencyName = "Swiss Franc";
				} else {
					currencyName = "Franc Thụy Sĩ";
				}

				break;
			case "DKK":
				if("EN".equalsIgnoreCase(language)) {
					if(amount > 1)
						currencyName = "Danish Kroner";
					else
						currencyName = "Danish Krone";
				} else {
					currencyName = "Krone Đan Mạch";
				}

				break;
			case "EUR":
				if("EN".equalsIgnoreCase(language)) {
					if(amount > 1)
						currencyName = "Euros";
					else
						currencyName = "Euro";
				} else {
					currencyName = "Euro";
				}

				break;
			case "GBP":
				if("EN".equalsIgnoreCase(language)) {
					if(amount > 1)
						currencyName = "Pounds Sterling";
					else
						currencyName = "Pound Sterling";
				} else {
					currencyName = "Bảng Anh";
				}

				break;
			case "HKD":
				if("EN".equalsIgnoreCase(language)) {
					if(amount > 1)
						currencyName = "Hong Kong Dollars";
					else
						currencyName = "Hong Kong Dollar";
				} else {
					currencyName = "Đô la Hồng Kông";
				}

				break;
			case "JPY":
				if("EN".equalsIgnoreCase(language)) {
					if(amount > 1)
						currencyName = "Japanese Yen";
					else
						currencyName = "Japanese Yen";
				} else {
					currencyName = "Yên Nhật";
				}

				break;
			case "NOK":
				if("EN".equalsIgnoreCase(language)) {
					if(amount > 1)
						currencyName = "Norwegian Kroner";
					else
						currencyName = "Norwegian Krone";
				} else {
					currencyName = "Krone Na Uy";
				}

				break;
			case "SEK":
				if("EN".equalsIgnoreCase(language)) {
					if(amount > 1)
						currencyName = "Swedish Kronor";
					else
						currencyName = "Swedish Krona";
				} else {
					currencyName = "Krona Thụy Điển";
				}

				break;
			case "SGD":
				if("EN".equalsIgnoreCase(language)) {
					if(amount > 1)
						currencyName = "Singapore Dollars";
					else
						currencyName = "Singapore Dollar";
				} else {
					currencyName = "Đô la Singapore";
				}

				break;
			case "THB":
				if("EN".equalsIgnoreCase(language)) {
					if(amount > 1)
						currencyName = "Thai Baht";
					else
						currencyName = "Thai Baht";
				} else {
					currencyName = "Bạt Thái Lan";
				}

				break;
			case "CNY":
				if("EN".equalsIgnoreCase(language)) {
					if(amount > 1)
						currencyName = "Chinese Yuan";
					else
						currencyName = "Chinese Yuan";
				} else {
					currencyName = "Nhân dân tệ";
				}

				break;
			case "KRW":
				if("EN".equalsIgnoreCase(language)) {
					if(amount > 1)
						currencyName = "South Korean Won";
					else
						currencyName = "South Korean Won";
				} else {
					currencyName = "Won Hàn Quốc";
				}

				break;
			case "NZD":
				if("EN".equalsIgnoreCase(language)) {
					if(amount > 1)
						currencyName = "New Zealand Dollars";
					else
						currencyName = "New Zealand Dollar";
				} else {
					currencyName = "Đô la New Zealand";
				}

				break;
			case "TWD":
				if("EN".equalsIgnoreCase(language)) {
					if(amount > 1)
						currencyName = "New Taiwan dollars";
					else
						currencyName = "New Taiwan dollar";
				} else {
					currencyName = "Tân Đài tệ";
				}

				break;
			case "MYR":
				if("EN".equalsIgnoreCase(language)) {
					if(amount > 1)
						currencyName = "Malaysian Ringgits";
					else
						currencyName = "Malaysian Ringgit";
				} else {
					currencyName = "Malaysian Ringgit";
				}

				break;
			default:
				break;
		}
		if(StringUtils.isNotEmpty(currencyName))
			return currencyName.toUpperCase();
		else
			return currencyName;
	}

	public static String getDocsothapphan(String currency, long amount) {
		String currencyName = "";
		switch (currency) {
			case "USD":
				if(amount > 1)
					currencyName = "cents";
				else
					currencyName = "cent";
				break;
			case "VND":
				currencyName = "";
				break;
			case "AUD":
				if(amount > 1)
					currencyName = "cents";
				else
					currencyName = "cent";
				break;
			case "CAD":
				if(amount > 1)
					currencyName = "cents";
				else
					currencyName = "cent";
				break;
			case "CHF":
				if(amount > 1)
					currencyName = "rappen";
				else
					currencyName = "rappen";
				break;
			case "DKK":
				if(amount > 1)
					currencyName = "Øre";
				else
					currencyName = "Øre";
				break;
			case "EUR":
				if(amount > 1)
					currencyName = "Euro cents";
				else
					currencyName = "Euro cent";
				break;
			case "GBP":
				if(amount > 1)
					currencyName = "pence";
				else
					currencyName = "penny";
				break;
			case "HKD":
				if(amount > 1)
					currencyName = "cents";
				else
					currencyName = "cent";
				break;
			case "JPY":
				currencyName = "";
				break;
			case "NOK":
				if(amount > 1)
					currencyName = "Øre";
				else
					currencyName = "Øre";
				break;
			case "SEK":
				if(amount > 1)
					currencyName = "Öre";
				else
					currencyName = "Öre";
				break;
			case "SGD":
				if(amount > 1)
					currencyName = "cents";
				else
					currencyName = "cent";
				break;
			case "THB":
				if(amount > 1)
					currencyName = "satang";
				else
					currencyName = "satang";
				break;
			case "CNY":
				if(amount > 1)
					currencyName = "fen";
				else
					currencyName = "fen";
				break;
			case "KRW":
				if(amount > 1)
					currencyName = "jeon";
				else
					currencyName = "jeon";
				break;
			case "NZD":
				if(amount > 1)
					currencyName = "cents";
				else
					currencyName = "cent";
				break;
			case "TWD":
				if(amount > 1)
					currencyName = "cents";
				else
					currencyName = "cent";
				break;
			case "MYR":
				if(amount > 1)
					currencyName = "sen";
				else
					currencyName = "sen";
				break;
			default:
				break;
		}
		if(StringUtils.isNotEmpty(currencyName))
			return currencyName.toUpperCase();
		else
			return currencyName;
	}
	
	public static String stringJoin(List<String> list) {
        if (!CollectionUtils.isEmpty(list)) {
            return String.join(",", list);
        }
        return null;
    }
	
	public static List<String> getListByArray(String value) {
		return CommonUtils.stringToBean(value, new TypeReference<>() {
		});
	}
	
	public static List<String> getListByString(String value) {
		return !CommonStringUtils.isNullOrEmpty(value) ? List.of(value) : null;
	}
	
	public static void main(String[] args) {
		
		String nfdNormalizedString = Normalizer.normalize("PHẠM THỊ HẰNG", Normalizer.Form.NFD); 
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String test = pattern.matcher(nfdNormalizedString).replaceAll("");
        System.out.println(test);
        String value = "PHẠM THỊ HẰNG";
		if (StringUtil.isRegexMatches(test, regexVietnamese)) {
			System.out.println(value + " true");
		} else {
			System.out.println(value + " false");
		}
	}
}
