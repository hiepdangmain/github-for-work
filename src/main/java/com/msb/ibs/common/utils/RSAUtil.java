package com.msb.ibs.common.utils;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSAUtil {

//	private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCoDkA9kHkx72w6dIYPTNKr3ojMuxeaRbiS8TXttH0gunaxi/vCyJO7WIyHSS8AtFdUPd/zfPwf/bFiPFAwR7et7UDyfXxVUSlc0rYD4XB3VtU16IKItgApDK6ukQPvc1C5Em2C6ocsQT+jckxACLC1ofXnPY2G1hAnrCdA8bj1JQIDAQAB";
//	private static String privateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKgOQD2QeTHvbDp0hg9M0qveiMy7F5pFuJLxNe20fSC6drGL+8LIk7tYjIdJLwC0V1Q93/N8/B/9sWI8UDBHt63tQPJ9fFVRKVzStgPhcHdW1TXogoi2ACkMrq6RA+9zULkSbYLqhyxBP6NyTEAIsLWh9ec9jYbWECesJ0DxuPUlAgMBAAECgYEAhXfz+zEPn+IHsZEzm1knA8rUGM0KHML8qO8bJnMu4VxVwgJr67HC6oqT6SntQ4D2znfpsgZ0cq/YPi2qff2nWRdDZoPrMbp3DTAwwWGjvgwLqZOi5lCVy9gv0vcGUEq7Z0ncGVddsqPO4xkCbk+Y3OsOjnhnMPPcu5mJ1KlJWYECQQDg/fRPGwbHtFh47LkqBrHRcvLtqqKdL/lMkC87LEe6DJtWlkgEsUbBOXmS7v5BH24tLPOAnYJdfmT5PSYesDlFAkEAvzd/5MguwrQ0t638nVR+9QnwKCAHK8r+1i4Sx/fz+V1eCUKRtL1MoKP97oFs9BkkxZApQr7WEfPaB9gRYB1aYQJBAI8zE3wFx5rzvhu5D2EgQaz9bIC4SiehkRqZ6nXPCRfxTi0eGVhjPJVe73IFiu4IAyfdpF4H4iF/gOThdpGxt8ECQQCoVVVztH7lzPqz0KkYX/A8C3mt+TQW62eYaYsDG1deaUGFaWMX96XjrTq4opul8BSdD6IjLhkKSN/iE+aH9I9BAkA3HNiF9HZ7cfZac7QdbXjLnFTYn03mcnU5qSUQfpE4YuBiMl7hqhOWlFAPvgfGoyzsESOyVbbIR47q3r2j/4gk";

//	private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCuaniV/F1uCENFNtytdtIDPSRgFx1pz8bFjQkH51PzpViYb33VC6xooniXMMGBeWS7BXbvmf8JlcgjMhwJXeYj43Q8OYA9GwpyT8gzJg5sx+y0lmH75def5XxbV4pSKTTSAX/Ge35VaTd2FK7/HgePUj55PwP6h+DImXXhExDJewIDAQAB";
//	private static String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAK5qeJX8XW4IQ0U23K120gM9JGAXHWnPxsWNCQfnU/OlWJhvfdULrGiieJcwwYF5ZLsFdu+Z/wmVyCMyHAld5iPjdDw5gD0bCnJPyDMmDmzH7LSWYfvl15/lfFtXilIpNNIBf8Z7flVpN3YUrv8eB49SPnk/A/qH4MiZdeETEMl7AgMBAAECgYAIMQv0z2N79XtjVs5Kf1ghus9oi+1fuNh3Esanzl+NA+kDT8kzJlc0mtzbDPkpoY/vkLQjULI/uv8pWAMlFXnnhXz6z4APG60+2bIIKs2gvBbU6/Ucugu25hL15AlwEtc3OX4HV6Sw3E21AI0qqFbDY6tWamMCLA6MWwRUSNr8AQJBAPiGZqbKKg2hhJtcY0aUSDoJYtDOHsdg2H6ZJbOklFl+J5GTrf7SNuEHY86cQKAf0oW71b2pD//Y3r/JddUlJnsCQQCzqXFlOkP6lXbbxVC356JVCP6znB+5yl7KXyMX5Lv1XargmQWNIy2WHP/0YqdpU7dGC7J/vVgP30qyhrepGvkBAkEAsS4IkxKARrWHN8f3EwN2NsIoS9sXgGdgEWmXwmosRV02UogpvQkbjPTayBsHy+DEEwnmCVA1kt6Hd83mDu5sbwJAD6RvFQsvo/+ja5sQXhKy1YiE9IphUMHH4wLJgWkO3FwdZpSsIQ+xBmLb/iEgxlDdoiGelvSbWDZuwIBuOTD6AQJBALfQHCHia7HxxBVYeP71bxr1K4ktweM1iROjnHdnkg258vQeU0u0W6iwhBs3CxIVAAWoDMVTW6Et9+jhBRMvN9o=";

    public static PublicKey getPublicKey(String base64PublicKey){
        PublicKey publicKey = null;
        try{
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return publicKey;
    }

    public static PrivateKey getPrivateKey(String base64PrivateKey){
        PrivateKey privateKey = null;
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey.getBytes()));
        KeyFactory keyFactory = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            privateKey = keyFactory.generatePrivate(keySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return privateKey;
    }

    public static String encrypt(String data, String publicKey) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    public static String decrypt(byte[] data, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(data));
    }

    public static String decrypt(String data, String base64PrivateKey) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return decrypt(Base64.getDecoder().decode(data.getBytes()), getPrivateKey(base64PrivateKey));
    }

//    public static void main(String[] args) throws IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, BadPaddingException {
//        try {
////        	String clearText = "2280831ck1";
////        	System.out.println("Clear Text: " + clearText);
////            String encryptedString = encrypt(clearText, publicKey);
//        	String encryptedString = "czC6Of0Woc9L25GHlun0V4Hgp3U2wcgaNgu6V6bMXbWq6+ybb3nwEJkxV7BSeMNvvsu4tu+MCmYVNLTX7L/ygfZIv21/NcqeIKo2UU9Tpi7qkLn+rB1+w/oMfbLNRimZSedeVL+VpA8h1N7K26e9+TkCue7EpD5hl5GwmFQsiqI=";
//            System.out.println("encryptedString: " + encryptedString);
//            String decryptedString = RSAUtil.decrypt(encryptedString, privateKey);
//            System.out.println("decryptedString: " + decryptedString);
//        } catch (NoSuchAlgorithmException e) {
//            System.err.println(e.getMessage());
//        }
//
//    }
}
