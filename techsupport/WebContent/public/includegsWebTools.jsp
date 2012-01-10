<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.sysadmin.Constants" %>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>

<%			
		String version_gsWebTools_gsweb = "";
		Globalpar glo_gsweb = new Globalpar();
		Globalpar temp_gsweb = null;
		List globList_gsweb = null;
		
		glo_gsweb.setGlobalparcode("gsweb-bbh"); //prj 版本号
		globList_gsweb = CacheManager.getCacheGlobalpar(glo_gsweb);
		if(globList_gsweb!=null&&globList_gsweb.size()>0){
			temp_gsweb = (Globalpar)globList_gsweb.get(0);
			version_gsWebTools_gsweb = temp_gsweb.getGlobalparvalue();	
		}
%>
<html>
  <body>
    <div style ="display :none ">
    <!-- gsWebTools控件 -->
    <OBJECT ID="DictControl" CLASSID="CLSID:730879B1-0E4B-4830-905B-E00AC692478C" CODEBASE="active/gsWebTools.CAB#version=<%=version_gsWebTools_gsweb %>"> </OBJECT>
    <OBJECT ID="DictUpdate" CLASSID="CLSID:5D7764A8-E7F2-427B-9757-3BC7FF64C1A3" CODEBASE="active/gsWebTools.CAB#version=<%=version_gsWebTools_gsweb %>"> </OBJECT>
    &nbsp;</div>
  </body>
</html>
