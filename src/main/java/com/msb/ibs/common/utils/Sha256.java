package com.msb.ibs.common.utils;

import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;


public class Sha256 {
	public static String encode(String originalString) {
		return DigestUtils.sha256Hex(originalString);
//		MessageDigest digest = null;
//		try {
//			digest = MessageDigest.getInstance("SHA-256");
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		byte[] encodedhash = digest.digest(
//		  originalString.getBytes(Charset.forName("UTF-8")));
//	    StringBuffer hexString = new StringBuffer();
//	    for (int i = 0; i < encodedhash.length; i++) {
//	    String hex = Integer.toHexString(0xff & encodedhash[i]);
//	    if(hex.length() == 1) hexString.append('0');
//	        hexString.append(hex);
//	    }
//	    return hexString.toString();
	}
	public static void main(String...strings) throws NoSuchAlgorithmException {
		System.out.println(encode("LUONG FF 5555 "));;
		System.out.println(encode("LUONG FF 5555 66667     "));;
	}

}
