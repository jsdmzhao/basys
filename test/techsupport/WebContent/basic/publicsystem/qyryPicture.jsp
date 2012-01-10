<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.cache.CacheManager" %>
<%@ page import="com.aisino2.sysadmin.Constants" %>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%
	 
	String zh=request.getParameter("zh");
	String pic=request.getParameter("pic");
	String wi=request.getParameter("wi");
	String hi=request.getParameter("hi");
	String mo=request.getParameter("mo");
	String url=request.getParameter("url");
	if(mo==null){
		mo="1";
	}
	if(url==null||"".equals(url)){
		url="images/pic.gif";
	}
	//String picpage="../../public/includeGspicture.jsp?id="+pic;
	//System.out.println("pic"+pic);
	 
 %>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println(basePath);
%>
<div id="div_<%=pic %>" style="display: none;" align="center">
	<!-- 打印控件 -->
			<OBJECT id=<%=pic %> codeBase=active/gsPicture.CAB#version=1,0,0,6 
classid=CLSID:581021CF-4E35-4650-9806-38C102384D39></OBJECT>
	  </div> 
	  <div  style="left:0px;top:0px;position:absolute;border:solid 1px black;display:none;">
<OBJECT ID="IDCard_<%=pic %>" CLASSID="CLSID:951CEDB2-BA15-4CC8-B69B-3FDD79FCA3FE" CODEBASE="active/gsWebTools.CAB#version=3,3,0,1"></OBJECT>
</div>
     <table border="0"  align="center" >
            <tr >
                    <td  width="19%" align="center"  >
                    <img id="img_<%=pic %>" src="images/pic.gif" width="<%=wi %>" height="<%=hi %>" />
                    </td>
               </tr>
            </table>
            <table   width="64%" align="center"  border="0" cellspacing="0" cellpadding="4">
                  <tr>
                    <td align="center" ><a href="#" onclick="SelectDevices('<%=pic %>');return false;"  class="submitlongbutton">选择设备</a></td>
                    <td align="center" ><a href="#" onclick="DeleteImg('<%=pic %>');return false;"  class="submitlongbutton">取 消</a></td>
                  </tr>
                    <tr>
                    <td align="center" ><a href="#" onclick="DeviceCamera('<%=pic %>',<%=wi %>,<%=hi %>,<%=zh%>);addFun('<%=pic %>');return false;" class="submitlongbutton">摄 像</a></td>
                    <td align="center" ><a href="#"  onclick="SelectFile('<%=pic %>');addFun('<%=pic %>');return false;"  class="submitlongbutton">文 件</a></td>
                  </tr>
                   <%
                   	if("true".equals(zh)){
                    
                    %>
                     <tr>
                    <td align="center" ><a href="#" onclick="sanTwoOcrAddValue('<%=pic %>',<%=wi %>,<%=hi %>,<%=zh%>);addFun('<%=pic %>');return false;" class="submitlongbutton">二代证扫描</a></td>
                  
                    <td align="center" ><a href="#" onclick="DeviceOnescanOcr('<%=pic %>',<%=wi %>,<%=hi %>,<%=zh%>);addFun('<%=pic %>');return false;" class="submitlongbutton">一代证读取</a></td>
                  </tr>
                     <tr>
                    <td align="center" ><a href="#" onclick="opencard('<%=pic %>');return false;" class="submitlongbutton">二代证读取</a></td>
                  
                  </tr>
                  <%
                  	}
                  	if("false".equals(zh)){
                  	
                  	
                   %>
                    <tr>
                    <td align="center" ><a href="#" onclick="Devicepassportscanocr('<%=pic %>',<%=wi %>,<%=hi %>,<%=zh%>);addFun('<%=pic %>');return false;" class="submitlongbutton">境外证件读取</a></td>
                  </tr>
                   <%
                   	}
                    %>
              </table>