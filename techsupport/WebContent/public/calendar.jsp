<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires",0);
%>
<%!
/*
返回与当前日期相差几天的日期；
*/
String RespDateByDay(int iDays){
	if (iDays==0)
		iDays=-1;
	if (iDays==1)
		iDays=0;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Calendar dCurrDate = Calendar.getInstance();
  dCurrDate.add(Calendar.DATE,iDays);
  String sDate = formatter.format(dCurrDate.getTime());
  return sDate;
}

/*
返回与当前日期相差几月的日期；
*/
String RespDateByMonth(int iMonths){
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Calendar dCurrDate = Calendar.getInstance();
  dCurrDate.add(Calendar.MONTH,iMonths);
  String sDate = formatter.format(dCurrDate.getTime());
  return sDate;
}

/*
返回与当前日期相差几年的日期；
*/
String RespDateByYear(int iYears){
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Calendar dCurrDate = Calendar.getInstance();
  dCurrDate.add(Calendar.YEAR,iYears);
  String sDate = formatter.format(dCurrDate.getTime());
  return sDate;
}

/*
返回当前日期当前月的第一天；
*/
String RespDateByOne(){
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Calendar dCurrDate = Calendar.getInstance();
  String sDate = formatter.format(dCurrDate.getTime());
  String sNow_y=sDate.substring(0,4);
  String sNow_m=sDate.substring(5,7);
  sDate=sNow_y+"-"+sNow_m+"-01";
  return sDate;
}

/*
返回当前日期当前年的第一天；
*/
String RespYearByOne(){
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Calendar dCurrDate = Calendar.getInstance();
  String sDate = formatter.format(dCurrDate.getTime());
  String sNow_y=sDate.substring(0,4);
  String sNow_m=sDate.substring(5,7);
  sDate=sNow_y+"-"+"01"+"-01";
  return sDate;
}


/*
返回当前年第一天相差几年的第一天；
*/
String RespYearByYear(int iYears){
	String sDate = RespDateByYear(iYears);
	String sNow_y=sDate.substring(0,4);
  String sNow_m=sDate.substring(5,7);
  sDate=sNow_y+"-"+"01"+"-01";
  return sDate;
}



/*
返回当前日期相差几月的第一天；
*/
String RespDateByMonthOne(int iMonths){
	
  String sDate = RespDateByMonth(iMonths);
  String sNow_y=sDate.substring(0,4);
  String sNow_m=sDate.substring(5,7);
  sDate=sNow_y+"-"+sNow_m+"-01";
  return sDate;
}
/*
返回当前月；
*/
String RespDateByMonthNoDay(){
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Calendar dCurrDate = Calendar.getInstance();
  String sDate = formatter.format(dCurrDate.getTime());
  String sNow_y=sDate.substring(0,4);
  String sNow_m=sDate.substring(5,7);
  sDate=sNow_y+"-"+sNow_m;
  return sDate;
}
/*
返回当前日期上月的最后一天；
*/
String RespDateByLast(){
	String sLastDate=RespDateByMonthOne(-1);
	String sNow_y=sLastDate.substring(0,4);
  String sNow_m=sLastDate.substring(5,7);
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Calendar dCurrDate = Calendar.getInstance();
	dCurrDate.set(Integer.parseInt(sNow_y),Integer.parseInt(sNow_m),1);
  dCurrDate.add(dCurrDate.DATE,-1);
  String sDate = formatter.format(dCurrDate.getTime());
  return sDate;
}

/*
取得服务器日期时间
*/
String getDateByDayTime(){
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Calendar dCurrDate = Calendar.getInstance();
  String sDate = formatter.format(dCurrDate.getTime());
  return sDate;
}
%>