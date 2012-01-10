<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.common.QjblUtil"%>
<%
	String gsWebToolsDictControl_version = QjblUtil.queryQjblVal("gsweb-bbh"); //全局参数取版本号
	String gsWebToolsDictControl_objid = request.getParameter("objid"); //取对象ID
	String gsWebToolsDictControl_objwidth = request.getParameter("objwidth"); //取对象WIDTH
	String gsWebToolsDictControl_objheight = request.getParameter("objheight"); //取对象HEIGHT
	gsWebToolsDictControl_objid = (gsWebToolsDictControl_objid!=null&&!"".equals(gsWebToolsDictControl_objid))?gsWebToolsDictControl_objid:"DictControl"; //ID默认值
	gsWebToolsDictControl_objwidth = (gsWebToolsDictControl_objwidth!=null&&!"".equals(gsWebToolsDictControl_objwidth))?gsWebToolsDictControl_objwidth:"0"; //WIDTH默认值
	gsWebToolsDictControl_objheight = (gsWebToolsDictControl_objheight!=null&&!"".equals(gsWebToolsDictControl_objheight))?gsWebToolsDictControl_objheight:"0"; //HEIGHT默认值
%>

<html>
<body>
	<div style ="display:none" id="div_<%=gsWebToolsDictControl_objid %>">
		<object id="<%=gsWebToolsDictControl_objid %>" style="width:<%=gsWebToolsDictControl_objwidth %>px; height:<%=gsWebToolsDictControl_objheight %>px;" 
			classid="CLSID:730879B1-0E4B-4830-905B-E00AC692478C" codeBase="<%=request.getContextPath() %>/active/gsWebTools.CAB#version=<%=gsWebToolsDictControl_version %>"></object>&nbsp;
	</div>
</body>
</html>
