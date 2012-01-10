<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.common.StringUtil"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>

<%
	User user = new User();
	//获得登录用户session
	user = (User) session.getAttribute(com.aisino2.sysadmin.Constants.userKey);
	String username = "";
	String qybm = "";
	String qymc = "";
	
	String gxdwbm = "";
	String gxdwmc = "";
	Integer departlevel = null; //管辖单位等级
	String trimEvenDepartCode = ""; //去偶数0的管辖单位编码
	String datetime=""; //服务器当前时间
	String dateNow=""; //服务器当前日期
	//得企业编码
	qybm = user.getSsdwbm();
	//得企业名称（暂时未空）
	qymc = user.getSsdwmc();
	gxdwbm=user.getDepartment().getDepartcode();
	gxdwmc=user.getDepartment().getDepartname();
	departlevel=user.getDepartment().getDepartlevel();		
	trimEvenDepartCode = StringUtil.trimEven0(gxdwbm);
		
	//的username
	username = user.getUsername();
	//======================================================
	SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();
	datetime = bartDateFormat.format(date);
	bartDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
	dateNow = bartDateFormat.format(date);
%>