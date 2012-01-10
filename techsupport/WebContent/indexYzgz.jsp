<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants"%>
<%@page import="com.aisino2.sysadmin.domain.Globalpar"%>
<%@page import="com.aisino2.cache.CacheManager"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	//登录用户ID，用于获得菜单
	int userid = 0;
	User user = new User();
	//获得登录用户session
	user = (User) session.getAttribute(Constants.userKey);
	if (user == null)
		response.sendRedirect("login.jsp");
	else
		userid = user.getUserid().intValue();

	String usertype = user.getUsertype();
	String username = user.getUsername();
	String departmentname = user.getDepartment().getDepartname();
	String departLevel = user.getDepartment().getDepartlevel()
			.toString();
	if (departmentname == null || "".equalsIgnoreCase(departmentname))
		departmentname = "暂无";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title></title>
		<link rel="stylesheet" href="css/stylemenu.css" type="text/css" />
		<link rel="stylesheet" href="css/jdMenu.css" type="text/css" />
		<link rel="stylesheet" href="css/jdMenu.jdsharp.css" type="text/css" />
		<link href="css/jquery.alerts.css" rel="stylesheet" type="text/css"
			media="screen" />
		<script type="text/javascript" src="javascript/jquery.js"></script>
		<script type="text/javascript" src="javascript/jquery.bgiframe.js?"></script>
		<script type="text/javascript" src="javascript/jquery.dimensions.js?"></script>

		<script type="text/javascript" src="javascript/jdsharp.js?"></script>
		<script type="text/javascript" src="javascript/jquery.jdMenu.js?"></script>
		<script type="text/javascript" src="javascript/jquery.jframe.js"></script>
		<script type="text/javascript" src="javascript/jquery.form.js"></script>
		<script type="text/javascript" src="javascript/jquery.ui.draggable.js"></script>
		<script type="text/javascript" src="javascript/jquery.alerts.js"></script>
		<script type="text/javascript" src="javascript/jquery.combobox.js"></script>
		<script type="text/javascript"
			src="javascript/jquery.combocheckbox.js"></script>
		<script type="text/javascript" src="javascript/valdate.js"></script>
		<script type="text/javascript" src="javascript/dictDropDown.js"></script>
		<script type="text/javascript" src="javascript/shxxTime.js"></script>
		<script type="text/javascript" src="javascript/icctwocjjs.js"></script>
		<script type="text/javascript" src="javascript/ickDxrV1.js"></script>
		<script type="text/javascript" src="javascript/forOffineJs.js"></script>
		<script type="text/javascript" src="javascript/shenfenzhengVal.js"></script>
		<script type="text/javascript" src="javascript/gspicture.js"></script>
		<!-- liufengAdd -->
		<script type="text/javascript" src="javascript/htmlConfig.js"
			charset="utf-8"></script>
		<script src="javascript/md5.js" type="text/javascript"></script>
		<script type="text/javascript" src="javascript/jquery.ingrid-0.9.2.js"></script>
		<script type="text/javascript" src="javascript/gad-cxtj-ksdld.js"></script>
		<script type="text/javascript" src="javascript/gad-cxtj-csld.js"></script>
		<!-- to have Ingrid save her state (selected rows, page number, column sort & direction); just include the jQ cookie plugin -->
		<script type="text/javascript" src="javascript/jquery.cookie.js"></script>
		<script src="javascript/ui.datepicker.js" type="text/javascript"
			charset="utf-8"></script>
		<script src="javascript/DateTimeMask.js" type="text/javascript"
			charset="utf-8"></script>
		<script type="text/javascript" src="javascript/jquery.lightbox-0.5.js"></script>
		<link rel="stylesheet" href="css/jquery.lightbox-0.5.css"
			type="text/css"></link>
		<link rel="stylesheet" href="css/site.css" type="text/css" />
		<link rel="stylesheet" href="css/ingrid.css" type="text/css" />
		<link rel="stylesheet" href="css/style.css" type="text/css" />
		<link rel="stylesheet" href="css/ui.datepicker.css" type="text/css"
			media="screen" title="core css file" charset="utf-8" />
		<style type="text/css">
<!--
#apDiv1 {
	position: absolute;
	width: 200px;
	height: 115px;
	z-index: 2001;
}
-->
</style>
	</head>
	<script type="text/javascript">
