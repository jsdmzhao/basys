<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.sysadmin.Constants" %>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>

<%			
		String version_prjWebControl_imagekj = "";
		Globalpar glo_imagekj = new Globalpar();
		Globalpar temp_imagekj = null;
		List globList_imagekj = null;
		
		glo_imagekj.setGlobalparcode("prjweb-bbh"); //prj 版本号
		globList_imagekj = CacheManager.getCacheGlobalpar(glo_imagekj);
		if(globList_imagekj!=null&&globList_imagekj.size()>0){
			temp_imagekj = (Globalpar)globList_imagekj.get(0);
			version_prjWebControl_imagekj = temp_imagekj.getGlobalparvalue();	
		}
		
%>
<html>
  <body>
     <!-- 采像控件 -->
    
<OBJECT ID="ctlPicture1" CLASSID="CLSID:41061AD5-9906-408C-BEC6-E9B16805EBF9"
  	 CODEBASE="<%=request.getContextPath() %>/active/prjWebControl.CAB#version=<%=version_prjWebControl_imagekj %>">
</OBJECT>
  </body>
</html>
