package com.aisino2.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	/** DATE类型转成默认时分秒为23：59：59秒的DATETIME */
	public static Date dateToDate(Date date){
		//先把date转成string
		String strDate = com.aisino2.common.DateToString.getDateEn(date)+" 23:59:59";
		
		//把string转成默认带23：59：59秒的DATETIME
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date strtodate = null;
		try {
			strtodate = formatter.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return strtodate;
	}
	
	public static Date dateToDate2(Date date){
		//先把date转成string
		String strDate = com.aisino2.common.DateToString.getDateEn(date);
		
		//把string转成默认带23：59：59秒的DATETIME
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date strtodate = null;
		try {
			strtodate = formatter.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return strtodate;
	}
	
	public static void main(String args[]){
		Date date = new Date();
		
		System.out.println(dateToDate(date));
		
	}
}
