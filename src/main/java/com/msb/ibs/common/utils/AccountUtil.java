package com.msb.ibs.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
public class AccountUtil {
	public AccountUtil() {
	}

	public static String convertAcctType(String oldType) {
		if (oldType == null || "".equals(oldType))
			return "";
		if ("CA".equalsIgnoreCase(oldType))
			return "D";
		if ("SA".equalsIgnoreCase(oldType))
			return "S";
		if ("FD".equalsIgnoreCase(oldType))
			return "T";
		else
			return "";
	}

	public static boolean validateAccountFormat(String acct) {
		String reg = "^[a-zA-Z0-9]{1,15}$";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(acct);
		if (m.matches()) {
			return true;
		}
		return false;
	}

	public static boolean checkMsbAccount(String rolloutAccount) {
		rolloutAccount = rolloutAccount == null ? "" : rolloutAccount.trim();
		if (rolloutAccount == null || "".equals(rolloutAccount) || rolloutAccount.length() > 20
				|| !rolloutAccount.matches("[0-9]+")) {
			return false;
		}
		return true;
	}

	public static boolean validateInterbankAccountFormat(String acct) {
		String reg = "^[a-zA-Z0-9]{1,25}$";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(acct);
		if (m.matches()) {
			return true;
		}
		return false;
	}
	
}
