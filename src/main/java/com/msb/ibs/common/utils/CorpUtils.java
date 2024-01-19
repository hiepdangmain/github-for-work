package com.msb.ibs.common.utils;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
public class CorpUtils {
	public static String genUserKey(int userId, String uiid) {
		if (uiid.contains("|")) {
			return userId + uiid.split("\\|")[0];
		}
		return userId + uiid;
	}
	
	public static String genUiidByCorp(String uiid, Integer corpId) {
		return uiid + "|" + corpId;
	}
	
	public static String getUiid(String uiid) {
		if (uiid.contains("|")) {
			return uiid.split("\\|")[0];
		}
		return uiid;
	}

	public static void main(String... strings) {
		System.out.println(genUserKey(43859384, "8384983-hfjsdf8934-4384934-c43849389|48943894"));
		System.out.println(getUiid("8384983-hfjsdf8934-4384934-c43849389|48943894"));
	}
}
