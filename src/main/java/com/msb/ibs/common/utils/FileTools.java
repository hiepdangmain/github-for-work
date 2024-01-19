package com.msb.ibs.common.utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO: Class description here.
 *
 * @author QuangBD3
 */
public class FileTools {
	/**
	 * Get sub folder from date by format
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String getSubFolderByDate(Date date, String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		
		return df.format(date);
	}

	/**
	 * Get extend of file
	 * @param fileName
	 * @return
	 */
	public static String getExtendOfFile(String fileName) {

		try {
			int pos = fileName.lastIndexOf(".");
			if (pos == -1) 
				return null;
			return fileName.substring(pos);
		} catch (Exception ex) {
			return null;
		}
	}
	
	/**
	 * Tao thu muc neu chua ton tai
	 * @param dir
	 */
	public static void mkDir(String dir) {
		File f = new File(dir);
		try{
			if(f.exists() == false){
				boolean success = f.mkdirs();
				if (success) {
					System.out.println("Directories: " + dir + "created");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String getFileName(String fileName) {
		try {
			int pos = fileName.lastIndexOf(".");
			
			return fileName.substring(0, pos);
		} catch (Exception ex) {
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
			
			return df.format(new Date());
		}
	}
	
	public static void main(String arg[]) {
		System.out.println(getSubFolderByDate(new Date(), "yyyy/MM/"));
		
		System.out.println(getExtendOfFile("tailieu.txt.doc"));
		
		System.out.println(getFileName("tai  lieu 2012txtdoc"));
	}
	
	public static boolean isExistsFile(String filePath) {
		File f = new File(filePath);
		return f.exists();
	}
}
