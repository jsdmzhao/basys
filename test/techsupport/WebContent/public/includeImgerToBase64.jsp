<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.sysadmin.Constants" %>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>

<%			
		String version_imagebase64_imagebase64 = "";
		Globalpar glo_imagebase64 = new Globalpar();
		Globalpar temp_imagebase64 = null;
		List globList_imagebase64 = null;
		
		glo_imagebase64.setGlobalparcode("base64-bbh"); //base64-bbh 版本号
		globList_imagebase64 = CacheManager.getCacheGlobalpar(glo_imagebase64);
		if(globList_imagebase64!=null&&globList_imagebase64.size()>0){
			temp_imagebase64 = (Globalpar)globList_imagebase64.get(0);
			version_imagebase64_imagebase64 = temp_imagebase64.getGlobalparvalue();	
		}
%>

<html>
  <body>
    <div style ="display :none ">
    <!-- 把文件转换成base64的控件 -->
    <object ID="ImgerToBase1"  CLASSID="CLSID:A77F8A44-C61C-4E9C-8061-93CAA1ABC2B1" CODEBASE="active/ImgerToBase64.CAB#version=<%=version_imagebase64_imagebase64 %>"></object>
    &nbsp;</div>
  </body>
</html>
