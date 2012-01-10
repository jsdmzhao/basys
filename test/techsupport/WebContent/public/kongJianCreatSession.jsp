<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%
	String ret = "";
	String typecache = (String)session.getAttribute("typeCache");
	
    String type=request.getParameter("type");
    String id=request.getParameter("id");
    String pwd=request.getParameter("pwd");
	if(typecache==null||(typecache!=null&&!type.equals(typecache))){
		session.setAttribute("redirectFlag",null);
		response.sendRedirect(
		"../kjdy/creatKongJianSession.action?type="+type+"&id="+id+"&pwd="+pwd
		);
		session.setAttribute("typeCache",type);
	}
	if(session.getAttribute("ret")!=null){
		ret = (String)session.getAttribute("ret");
	}
%>
<HTML>
<HEAD>
</HEAD>
<body>
<input type="hidden" id="ret" name="ret" value="<%=ret %>">
</body>
</html>