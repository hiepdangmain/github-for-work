package com.msb.ibs.common.crypto;

import org.apache.commons.codec.digest.DigestUtils;

public class SHAUtil {

    public static String sha256(String originalString) {
        return DigestUtils.sha256Hex(originalString);
    }

    public static String sha512(String originalString) {
        return DigestUtils.sha512Hex(originalString);
    }

    public static void main(String[] args) {
        System.out.println(sha256("111111"));
        System.out.println(sha512("111111"));
    }
}
