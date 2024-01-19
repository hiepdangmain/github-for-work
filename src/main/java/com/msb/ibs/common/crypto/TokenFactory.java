package com.msb.ibs.common.crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author quangtd5
 * <p>
 * Nov 9, 2021
 */
public class TokenFactory {
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();

        for (byte b : bytes) {
            formatter.format("%02x", b);
        }

        return formatter.toString();
    }

    public static String encrypt(String data)
            throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec signingKey = new SecretKeySpec("104152c5bfdca07bc633eebd46199f0255c9f49d".getBytes(), HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(signingKey);
        return toHexString(mac.doFinal(data.getBytes()));
    }

    public static String getUserIdFromToken(String tokenNo) {
        String userId;
        try {
            String code = tokenNo.substring(40);
            if (!tokenNo.startsWith(encrypt(code))) {
                return null;
            }
            long exp = Long.parseLong(code.substring(0, 13));
            if (exp < System.currentTimeMillis()) {
                return null;
            }
            userId = code.substring(13);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
//
        return userId;
    }

    public static void main(String[] args) {
        try {
            System.out.println(encrypt("5454545"));
        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SignatureException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String genTokenLogin() {
        UUID one = UUID.randomUUID();
        return one.toString();
    }

    public static String genToken() {
        UUID one = UUID.randomUUID();
        return one.toString();
    }

}