<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.sysadmin.Constants" %>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>

<%			
		String version_prjWebControl_printkj = "";
		Globalpar glo_printkj = new Globalpar();
		Globalpar temp_printkj = null;
		List globList_printkj = null;
		
		glo_printkj.setGlobalparcode("prjweb-bbh"); //prj 版本号
		globList_printkj = CacheManager.getCacheGlobalpar(glo_printkj);
		if(globList_printkj!=null&&globList_printkj.size()>0){
			temp_printkj = (Globalpar)globList_printkj.get(0);
			version_prjWebControl_printkj = temp_printkj.getGlobalparvalue();	
		}
%>
<html>
  <body>
    <div style ="display :none ">
	<!-- 打印控件 -->
	<OBJECT ID="ctlPrint" CLASSID="CLSID:6C889397-B499-48AD-9846-907304B9FD94" CODEBASE="active/prjWebControl.CAB#version=<%=version_prjWebControl_printkj %>" style="width:830px; height:1191px; display: none;"></OBJECT>
	&nbsp;
	<OBJECT ID="ctlReg" CLASSID="CLSID:8B06C73F-9E34-432B-ACB1-BFFB3260FE2C" CODEBASE="active/prjWebControl.CAB#version=<%=version_prjWebControl_printkj %>" style="width:830px; height:1191px; display: none;"></OBJECT>
	</div>
  </body>
</html>
