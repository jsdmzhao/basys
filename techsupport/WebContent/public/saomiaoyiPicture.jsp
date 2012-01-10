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
	String file=request.getParameter("file");
	if(mo==null){
		mo="1";
	}
	if(url==null||"".equals(url)){
		url="images/pic.gif";
	}
 %>
<body>

	<table>
	<tr>
		<td  width="19%" rowspan="4" align="right" >
		<img id="img_<%=pic %>" src="images/pic.gif" width="80" height="114" />
		<div id="div_<%=pic %>" style="display: none;">
		<!-- 打印控件 -->
			<OBJECT id=<%=pic %> codeBase=active/gsPicture.CAB#version=1,0,0,6 classid=CLSID:581021CF-4E35-4650-9806-38C102384D39></OBJECT>
		</div> 
			  <div  style="left:0px;top:0px;position:absolute;border:solid 1px black;display:none;">
<OBJECT ID="IDCard_<%=pic %>" CLASSID="CLSID:951CEDB2-BA15-4CC8-B69B-3FDD79FCA3FE" CODEBASE="active/gsWebTools.CAB#version=3,3,0,1"></OBJECT>
</div>
		</td>
		<td width="13%" rowspan="4" align="center" class="detailtd" valign="bottom">
             <table width="64%" align="center"  border="0" cellspacing="0" cellpadding="4">
                 <%if("true".equals(file)){%>
                 <tr><td><a href="#" class="submitlongbutton" title="文件" onclick='open_zp();'>文件</a></td></tr>
                  <%}%>
                   <!--   <td align="center" ><a href="#"  class="submitbutton">二代证读取</a></td>-->
                   <%if("true".equals(zh)){%>
                     <tr>
                    <td align="center" ><a href="#" onclick="opencard('<%=pic %>');return false;" class="submitlongbutton">二代证读取</a></td>
                  </tr>
                     <tr>
                    <td align="center" ><a href="#" onclick="sanTwoOcrAddValue('<%=pic %>',<%=wi %>,<%=hi %>,<%=zh%>);addFun('<%=pic %>');return false;" class="submitlongbutton">二代证扫描</a></td>
                  </tr>
                  <tr>
                    <td align="center" ><a href="#" onclick="DeviceOnescanOcr('<%=pic %>',<%=wi %>,<%=hi %>,<%=zh%>);addFun('<%=pic %>');return false;" class="submitlongbutton">一代证读取</a></td>
                  </tr>
                  <%}if("false".equals(zh)){%>
                    <tr>
                    <td align="center" ><a href="#" onclick="Devicepassportscanocr('<%=pic %>',<%=wi %>,<%=hi %>,<%=zh%>);addFun('<%=pic %>');return false;" class="submitlongbutton">境外证件读取</a></td>
                  </tr>
                   <%}%>
                  <!-- 
                  <tr>
                    <td align="center" ><a href="#"  onclick="GetBigImage();return false;"  class="submitbutton">文 件</a></td>
                  </tr>
                   -->
                  <tr>
                    <td align="center" ><a href="#" onclick="DeleteImg('<%=pic %>');return false;"  class="submitlongbutton">取 消</a></td>
                  </tr>
              </table>
		</td>
	</tr>
	</table>
</body>

 