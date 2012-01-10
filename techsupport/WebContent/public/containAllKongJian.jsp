<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.sysadmin.Constants" %>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>

<%			
		String version_prjWebControl_printkj = "";
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
    <!-- 把文件转换成base64的控件 -->
    <object CLASSID="CLSID:A77F8A44-C61C-4E9C-8061-93CAA1ABC2B1" CODEBASE="active/ImgerToBase64.CAB#version=<%=version_imagebase64_imagebase64 %>"></object>
    &nbsp;
    <OBJECT CLASSID="CLSID:6C889397-B499-48AD-9846-907304B9FD94" CODEBASE="active/prjWebControl.CAB#version=<%=version_prjWebControl_printkj %>"></OBJECT>
    <OBJECT codeBase=active/gsPicture.CAB#version=1,0,0,6 classid=CLSID:581021CF-4E35-4650-9806-38C102384D39></OBJECT>
<!--    <object style="display:none" viewastext classid="clsid:1663ED61-23EB-11D2-B92F-008048FDD814" codebase="active/smsx.cab#Version=6,3,434,26">-->
<OBJECT 
CLASSID="CLSID:9DFF9D13-922E-4EAC-BF3B-F041FE93D184" style="display:none"
CODEBASE="active/gswebprint.CAB#version=1,1,0,3"></OBJECT>
    </div>
  </body>
</html>
