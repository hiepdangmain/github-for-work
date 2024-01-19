package com.msb.ibs.common.utils;

import java.util.UUID;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
public class TokenFactory {
	public static String genToken() {
		UUID one = UUID.randomUUID();
		return one.toString();
	}
}
