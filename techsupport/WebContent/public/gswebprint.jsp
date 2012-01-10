<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.common.QjblUtil"%>
<%
	String gswebprint_version = QjblUtil.queryQjblVal("gswebprint-bbh"); //全局参数取版本号
	String gswebprint_objid = request.getParameter("objid"); //取对象ID
	String gswebprint_objwidth = request.getParameter("objwidth"); //取对象WIDTH
	String gswebprint_objheight = request.getParameter("objheight"); //取对象HEIGHT
	gswebprint_objid = (gswebprint_objid!=null&&!"".equals(gswebprint_objid))?gswebprint_objid:"gswebprintActive"; //ID默认值
	gswebprint_objwidth = (gswebprint_objwidth!=null&&!"".equals(gswebprint_objwidth))?gswebprint_objwidth:"0"; //WIDTH默认值
	gswebprint_objheight = (gswebprint_objheight!=null&&!"".equals(gswebprint_objheight))?gswebprint_objheight:"0"; //HEIGHT默认值
%>

<html>
<body>
	<div style ="display:none" id="div_<%=gswebprint_objid %>">
		<object id="<%=gswebprint_objid %>" style="width:<%=gswebprint_objwidth %>px; height:<%=gswebprint_objheight %>px;" 
			classid="CLSID:9DFF9D13-922E-4EAC-BF3B-F041FE93D184" codeBase="<%=request.getContextPath() %>/active/gswebprint.CAB#version=<%=gswebprint_version %>"></object>&nbsp;
	</div>
</body>
</html>
