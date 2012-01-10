<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.common.QjblUtil"%>
<%
	String device_version = QjblUtil.queryQjblVal("qdqlj_bbh"); //全局参数取版本号
	String device_objid = request.getParameter("objid"); //取对象ID
	String device_objwidth = request.getParameter("objwidth"); //取对象WIDTH
	String device_objheight = request.getParameter("objheight"); //取对象HEIGHT
	device_objid = (device_objid!=null&&!"".equals(device_objid))?device_objid:"device"; //ID默认值
	device_objwidth = (device_objwidth!=null&&!"".equals(device_objwidth))?device_objwidth:"0"; //WIDTH默认值
	device_objheight = (device_objheight!=null&&!"".equals(device_objheight))?device_objheight:"0"; //HEIGHT默认值
%>

<html>
<body>
	<div style ="display:none" id="div_<%=device_objid %>">
		<object id="<%=device_objid %>" style="width:<%=device_objwidth %>px; height:<%=device_objheight %>px;" 
			classid="CLSID:030B433D-7746-41FB-8CA1-3DAD1249D865" codeBase="<%=request.getContextPath() %>/<%=device_version %>"></object>&nbsp;
	</div>
</body>
</html>
