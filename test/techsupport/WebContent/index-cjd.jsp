<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="public/common.jsp" %>
<%@include file="public/user-info.jsp" %>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>
<%@include file="public/includeKongJian.jsp" %>
<%@include file="public/includegsWebTools.jsp" %>
<%
    // user ID
	int userid = user.getUserid().intValue();
	// 用户类型
	String usertype = user.getUsertype();
	// 用户密码
	String password = user.getPassword();
	
	Globalpar globalpar = new Globalpar();
	Globalpar temp = null;
	List globList = null;
			
	String content_urls = "";
	String content_yzdz = "";
	String content_connJava = "";
	String content_deviceType = "";
	String content_yzdz_org = "";
		
	globalpar.setGlobalparcode("ylyurl");
	globList = CacheManager.getCacheGlobalpar(globalpar);
	if(globList!=null&&globList.size()>0){
		temp = (Globalpar)globList.get(0);
		content_urls = temp.getGlobalparvalue();	
	}
			
	globalpar.setGlobalparcode("kjvalidater");
	globList = CacheManager.getCacheGlobalpar(globalpar);
	if(globList!=null&&globList.size()>0){
		temp = (Globalpar)globList.get(0);
		content_yzdz = temp.getGlobalparvalue();	
		content_yzdz_org = content_yzdz;
		//content_yzdz =content_yzdz+","+password;
	}
			
	globalpar.setGlobalparcode("connjava");
	globList = CacheManager.getCacheGlobalpar(globalpar);
	if(globList!=null&&globList.size()>0){
		temp = (Globalpar)globList.get(0);
		content_connJava = temp.getGlobalparvalue();	
	}
			
	if(content_connJava.equals("3")){
	    content_yzdz =content_yzdz+","+password;
	}
			
	globalpar.setGlobalparcode("deviceType");
	globList = CacheManager.getCacheGlobalpar(globalpar);
	if(globList!=null&&globList.size()>0){
		temp = (Globalpar)globList.get(0);
		content_deviceType = temp.getGlobalparvalue();	
	}
	
	// 取得证书登陆时的ID
	String ukeyid = (String)session.getAttribute("ukeyid");
	if(ukeyid == null){
	    ukeyid = ""; 
	}
 %>

<script language="javascript" type="text/javascript" src="javascript/icctwocjjs.js"></script>
<script language="javascript" type="text/javascript" src="javascript/ickDxrV1.js"></script>
<script language="javascript" type="text/javascript" src="javascript/forOffineJs.js"></script>
<script language="javascript" type="text/javascript" src="javascript/htmlConfig_nbhy.js"></script>
<script type="text/javascript">
 	var user_type = "<%=usertype%>";
    var content_urls = '<%=content_urls %>'; //系统全路径
	var content_yzdz = '<%=content_yzdz %>'; //验证文件
	var content_yzdz_org = '<%=content_yzdz_org %>'; //验证文件(不加密码值)
	var content_connJava = '<%=content_connJava %>'; //产品化和老程序标志
	var content_deviceType = '<%=content_deviceType %>'; //驱动标志
	var ukeyid = '<%=ukeyid%>';
	$(document).ready(function (){
		loadCjd(); 
		getLoginlogNum(); 
		reloadHyIndex(10,5); 
		helpContr(); 
	});
	
	function loadCjd(){ 
		if(systemcode=="cjd"){ 
			setMenu("cjd"); 
			//shouYeJiaZaiYeMian = "basic/icksystem/Tz-cjd.jsp";
			shouYeJiaZaiYeMian = "";
		}
	 	jiaZaiShouYeYeMian();
	}
</script>

<body style="margin:0px;">
<table width="1020" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="144" valign="top" background="images/logo.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="43" colspan="2" valign="top"><table width="96%" border="0" align="center" cellpadding="3" cellspacing="0">
          <tr>
            <td width="50%">
				<table>
		            <tr>
			            <td style="white-space:nowrap;" >当前用户：<span class="yhxx"><%=username %>(<%=gxdwmc%>)</span>今日共有<span class="yhxx" id="loginNum"></span>个，全部共有<span class="yhxx" id="loginSum"></span>个用户登录</td>
		            </tr>
		         </table>
			</td>
            <td width="50%" align="right">
            	<!--    
					tz_login_button 为跳转按钮ID 各行业如无特殊需求可以不改此id。
					如果修改id值的话，reloadHyIndex方法，
					请将此id当参数传入(reloadHyIndex方法在index.jsp页面中)
				 -->
				<img src="images/redo1_16x16.gif" width="16" height="18" id="tz_login_img"/>
					<a class="headlink" href="#" id='tz_login_button'>跳转</a>	
				<img src="images/ioc_02.jpg" width="16" height="18" id='login_img'/>        
            		<a class="headlink" href="#" id='login' onclick='fnloginSy();'>首页</a>
<!--           		<img src="images/lightbulb.gif" width="16" height="18" id='sytz_img'/>-->
<!--					<a class="headlink" href="#" id='sytz_button' onclick="loadCjd();">台帐</a>-->
            	<img src="images/ioc_04.jpg" width="17" height="18" id="pwd_img"/>            		
            		<a class="headlink" href="#" id='modifypassword' onclick='fnmodifypassword();'>修改密码</a>
            	<img src="images/ioc_06.jpg" width="20" height="18" />           	
            		<a class="headlink"   href="#"  id='help'>帮助</a>
            	<img src="images/ioc_08.gif" width="19" height="18" />            	
            		<a class="headlink" href="#" id='logout' onclick='fnlogout();'>退出</a>	
          </tr>
        </table></td>
      </tr>
      <tr>
        <td width="9%"></td>
        <td width="91%" valign="bottom" class="titlefont" >技术支持单系统</td>
      </tr>
      <tr>
        <td></td>
        <td valign="top" class="smalltitlefont" >采集点信息系统</td>
      </tr>
    </table></td>
  </tr>
</table>
<div id="div_moveMenu" style="float:right;margin-top: -35" ></div>
<div id="div_menumain" style="margin-top: -38"><ul id='menumain' class='jd_menu jd_menu_jdsharp'></ul></div>
<div id=iframes onload='$("iframes").show("slow");' style="top: 150px; background-color: #ffffff;  padding: 0px; "></div>
<div id="password_modify" class="page-layout" src="#" style="display: none; top: 110px; left: 350px; width: 300px;"></div>
