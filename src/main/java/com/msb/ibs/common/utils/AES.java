package com.msb.ibs.common.utils;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.StringUtils;

import java.util.Base64;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
public class AES {
	private static final String ALGO = "AES";
	private static final byte[] keyValue = new byte[] { 0x2d, 0x2a, 0x2d, 0x42, 0x55, 0x49, 0x4c, 0x44, 'e', 'c', '@',
			'e', 't', '$', 'e', 'y' };

	public static String encrypt(String Data) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes());
		String encryptedValue = Base64.getEncoder().encodeToString(encVal);
		return encryptedValue.replaceAll("(\\r|\\n)", "");
	}

	public static String encrypt(String keyEncode, String Data) throws Exception {
		Key key = generateKey(keyEncode);
		Cipher c = Cipher.getInstance(ALGO);
		System.out.println(Cipher.getMaxAllowedKeyLength(ALGO));
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes());
		String encryptedValue = Base64.getEncoder().encodeToString(encVal);
		return encryptedValue.replaceAll("(\\r|\\n)", "");
	}

	public static String decrypt(String encryptedData) {
		try {
			Key key = generateKey();
			Cipher c = Cipher.getInstance(ALGO);
			c.init(Cipher.DECRYPT_MODE, key);
			byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
			byte[] decValue = c.doFinal(decordedValue);
			String decryptedValue = new String(decValue);
			return decryptedValue;
		} catch (Exception ex) {
			// ex.printStackTrace();
			return "";
		}

	}

	public static String decrypt(String keyEncode, String encryptedData) {
		try {
			Key key = generateKey(keyEncode);
			Cipher c = Cipher.getInstance(ALGO);
			c.init(Cipher.DECRYPT_MODE, key);
			byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
			byte[] decValue = c.doFinal(decordedValue);
			String decryptedValue = new String(decValue);
			return decryptedValue;
		} catch (Exception ex) {
			// ex.printStackTrace();
			return "";
		}

	}

	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}

	private static Key generateKey(String keyEncode) throws Exception {
		String key24 = StringUtils.leftPad(keyEncode, 24, " ");
		Key key = new SecretKeySpec(key24.getBytes(), ALGO);
		return key;
	}

	public static void main(String[] args) throws Exception {

		// byte[] encodedBytes = Base64.encodeBase64("20180808110221767027".getBytes());
		// System.out.println("encodedBytes " + new String(encodedBytes));
		//
		// System.out.println(encrypt("20180808110221767027"));
		/// q0xVTzTg8ruH9m2x3ctr1HBQMYt+nNGZlAbn00+ENWYMV+BIfJAEXMIIvysu1k0RDi2OYyVW8zClM/PQTKyr9g==
	}
}
