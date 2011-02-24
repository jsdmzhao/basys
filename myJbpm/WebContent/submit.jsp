<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.jbpm.api.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
ProcessEngine processEngine=Configuration.getProcessEngine();
TaskService taskService=processEngine.getTaskService();
String taskId=request.getParameter("taskId");
String owner = request.getParameter("owner");
int day = Integer.parseInt(request.getParameter("day"));

Map map = new HashMap();
map.put("day",day);
taskService.completeTask(taskId,map);

response.sendRedirect("index.jsp");

%>