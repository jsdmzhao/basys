package com.aisino2.common;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 功能描述：UtilDate类主要是用于对日期处理
 */

public class DateUtil {
  public static String DATE_STYLE_yyyy_MM_dd = "yyyy-MM-dd";
  public static String DATE_STYLE_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
  public static String DATE_STYLE_yyyy_MM_dd_hh_mm_ss = "yyyy-MM-dd hh:mm:ss";

  //根据年月来求该年该月有多少天
  public static int getDay(Date date) {
    String datetime = getSpecialDateString(date);
    return getDay(datetime);
  }

  //根据年月来求该年该月有多少天
  public static int getDay(String date) {
    String[] time = date.split("-");
    if ("01".equals(time[1]) || "03".equals(time[1]) || "05".equals(time[1]) ||
        "07".equals(time[1]) || "08".equals(time[1]) || "10".equals(time[1]) ||
        "12".equals(time[1])) {
      return 31;
    }
    if ("04".equals(time[1]) || "06".equals(time[1]) || "09".equals(time[1]) ||
        "11".equals(time[1])) {
      return 30;
    }
    int year = Integer.parseInt(time[0]);
    if ( (year / 4 * 4 == year && year / 100 * 100 != year) ||
        year / 400 * 400 == year) {
      return 29;
    }
    else {
      return 28;
    }
  }

  //获得当前日期的星期数
  public static int getCurrentDateWeekNumber(){
	  return getCurrentDate().getDay();
  }

  //获得当前日期的星期数字符
  public static String getCurrentDateWeekString(){
	  return getSpecialDateWeekString(getCurrentDate());
  }

  //获得指定日期的星期数
  public static int getSpecialDateWeekNumber(Date date){
	  return date.getDay();
  }

  //获得指定日期的星期数字符
  public static String getSpecialDateWeekString(Date date){
	  int day=date.getDay();
	  if(day==0){
		  return "星期天";
	  }
	  if(day==1){
		  return "星期一";
	  }
	  if(day==2){
		  return "星期二";
	  }
	  if(day==3){
		  return "星期三";
	  }
	  if(day==4){
		  return "星期四";
	  }
	  if(day==5){
		  return "星期五";
	  }
	  if(day==6){
		  return "星期六";
	  }
	  return "";
  }

  //获得当前日期
  public static java.util.Date getCurrentDate() {
    return new java.util.Date();
  }

  //获得指定了年月日的日期
  public static java.util.Date getSpecialDate(int years, int months, int dates) {
    return new java.util.Date(years, months, dates);
  }

  //获得当前日期字符串
  //默认返回形式 例如"yyyy-MM-dd"
  public static String getCurrentDateString() {
    return new java.text.SimpleDateFormat(DateUtil.DATE_STYLE_yyyy_MM_dd).format(new java.util.Date());
  }

  //获得当前日期时间字符串
  //默认返回形式 例如"yyyyMMddHHmmss"
  public static String getCurrentDateTimeString() {
    return new java.text.SimpleDateFormat(DateUtil.DATE_STYLE_yyyy_MM_dd_HH_mm_ss).format(new java.util.Date()).replaceAll("-","").replaceAll(" ","").replaceAll(":","");
  }

  //获得当前年字符串
  //默认返回形式 例如"yyyy"
  public static String getCurrentYearString() {
    return getCurrentDateString().substring(0,4);
  }

  //获得当前日期字符串
  //String style ： 返回形式 例如"yyyy-MM-dd"、"yyyy-MM-dd HH:mm:ss"、"yyyy-MM-dd hh:mm:ss"
  public static String getCurrentDateString(String style) {
    return new java.text.SimpleDateFormat(style).format(new java.util.Date());
  }

  //获得指定日期字符串
  //String style ： 返回形式 例如"yyyy-MM-dd"、"yyyy-MM-dd hh:mm:ss"
  public static String getSpecialDateString(java.util.Date date, String style) {
    return new java.text.SimpleDateFormat(style).format(date);
  }

  //获得指定日期字符串
  //默认返回形式 例如"yyyy-MM-dd"
  public static String getSpecialDateString(java.util.Date date) {
    return new java.text.SimpleDateFormat(DateUtil.DATE_STYLE_yyyy_MM_dd).format(date);
  }

