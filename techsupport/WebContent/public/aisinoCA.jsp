<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.common.QjblUtil"%>
<%
	String aisinoCA_version = QjblUtil.queryQjblVal("aisinoCA-bbh"); //全局参数取版本号
	String aisinoCA_objid = request.getParameter("objid"); //取对象ID
	String aisinoCA_objwidth = request.getParameter("objwidth"); //取对象WIDTH
	String aisinoCA_objheight = request.getParameter("objheight"); //取对象HEIGHT
	aisinoCA_objid = (aisinoCA_objid!=null&&!"".equals(aisinoCA_objid))?aisinoCA_objid:"CACertification"; //ID默认值
	aisinoCA_objwidth = (aisinoCA_objwidth!=null&&!"".equals(aisinoCA_objwidth))?aisinoCA_objwidth:"0"; //WIDTH默认值
	aisinoCA_objheight = (aisinoCA_objheight!=null&&!"".equals(aisinoCA_objheight))?aisinoCA_objheight:"0"; //HEIGHT默认值
%>

<html>
<body>
	<div style ="display:none" id="div_<%=aisinoCA_objid %>">
		<object id="<%=aisinoCA_objid %>" style="width:<%=aisinoCA_objwidth %>px; height:<%=aisinoCA_objheight %>px;" 
			classid="CLSID:27D77CF2-727A-4CDE-A019-B992E6488A22" codeBase="<%=request.getContextPath() %>/active/aisinoCA.CAB#version=<%=aisinoCA_version %>"></object>&nbsp;
	</div>
</body>
</html>
