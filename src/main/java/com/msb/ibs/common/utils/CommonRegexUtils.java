/**
 * TODO
 *
 * @author binhnt26
 * @since Sep 22, 2021
 */
package com.msb.ibs.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author binhnt26
 *
 */
public class CommonRegexUtils {

	private static final String IMAGE_PATTERN = "[^\\\\s]+(.*?)\\\\.(jpg|jpeg|png|gif|JPG|JPEG|PNG|GIF)$";
	private static final String VIDEO_PATTERN = "[^\\\\s]+(.*?)\\\\.(mp4|avi|mov|flv|wmv|MP4|AVI|MOV|FLV|WMV)$";

	/**
	 * Validate image with regular expression
	 * 
	 * @param image image for validation
	 * @return true valid image, false invalid image
	 */
	public boolean validImage(final String image) {
		Pattern pattern = Pattern.compile(IMAGE_PATTERN);

		if (CommonStringUtils.isNullOrEmpty(image)) {
			return false;
		}

		Matcher matcher = pattern.matcher(image);
		return matcher.matches();
	}

	/**
	 * Validate video with regular expression
	 * 
	 * @param video video for validation
	 * @return true valid video, false invalid video
	 */
	public boolean validVideo(final String video) {
		Pattern pattern = Pattern.compile(VIDEO_PATTERN);

		if (CommonStringUtils.isNullOrEmpty(video)) {
			return false;
		}

		Matcher matcher = pattern.matcher(video);
		return matcher.matches();
	}

}
