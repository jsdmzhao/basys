<%@page import="org.jbpm.api.*"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%
ProcessEngine processEngine=Configuration.getProcessEngine();
RepositoryService repositoryService=processEngine.getRepositoryService();
ExecutionService executionService=processEngine.getExecutionService();
String ptid=request.getParameter("ptid");
Map map=new HashMap();
map.put("owner",session.getAttribute("username"));
executionService.startProcessInstanceById(ptid,map);
response.sendRedirect("index.jsp");
%>