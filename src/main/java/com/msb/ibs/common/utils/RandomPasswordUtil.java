package com.msb.ibs.common.utils;

import java.util.Random;

public final class RandomPasswordUtil {

	public RandomPasswordUtil() {
	}

	public static String getRandomPwd() {
		String str = "ABCDEFGHJKMNPQRSTUVWXYZ";
		String str2 = "abcdefghjkmnopqrstuvwxyz";
		String str3 = "!@#$%&";
		String str4 = "23456789";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		// ========1 CHU HOA=======
		while (salt.length() < 1) { // length of the random string.
			int index = (int) (rnd.nextFloat() * str.length());
			salt.append(str.charAt(index));
		}
		String saltStr = salt.toString();
		// ========2 CHU THUONG=======
		rnd = new Random();
		salt = new StringBuilder();
		while (salt.length() < 2) {
			int index = (int) (rnd.nextFloat() * str2.length());
			salt.append(str2.charAt(index));
		}
		saltStr += salt.toString();
		// ======1 KY TU DAC BIET=====
		salt = new StringBuilder();
		rnd = new Random();
		while (salt.length() < 1) {
			int index = (int) (rnd.nextFloat() * str3.length());
			salt.append(str3.charAt(index));
		}
		saltStr += salt.toString();
		// =======4 CHU SO =======
		salt = new StringBuilder();
		rnd = new Random();
		while (salt.length() < 4) {
			int index = (int) (rnd.nextFloat() * str4.length());
			salt.append(str4.charAt(index));
		}
		saltStr += salt.toString();
//		if (AppConstant.IS_UAT) {
//			return "111111";
//		}
		return saltStr;

	}

	public static void main(String[] args) {
		System.out.println("==============" + getRandomPwd());
	}
}