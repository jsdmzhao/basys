<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,org.jbpm.api.*" %>
<%@ page import="org.jbpm.api.task.*" %>
<%
	ProcessEngine processEngine=Configuration.getProcessEngine();
	RepositoryService repositoryService= processEngine.getRepositoryService();
	repositoryService.createDeployment().addResourceFromClasspath("leave.jpdl.xml").deploy();
	
	response.sendRedirect("/index.jsp");
%>