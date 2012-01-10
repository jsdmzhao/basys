<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.common.QjblUtil"%>
<%
	String CWCAClient_version = QjblUtil.queryQjblVal("CWCA-bbh"); //全局参数取版本号
	String CWCAClient_objid = request.getParameter("objid"); //取对象ID
	String CWCAClient_objwidth = request.getParameter("objwidth"); //取对象WIDTH
	String CWCAClient_objheight = request.getParameter("objheight"); //取对象HEIGHT
	CWCAClient_objid = (CWCAClient_objid!=null&&!"".equals(CWCAClient_objid))?CWCAClient_objid:"CAGetNr"; //ID默认值
	CWCAClient_objwidth = (CWCAClient_objwidth!=null&&!"".equals(CWCAClient_objwidth))?CWCAClient_objwidth:"0"; //WIDTH默认值
	CWCAClient_objheight = (CWCAClient_objheight!=null&&!"".equals(CWCAClient_objheight))?CWCAClient_objheight:"0"; //HEIGHT默认值
%>

<html>
<body>
	<div style ="display:none" id="div_<%=CWCAClient_objid %>">
		<object id="<%=CWCAClient_objid %>" style="width:<%=CWCAClient_objwidth %>px; height:<%=CWCAClient_objheight %>px;" 
			classid="clsid:B3C506E8-214D-4756-9625-1F2D75C25A0C" codeBase="<%=request.getContextPath() %>/active/CWCAClient.cab#version=<%=CWCAClient_version %>"></object>&nbsp;
	</div>
</body>
</html>
