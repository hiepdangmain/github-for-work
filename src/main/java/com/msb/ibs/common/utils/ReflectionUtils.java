package com.msb.ibs.common.utils;

import java.lang.reflect.Field;

public class ReflectionUtils {
	
	public static String getStringFields(Object object, String fieldName) throws Exception{
		  Field field = object.getClass().getDeclaredField(fieldName);
		  field.setAccessible(true);
		  String strValue = (String) field.get (object);
		  return strValue;
	}
	
	

}
