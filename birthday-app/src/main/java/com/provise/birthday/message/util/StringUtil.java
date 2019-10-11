package com.provise.birthday.message.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StringUtil {
	
	public static String getDateFormatYearMonthDay(Date date,String datePattern){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
		return simpleDateFormat.format(date);
	}
	
	public static Date convertStringTodate(String dateStr,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			Date date = sdf.parse(dateStr);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
