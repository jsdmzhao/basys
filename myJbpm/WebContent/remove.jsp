<%@page import="org.jbpm.api.*"%>
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%
ProcessEngine processEngine = Configuration.getProcessEngine();
RepositoryService repositoryService=processEngine.getRepositoryService();
ExecutionService executionService=processEngine.getExecutionService();
String delayid = request.getParameter("delayid");
repositoryService.deleteDeploymentCascade(delayid);
response.sendRedirect("index.jsp");
%>