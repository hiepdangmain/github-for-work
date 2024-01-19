package com.msb.ibs.common.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author quangtd5
 * <p>
 * Nov 9, 2021
 */
public class DigitalSignature {

    private final static String HASH_ALGORITHM = "MD5";

    private static byte[] hash(byte[] bData, byte[] key) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
        md.update(bData);
        return md.digest(key);
    }

    public static String hash(String bData) throws NoSuchAlgorithmException {
        String privateKey = "maritimebank";
        return ByteToHex(hash(bData.getBytes(), privateKey.getBytes()));
    }

    private static String ByteToHex(byte[] data) {
        if (data == null) {
            return null;
        }
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }


}
