<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="com.aisino2.techsupport.service.WorksheetService"%>
<%@page import="com.aisino2.techsupport.domain.Worksheet"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	WebApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(application); 
	WorksheetService worksheetService=(WorksheetService)context.getBean("WorksheetService");
	
	List<Worksheet> worksheetList=worksheetService.getWorksheetTaskList(null,null,null,null);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test worksheet service </title>
</head>
<body>
	<%
	if(worksheetList!=null && worksheetList.size() > 0){
		out.println("worksheetList.size() == "+worksheetList.size());
		out.println("worksheetList.get(0).getActivityName()=="+worksheetList.get(0).getActivityName());
		out.println("worksheetList.get(0).getSupportLeaderName()=="+worksheetList.get(0).getSupportLeaderName());	
	}
	
	%>
</body>
</html>