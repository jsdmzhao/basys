<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.common.QjblUtil"%>
<%
	String ImgerToBase64_version = QjblUtil.queryQjblVal("base64-bbh"); //全局参数取版本号
	String ImgerToBase64_objid = request.getParameter("objid"); //取对象ID
	String ImgerToBase64_objwidth = request.getParameter("objwidth"); //取对象WIDTH
	String ImgerToBase64_objheight = request.getParameter("objheight"); //取对象HEIGHT
	ImgerToBase64_objid = (ImgerToBase64_objid!=null&&!"".equals(ImgerToBase64_objid))?ImgerToBase64_objid:"ImgerToBase1"; //ID默认值
	ImgerToBase64_objwidth = (ImgerToBase64_objwidth!=null&&!"".equals(ImgerToBase64_objwidth))?ImgerToBase64_objwidth:"0"; //WIDTH默认值
	ImgerToBase64_objheight = (ImgerToBase64_objheight!=null&&!"".equals(ImgerToBase64_objheight))?ImgerToBase64_objheight:"0"; //HEIGHT默认值
%>

<html>
<body>
	<div style ="display:none" id="div_<%=ImgerToBase64_objid %>">
		<object id="<%=ImgerToBase64_objid %>" style="width:<%=ImgerToBase64_objwidth %>px; height:<%=ImgerToBase64_objheight %>px;" 
			classid="CLSID:A77F8A44-C61C-4E9C-8061-93CAA1ABC2B1" codeBase="<%=request.getContextPath() %>/active/ImgerToBase64.CAB#version=<%=ImgerToBase64_version %>"></object>&nbsp;
	</div>
</body>
</html>
