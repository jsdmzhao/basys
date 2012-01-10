<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.common.QjblUtil"%>
<%
	String gsWebToolsDictUpdate_version = QjblUtil.queryQjblVal("gsweb-bbh"); //全局参数取版本号
	String gsWebToolsDictUpdate_objid = request.getParameter("objid"); //取对象ID
	String gsWebToolsDictUpdate_objwidth = request.getParameter("objwidth"); //取对象WIDTH
	String gsWebToolsDictUpdate_objheight = request.getParameter("objheight"); //取对象HEIGHT
	gsWebToolsDictUpdate_objid = (gsWebToolsDictUpdate_objid!=null&&!"".equals(gsWebToolsDictUpdate_objid))?gsWebToolsDictUpdate_objid:"DictUpdate"; //ID默认值
	gsWebToolsDictUpdate_objwidth = (gsWebToolsDictUpdate_objwidth!=null&&!"".equals(gsWebToolsDictUpdate_objwidth))?gsWebToolsDictUpdate_objwidth:"0"; //WIDTH默认值
	gsWebToolsDictUpdate_objheight = (gsWebToolsDictUpdate_objheight!=null&&!"".equals(gsWebToolsDictUpdate_objheight))?gsWebToolsDictUpdate_objheight:"0"; //HEIGHT默认值
%>

<html>
<body>
	<div style ="display:none" id="div_<%=gsWebToolsDictUpdate_objid %>">
		<object id="<%=gsWebToolsDictUpdate_objid %>" style="width:<%=gsWebToolsDictUpdate_objwidth %>px; height:<%=gsWebToolsDictUpdate_objheight %>px;" 
			classid="CLSID:5D7764A8-E7F2-427B-9757-3BC7FF64C1A3" codeBase="<%=request.getContextPath() %>/active/gsWebTools.CAB#version=<%=gsWebToolsDictUpdate_version %>"></object>&nbsp;
	</div>
</body>
</html>
