package com.msb.ibs.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class SHAPassword {

    public static String getSha512(String originalString) {
        return DigestUtils.sha512Hex(originalString);
    }

}
