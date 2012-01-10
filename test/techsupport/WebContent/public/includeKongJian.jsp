<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.sysadmin.Constants" %>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>

<%			
		String version_prjWebControl_kongjian = "";
		String device_urlHnOrJs_kongjian = "";
		Globalpar glo_kongjian = new Globalpar();
		Globalpar temp_kongjian = null;
		List globList_kongjian = null;
		
		glo_kongjian.setGlobalparcode("prjweb-bbh"); //prj 版本号
		globList_kongjian = CacheManager.getCacheGlobalpar(glo_kongjian);
		if(globList_kongjian!=null&&globList_kongjian.size()>0){
			temp_kongjian = (Globalpar)globList_kongjian.get(0);
			version_prjWebControl_kongjian = temp_kongjian.getGlobalparvalue();	
		}
		
		glo_kongjian.setGlobalparcode("qdqlj_bbh"); //
		globList_kongjian = CacheManager.getCacheGlobalpar(glo_kongjian);
		if(globList_kongjian!=null&&globList_kongjian.size()>0){
			temp_kongjian = (Globalpar)globList_kongjian.get(0);
			device_urlHnOrJs_kongjian = temp_kongjian.getGlobalparvalue();	
		}
%>

<html>
  <body>
    <div style ="display :none ">
		<OBJECT ID="ctlICCard" CLASSID="CLSID:BF802FFD-DDC6-45CD-BC87-50C21696497E" CODEBASE="active/prjWebControl.CAB#version=<%=version_prjWebControl_kongjian %>"> </OBJECT>
		<OBJECT ID="device" CLASSID="CLSID:030B433D-7746-41FB-8CA1-3DAD1249D865" CODEBASE="<%=device_urlHnOrJs_kongjian %>"></OBJECT>
	</div>
  </body>
</html>
