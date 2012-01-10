<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.sysadmin.Constants" %>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>

<%			
String id=request.getParameter("id");
//System.out.println("pic_____"+id);
		String version_gspicture = "";
		Globalpar glo_gspicture = new Globalpar();
		Globalpar temp_gspicture = null;
		List globList_gspicture = null;
		
		glo_gspicture.setGlobalparcode("gspicture-bbh"); //典当图片控件 版本号

		globList_gspicture = CacheManager.getCacheGlobalpar(glo_gspicture);
		if(globList_gspicture!=null&&globList_gspicture.size()>0){
			temp_gspicture = (Globalpar)globList_gspicture.get(0);
			version_gspicture = temp_gspicture.getGlobalparvalue();	
		}
%>
 
     <div id="div_<%=id %>" >
	<!-- 打印控件 -->
			<OBJECT ID="<%=id %>" codeBase=active/gsPicture.CAB#version=1,0,0,6 
classid=CLSID:581021CF-4E35-4650-9806-38C102384D39></OBJECT>
	  </div> 
 