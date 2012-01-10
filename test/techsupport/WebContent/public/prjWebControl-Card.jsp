<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.common.QjblUtil"%>
<%
	String prjWebControlCard_version = QjblUtil.queryQjblVal("prjweb-bbh"); //全局参数取版本号
	String prjWebControlCard_objid = request.getParameter("objid"); //取对象ID
	String prjWebControlCard_objwidth = request.getParameter("objwidth"); //取对象WIDTH
	String prjWebControlCard_objheight = request.getParameter("objheight"); //取对象HEIGHT
	prjWebControlCard_objid = (prjWebControlCard_objid!=null&&!"".equals(prjWebControlCard_objid))?prjWebControlCard_objid:"ctlICCard"; //ID默认值
	prjWebControlCard_objwidth = (prjWebControlCard_objwidth!=null&&!"".equals(prjWebControlCard_objwidth))?prjWebControlCard_objwidth:"0"; //WIDTH默认值
	prjWebControlCard_objheight = (prjWebControlCard_objheight!=null&&!"".equals(prjWebControlCard_objheight))?prjWebControlCard_objheight:"0"; //HEIGHT默认值
%>

<html>
<body>
	<div style ="display:none" id="div_<%=prjWebControlCard_objid %>">
		<object id="<%=prjWebControlCard_objid %>" style="width:<%=prjWebControlCard_objwidth %>px; height:<%=prjWebControlCard_objheight %>px;" 
			classid="CLSID:BF802FFD-DDC6-45CD-BC87-50C21696497E" codeBase="<%=request.getContextPath() %>/active/prjWebControl.CAB#version=<%=prjWebControlCard_version %>"></object>&nbsp;
	</div>
</body>
</html>
