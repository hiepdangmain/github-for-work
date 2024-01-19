package com.msb.ibs.common.constant;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
public class AppConstants {
	public static final String tokenPrefix = "Bearer ";
	public static final String SYSTEM_OK = "200";
	public static final int HTTP_STATUS_SUCCESS = 200;

	public static final class Header {
		public static final String Accept_Language = "Accept-Language";
		public static final String Request_Id = "Request_Id";
		public static final String Channel = "Channel";
		public static final String SECRET_KEY_NAME = "Msb-Api-Key";
	}

	public static final class MessageTemplate {
		public static final String DOMESTIC_BENEFICIARY_CHECK_APPROVED = "DOMESTIC_BENEFICIARY_CHECK_APPROVED";
	}
}
