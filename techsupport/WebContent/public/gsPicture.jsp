<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.common.QjblUtil"%>
<%
	String gsPicture_version = QjblUtil.queryQjblVal("gsPicture-bbh"); //全局参数取版本号
	String gsPicture_objid = request.getParameter("objid"); //取对象ID
	String gsPicture_objwidth = request.getParameter("objwidth"); //取对象WIDTH
	String gsPicture_objheight = request.getParameter("objheight"); //取对象HEIGHT
	gsPicture_objid = (gsPicture_objid!=null&&!"".equals(gsPicture_objid))?gsPicture_objid:"gsPictureActive"; //ID默认值
	gsPicture_objwidth = (gsPicture_objwidth!=null&&!"".equals(gsPicture_objwidth))?gsPicture_objwidth:"0"; //WIDTH默认值
	gsPicture_objheight = (gsPicture_objheight!=null&&!"".equals(gsPicture_objheight))?gsPicture_objheight:"0"; //HEIGHT默认值
%>

<html>
<body>
	<div id="active_<%=gsPicture_objid %>">
		<object id="<%=gsPicture_objid %>" style="width:<%=gsPicture_objwidth %>px; height:<%=gsPicture_objheight %>px;" 
			classid="CLSID:581021CF-4E35-4650-9806-38C102384D39" codeBase="<%=request.getContextPath() %>/active/gsPicture.CAB#version=<%=gsPicture_version %>"></object>&nbsp;
	</div>
</body>
</html>