  //获得若干年后的日期，years为负值时表示若干年前的日期
  public static java.util.Date getNextDate(java.util.Date date, int years) {
    int int_year = date.getYear();
    int int_month = date.getMonth();
    int int_date = date.getDate();
    int int_hours = date.getHours();
    int int_minutes = date.getMinutes();
    int int_seconds = date.getSeconds();
    return new java.util.Date(int_year + years, int_month, int_date, int_hours, int_minutes, int_seconds);
  }

  //获得若干年后的日期，years为负值时表示若干年前的日期
  public static java.util.Date getNextDate(java.util.Date date, int years, int months) {
    int int_year = date.getYear();
    int int_month = date.getMonth();
    int int_date = date.getDate();
    int int_hours = date.getHours();
    int int_minutes = date.getMinutes();
    int int_seconds = date.getSeconds();
    return new java.util.Date(int_year + years, int_month + months, int_date, int_hours, int_minutes, int_seconds);
  }

  //获得若干年后的日期，years为负值时表示若干年前的日期
  public static java.util.Date getNextDate(java.util.Date date, int years, int months, int dates) {
    int int_year = date.getYear();
    int int_month = date.getMonth();
    int int_date = date.getDate();
    int int_hours = date.getHours();
    int int_minutes = date.getMinutes();
    int int_seconds = date.getSeconds();
    return new java.util.Date(int_year + years, int_month + months, int_date + dates, int_hours, int_minutes, int_seconds);
  }

  //获得若干年后的日期，years为负值时表示若干年前的日期
  public static java.util.Date getNextDate(java.util.Date date, int years, int months, int dates, int hours) {
    int int_year = date.getYear();
    int int_month = date.getMonth();
    int int_date = date.getDate();
    int int_hours = date.getHours();
    int int_minutes = date.getMinutes();
    int int_seconds = date.getSeconds();
    return new java.util.Date(int_year + years, int_month + months, int_date + dates, int_hours + hours, int_minutes, int_seconds);
  }

  //获得若干年后的日期，years为负值时表示若干年前的日期
  public static java.util.Date getNextDate(java.util.Date date, int years, int months, int dates, int hours, int minutes) {
    int int_year = date.getYear();
    int int_month = date.getMonth();
    int int_date = date.getDate();
    int int_hours = date.getHours();
    int int_minutes = date.getMinutes();
    int int_seconds = date.getSeconds();
    return new java.util.Date(int_year + years, int_month + months, int_date + dates, int_hours + hours, int_minutes + minutes, int_seconds);
  }

  //获得若干年后的日期，years为负值时表示若干年前的日期
  public static java.util.Date getNextDate(java.util.Date date, int years, int months, int dates, int hours, int minutes, int seconds) {
    int int_year = date.getYear();
    int int_month = date.getMonth();
    int int_date = date.getDate();
    int int_hours = date.getHours();
    int int_minutes = date.getMinutes();
    int int_seconds = date.getSeconds();
    return new java.util.Date(int_year + years, int_month + months, int_date + dates, int_hours + hours, int_minutes + minutes, int_seconds + seconds);
  }

  //通过日期字符串获得日期，默认采用"yyyy-MM-dd"
  public static java.util.Date getDate(String yyyymmdd) {
    java.util.Date date = null;
    try {
      return new java.text.SimpleDateFormat("yyyy-MM-dd").parse(yyyymmdd);
    }
    catch (ParseException ex) {
      return null;
    }
  }

  //通过日期字符串获得日期
  //String yyyymmdd : 如 "2006-01-09"
  //String style    : 如 "yyyy-MM-dd"
  public static java.util.Date getDate(String yyyymmdd, String style) {
    java.util.Date date = null;
    try {
      return new java.text.SimpleDateFormat(style).parse(yyyymmdd);
    }
    catch (ParseException ex) {
      return null;
    }
  }

  //通过年月日数字获得日期
  public static java.util.Date getDate(int years, int months, int dates) {
    return new java.util.Date(years, months, dates);
  }

