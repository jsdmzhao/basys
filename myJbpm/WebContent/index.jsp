<%@page import="org.jbpm.api.*"%>
<%@page import="org.jbpm.api.task.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>流程测试</title>
</head>
<body>
<%
	ProcessEngine processEngine=Configuration.getProcessEngine();
	RepositoryService repositoryService=processEngine.getRepositoryService();
	ExecutionService executionService=processEngine.getExecutionService();
	TaskService taskService=processEngine.getTaskService();
	
	String username=(String)session.getAttribute("username");
	
	List<ProcessDefinition> pdList=repositoryService.createProcessDefinitionQuery().list();
	List<ProcessInstance> piList=executionService.createProcessInstanceQuery().list();
	List<Task> taskList = taskService.findPersonalTasks(username);
%>
	<a href="deploy.jsp">发布新流程</a>&nbsp; [username:<%=username %>] &nbsp; <a href="login.jsp">登录</a>
	<table>
		<caption>流程定义</caption>
		<thead>
			<tr>
				<td>id</td><td>name</td><td>version</td><td></td>
			</tr>
		</thead>
		<tbody>
		<%
		for(ProcessDefinition pd:pdList){
			%>
			<tr>
				<td><%=pd.getId() %></td><td><%=pd.getName() %></td><td><%=pd.getVersion() %></td><td><a href="remove.jsp?delayid=<%=pd.getDeploymentId()  %>">删除</a>&nbsp;<a href="start.jsp?ptid=<%= pd.getId()  %>">开始</a>
			</tr>
			<%
		}
		%>
		</tbody>
	</table>
	
	<table>
		<caption>流程实例</caption>
		<thead>
			<tr>
				<td>id</td><td>activity</td><td>state</td><td></td>
			</tr>
		</thead>
		<tbody>
		<%
			for(ProcessInstance pi : piList){
				%>
			<tr>
				<td><%=pi.getId() %></td><td><%=pi.getKey() %></td><td><%=pi.getState() %></td><td><a href="">do</a></td>
			</tr>
				<%
			}
		%>
			
		</tbody>
	</table>
	
	<table>
		<caption>待办任务</caption>
		<thead>
			<tr>
				<td>id</td><td>name</td><td>activity</td><td></td>
			</tr>
		</thead>
		<tbody>
		<%
		for(Task task : taskList){
			%>
			<tr>
				<td><%=task.getId() %></td><td><%=task.getName() %></td><td><%=task.getActivityName() %></td><td><a href="<%=task.getFormResourceName()  %>?id=<%=task.getId() %>">do</a></td>
			</tr>
			<%
		}
		%>
		</tbody>
	</table>
</body>
</html>