$(document).ready(function (){
		//页面加载时，生成菜单
		setMenu();
		//页面高度页面宽度
		pageWidth=1020;
		pageHeight=document.body.clientHeight;
	 	document.getElementById("allDiv").style.width=pageWidth;
	 	document.getElementById("allDiv").style.height=pageHeight;	
}).keydown(function(){
		if(event.keyCode == 13){
			event.keyCode = 9;
		}
	});
	
		//生成顶级菜单
        function setMenu(){
         $.post(
         	"<%=request.getContextPath()%>/sysadmin/allMenu_menu.action", 
         	{userid:'<%=userid%>',usertype:'<%=usertype%>'},
         	 function(result)
         	 {
				$("#menumain").append($(result.treeMenuString));
         	 	
				setBeginMenu();
	 			showContent($("#menumain #yzxxcx"));
 			},
 			"json"); 
 		}
 		function setBeginMenu(){
 			$('ul.jd_menu').jdMenu();
 		}		
		//点击叶子菜单 导航到相应页面
        function showContent(obj)
        {	
       		func_code = jQuery(obj).attr("id");
       		$("#password_modify").empty();
 	 		$("#iframes").empty();
			$("#iframes").load(jQuery(obj).attr("path"));
			$("#iframes").show("slow"); 	
        }
        
        //退出系统
        function fnlogout()
        {
        	if(confirm("确认退出本系统?"))
        	{
        		//window.location.href='public/loginout.jsp';
        		var sUrl="sysadmin/loginout_login.action";
          		jQuery.ajax({
					type: 'POST',
					url: sUrl,
					data: params,
					async: false,
					dataType: 'json',
					success: update_page
				});
        	}
        	else
        	{
        		return false;
        	}
        }
        
        function update_page (json) { //回传函数实体，参数为XMLhttpRequest.responseText
        		window.opener=null;    
        		window.open("yzlogin.jsp");
				window.close();
		}
        
 function setCssPath(path){
	if(path==null || path==""){
		path = "css";
	}
	$(document).find("link").each(function(){
		var thisHref = $(this).attr("href");
		thisHref = thisHref.substr(thisHref.indexOf("/"));
    	$(this).attr("href",path+thisHref);
    });
}
</script>
	<body scroll="no" background="images/zh.gif">
	<table width="1020" border="0"  align="center" cellpadding="0" cellspacing="0">
	<tr>
	<td>
		<div id="allDiv" align="center">
			<div id="antiFooter">
				<div id="header">
					<div id="logo">
						<div style="float: left; padding-top: 15px; padding-left: 550px;">
							<table width="40%" border="0" align="left" cellpadding="3"
								cellspacing="0">
								<tr>
									<td class="fontpart">
										当前用户:<%=username%>
									</td>
								</tr>
							</table>
						</div>
						<table width="155" border="0" align="right" cellpadding="0"
							cellspacing="0">
							<tr>
								<td rowspan="2">
									<a class="out" href="#" id='logout' onclick='fnlogout();'></a>
								</td>
							</tr>
							<tr>
								<td height="3"></td>
							</tr>
							<tr>
								<td colspan="5" align="right">
									<table width="60" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td height="19">
												<a href="javascript:setCssPath('css');"
													onfocus="this.blur();" class="bottonskin1"></a>
											</td>
											<td>
												<a href="javascript:setCssPath('cssblue');"
													onfocus="this.blur();" class="bottonskin2"></a>
											</td>
											<td>
												<a href="javascript:setCssPath('cssred');"
													onfocus="this.blur();" class="bottonskin3"></a>
											</td>
											<td width="20"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</div>
					<div id="div_moveMenu" style="float: right"></div>
					<div id="div_menumain">
						<ul id='menumain' class='jd_menu jd_menu_jdsharp'></ul>
					</div>
				</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="3"></td>
					</tr>
				</table>

				<div id=iframes onload='$("iframes").show("slow");'
					style="top: 150px; background-color: #FFFFFF; padding: 0px">
				</div>

				<div id="password_modify" class="page-layout" src="#"
					style="display: none; top: 110px; left: 350px; width: 300px;"></div>
			</div>

		</div>
</td></tr></table>
	</body>
</html>