  //说明：以下部分原属于DateTimeUtil类
  /**
   *将当前时间，转换成格式为"yyyy-MM-dd HH:mm:ss"的字符串
   * Return current datetime string.
   * @return current datetime, pattern: "yyyy-MM-dd HH:mm:ss".
   */
  public static String getDateTime() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dt = sdf.format(new Date());
    return dt;
  }

  /**
   * 按照给定的格式，返回当前事件的字符串.
   * @param pattern 制订的格式字串，格式应符合SimpleDateFormat支持的内容
   * @return current datetime
   */
  public static String getDateTime(String pattern) {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    String dt = sdf.format(new Date());
    return dt;
  }

  /**
   * 按照给定的日期，转换成格式 "yyyy-MM-dd" 的字符串.
   * @param date java.util.Date
   * @return short format datetime
   */
  public static String shortFmt(Date date) {
    String strDate = "";
    if (date != null) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      strDate = sdf.format(date);
    }
    return strDate;
  }

  /**
   * 当前时间转换成格式 "yyyy-MM-dd HH:mm:ss" 的字符串.
   * @param date java.util.Date
   * @return short format datetime
   */

  public static String shortFmt(java.sql.Timestamp date) {
    String strDate = "";
    if (date != null) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      strDate = sdf.format(date);
    }
    return strDate;
  }

  /**
   * 将传递的字符串转换成Date值.
   * @param datetime string, 格式是: "yyyy-MM-dd HH:mm"、“yyyy-MM-dd”.
   * @return java.util.Date
   */
  public static Date parse(String param) {
    Date date = null;

    if (param == null) {
      return null;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    try {
      date = sdf.parse(param);
    }
    catch (ParseException ex) {
      try {
        date = sdf2.parse(param);
      }
      catch (ParseException ex2) {

      }
    }
    finally {
      if (date != null) {
        return date;
      }
      else {
        return null;
      }
    }
  }

  /**
   *
   * 将传递的字符串转换成Timestamp值.
   * @param datetime string, 格式是: "yyyy-MM-dd HH:mm"、“yyyy-MM-dd”.
   * @return
   */
  public static Timestamp parseTimestamp(String param) {
    Date date = null;
    Timestamp time = null;

    if (param == null) {
      return null;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    try {
      date = sdf.parse(param);
    }
    catch (ParseException ex) {
      try {
        date = sdf2.parse(param);
      }
      catch (ParseException ex2) {

      }
    }
    finally {
      if (date != null) {
        return new Timestamp(date.getTime());
      }
      else {
        return null;
      }
    }
  }

  /**
   *
   * 比较两个给定的Date值的大小.
   * @param datetime string, 格式是: "yyyy-MM-dd HH:mm"、“yyyy-MM-dd”.
   * @return: 0 date1等于date2 ;1 date1>date2;-1 date1<date2         1
   *
   */
  public static int compareDatetime(Date date1, Date date2) {
    int compareResult = 0;
    if (date1 == null || date2 == null) {
      return -2;
    }
    long lngTime1 = date1.getTime();
    long lngTme2 = date2.getTime();

    if (lngTime1 == lngTme2) {
      return 0;
    }
    else if (lngTime1 > lngTme2) {
      return 1;
    }
    else {
      return -1;
    }
  }



  /**
   * 实现日期类型的年月日增减一个整数，就是对Calendar.add的封装。
   * @param dDate Date 指定的日期
   * @param strType String 年Year，月Month，日Day
   * @param iValue int 增减的数值
   * @return Date 增减日期后的Date
   */
  public static Date add(Date dDate,String strType,int iValue){
    Date result = null;
    Calendar cal = Calendar.getInstance();
    cal.setTime(dDate);

    if(strType.equals("Year")){
      cal.add(Calendar.YEAR,iValue);
    }else if(strType.equals("Month")){
      cal.add(Calendar.MONTH, iValue);
    }else if(strType.equals("Day")){
      cal.add(Calendar.DATE,iValue);
    }

    result = cal.getTime();

    return result;
  }

  /**
   * 对一个字符串进行日期验证
   */
  public  static boolean validateDate(String   date){   
      boolean   isValid   =   true;   
      if(date   !=   null){   
          SimpleDateFormat   formatter   =   new   SimpleDateFormat(DATE_STYLE_yyyy_MM_dd);  
          formatter.setLenient(false);
          try{   
              formatter.parse(date);   
          }   
          catch(ParseException   pe){   
//              System.out.println(pe.toString());   
              isValid   =   false;   
          }   
          catch(Exception   e){   
//              System.out.println(e.toString());   
              isValid   =   false;   
          }   
      }   
      else{   
          isValid   =   false;   
      }   
      return   isValid;   
  }  
}