<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,org.jbpm.api.*" %>
<%@page import="org.jbpm.api.task.*" %>

<%
	String username = request.getParameter("username");
	if(username!=null && !"".equals(username))
		session.setAttribute("username",username);
	response.sendRedirect("index.jsp");
%>