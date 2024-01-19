/**
 * TODO
 *
 * @author binhnt26
 * @since Sep 15, 2021
 */
package com.msb.ibs.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * @author binhnt26
 *
 */
public class CommonHttpUtils {

	private static final String LOCALHOST_IPV4 = "127.0.0.1";
	private static final String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";

	private static final String[] VALID_IP_HEADER_CANDIDATES = { "X-Forwarded-For", "Proxy-Client-IP",
			"WL-Proxy-Client-IP", "HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP",
			"HTTP_CLIENT_IP", "HTTP_FORWARDED_FOR", "HTTP_FORWARDED", "HTTP_VIA", "REMOTE_ADDR" };

	public static String getClientIp(HttpServletRequest request) {
		String ipAddress = "";

		for (String header : VALID_IP_HEADER_CANDIDATES) {
			if (CommonStringUtils.isNullOrEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getHeader(header);
			}
		}

		if (CommonStringUtils.isNullOrEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (LOCALHOST_IPV4.equals(ipAddress) || LOCALHOST_IPV6.equals(ipAddress)) {
				try {
					InetAddress inetAddress = InetAddress.getLocalHost();
					ipAddress = inetAddress.getHostAddress();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
			}
		}

		if (!CommonStringUtils.isNullOrEmpty(ipAddress) && ipAddress.length() > 15 && ipAddress.indexOf(",") > -1) {
			ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
		}

		return ipAddress;
	}

	public static String getClientMAC(String clientIp) {
		String str = "";
		String macAddress = "";
		try {
			Process p = Runtime.getRuntime().exec("nbtstat -A " + clientIp);
			InputStreamReader ir = new InputStreamReader(p.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			for (int i = 1; i < 100; i++) {
				str = input.readLine();
				if (str != null) {
					if (str.indexOf("MAC Address", 1) > -1) {
						macAddress = str.substring(str.indexOf("MAC Address") + 14, str.length());
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}

		return macAddress;
	}

	public static String getMacIp(String clientIp) {
		Pattern macpt = null;
		// Find OS and set command according to OS
		String OS = System.getProperty("os.name").toLowerCase();

		String[] cmd;
		if (OS.contains("win")) {
			// Windows
			macpt = Pattern.compile("[0-9a-f]+-[0-9a-f]+-[0-9a-f]+-[0-9a-f]+-[0-9a-f]+-[0-9a-f]+");
			String[] a = { "arp", "-a", clientIp };
			cmd = a;
		} else {
			// Mac OS X, Linux
			macpt = Pattern.compile("[0-9a-f]+:[0-9a-f]+:[0-9a-f]+:[0-9a-f]+:[0-9a-f]+:[0-9a-f]+");
			String[] a = { "arp", clientIp };
			cmd = a;
		}

		try {
			// Run command
			Process p = Runtime.getRuntime().exec(cmd);
			p.waitFor();
			// read output with BufferedReader
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = reader.readLine();

			// Loop trough lines
			while (line != null) {
				Matcher m = macpt.matcher(line);

				// when Matcher finds a Line then return it as result
				if (m.find()) {
					System.out.println("Found");
					System.out.println("MAC: " + m.group(0));
					return m.group(0);
				}

				line = reader.readLine();
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}

		// Return empty string if no MAC is found
		return "";
	}

}
