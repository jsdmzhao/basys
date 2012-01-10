<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.sysadmin.Constants" %>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>

<%			
		String version_aisinoCA = "";
		Globalpar glo_aisinoCA = new Globalpar();
		Globalpar temp_aisinoCA = null;
		List globList_aisinoCA = null;
		
		glo_aisinoCA.setGlobalparcode("aisinoCA-bbh"); //base64-bbh 版本号
		globList_aisinoCA = CacheManager.getCacheGlobalpar(glo_aisinoCA);
		if(globList_aisinoCA!=null&&globList_aisinoCA.size()>0){
			temp_aisinoCA = (Globalpar)globList_aisinoCA.get(0);
			version_aisinoCA = temp_aisinoCA.getGlobalparvalue();	
		}
%>

<html>
  <body>
    <div style ="display :none ">
    <object ID="CACertification" CLASSID="CLSID:27D77CF2-727A-4CDE-A019-B992E6488A22" CODEBASE="<%=request.getContextPath() %>/active/aisinoCA.CAB#version=<%=version_aisinoCA %>"></object>
    &nbsp;</div>
  </body>
</html>
