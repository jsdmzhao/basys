<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.common.QjblUtil"%>
<%
	String gsWebToolsIDCard_version = QjblUtil.queryQjblVal("toolsIDCard-bbh"); //全局参数取版本号
	String gsWebToolsIDCard_objid = request.getParameter("objid"); //取对象ID
	String gsWebToolsIDCard_objwidth = request.getParameter("objwidth"); //取对象WIDTH
	String gsWebToolsIDCard_objheight = request.getParameter("objheight"); //取对象HEIGHT
	gsWebToolsIDCard_objid = (gsWebToolsIDCard_objid!=null&&!"".equals(gsWebToolsIDCard_objid))?gsWebToolsIDCard_objid:"toolsIDCard"; //ID默认值
	gsWebToolsIDCard_objwidth = (gsWebToolsIDCard_objwidth!=null&&!"".equals(gsWebToolsIDCard_objwidth))?gsWebToolsIDCard_objwidth:"0"; //WIDTH默认值
	gsWebToolsIDCard_objheight = (gsWebToolsIDCard_objheight!=null&&!"".equals(gsWebToolsIDCard_objheight))?gsWebToolsIDCard_objheight:"0"; //HEIGHT默认值
%>

<html>
<body>
	<div style ="display:none" id="div_<%=gsWebToolsIDCard_objid %>">
		<object id="<%=gsWebToolsIDCard_objid %>" style="width:<%=gsWebToolsIDCard_objwidth %>px; height:<%=gsWebToolsIDCard_objheight %>px;" 
			classid="CLSID:951CEDB2-BA15-4CC8-B69B-3FDD79FCA3FE" codeBase="<%=request.getContextPath() %>/active/gsWebTools.CAB#version=<%=gsWebToolsIDCard_version %>"></object>&nbsp;
	</div>
</body>
</html>
