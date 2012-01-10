<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.sysadmin.Constants" %>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>

<%			
		String version_UkeycaCA = "";
		Globalpar glo_UkeycaCA = new Globalpar();
		Globalpar temp_UkeycaCA = null;
		List globList_UkeycaCA = null;
		
		glo_UkeycaCA.setGlobalparcode("CWCA-bbh"); //base64-bbh 版本号
		globList_UkeycaCA = CacheManager.getCacheGlobalpar(glo_UkeycaCA);
		if(globList_UkeycaCA!=null&&globList_UkeycaCA.size()>0){
			temp_UkeycaCA  = (Globalpar)globList_UkeycaCA.get(0);
			version_UkeycaCA = temp_UkeycaCA.getGlobalparvalue();	
		}
%>

<html>
  <body>
    <div style ="display :none ">
    <object ID="CAGetNr" CLASSID="clsid:B3C506E8-214D-4756-9625-1F2D75C25A0C" CODEBASE="<%=request.getContextPath() %>/active/CWCAClient.cab#version=<%=version_UkeycaCA %>"></object>
    &nbsp;</div>
  </body>
</html>
