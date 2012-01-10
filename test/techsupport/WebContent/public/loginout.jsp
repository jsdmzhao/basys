<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants;"%>
<%
	session.removeAttribute(Constants.userKey);
	session.invalidate();
	response.sendRedirect("../login.jsp");
%>