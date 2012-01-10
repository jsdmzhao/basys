<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.sysadmin.domain.User" %>
<%@ page import="com.aisino2.sysadmin.domain.Department" %>
<%@ page import="com.aisino2.sysadmin.Constants" %>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
	String usertype="";
	String username="";
	String departmentname="";
	String useraccount="";
	String password="";
	int userid=0;
	if(session!=null){
		//登录用户ID，用于获得菜单

		User user = new User();
		//获得登录用户session
		user = (User) session.getAttribute(Constants.userKey);
		if (user == null){
			response.sendRedirect("login-baojing.jsp");}
		else{
			userid = user.getUserid().intValue();
		usertype = user.getUsertype();
		username = user.getUsername();
		password=user.getPassword();
		useraccount=user.getUseraccount();
		departmentname = user.getDepartment().getDepartname();}
		if(departmentname == null || "".equalsIgnoreCase(departmentname)){
			departmentname = "暂无";
			}
			//out.println(user.getUsername());
	}else{
	
	     //User user = new User();
	 	// Department department = new Department();
		// session = request.getSession();
	    // usertype = request.getParameter("usertype");
		// String departcodeString = request.getParameter("gxdwbm");
		// departmentname = request.getParameter("departname");
		// username = request.getParameter("username");
		 //userid= Integer.parseInt(request.getParameter("userid"));
		 //user.setUserid(userid);
		 //department.setDepartcode(departcodeString);
		 //user.setUsertype(usertype);
		// user.setDepartment(department);
		 //user.setDepartname(departmentname);
		// session.setAttribute(Constants.userKey,user);
		// session.setAttribute("gxdwbm",departcodeString);
		// out.println("sesion is kong");
	
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
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
		<script src="javascript/md5.js" type="text/javascript"></script>
		<script type="text/javascript" src="javascript/htmlConfig.js"
			charset="utf-8"></script>
		<script type="text/javascript" src="javascript/jquery.ingrid-0.9.2.js"></script>
		<!-- to have Ingrid save her state (selected rows, page number, column sort & direction); just include the jQ cookie plugin -->
		<script type="text/javascript" src="javascript/jquery.cookie.js"></script>
		<script src="javascript/ui.datepicker.js" type="text/javascript"
			charset="utf-8"></script>
		<script src="javascript/DateTimeMask.js" type="text/javascript"
			charset="utf-8"></script>
<script type="text/javascript" src="javascript/jquery.lightbox-0.5.js"></script>
<link rel="stylesheet" href="css/jquery.lightbox-0.5.css" type="text/css"></link>
		<link rel="stylesheet" href="css/site.css" type="text/css" />
		<link rel="stylesheet" href="css/ingrid.css" type="text/css" />
		<link rel="stylesheet" href="css/style.css" type="text/css" />
		<link rel="stylesheet" href="css/ui.datepicker.css" type="text/css"
			media="screen" title="core css file" charset="utf-8" />
	    <style type="text/css">
<!--
#apDiv1 {
	position:absolute;
	width:200px;
	height:115px;
	z-index:2001;
}
-->
        </style>
</head>
	<script type="text/javascript">
	
	//报警控件用到函数
	  function getGxdwbm(){
	      	//报警客户端调用getGxdwbm方法时所需要的密码
	       var clientCallPassword = "";
		   var gxdwbm = "<%=session.getAttribute("gxdwbm")%>";
		     
		          var username = "<%=username%>";
		               var userid = "<%=userid%>";
		      var departname = "<%=departmentname%>";
		      
		            var usertype = "<%=usertype%>";
				var useraccount = "<%=useraccount%>";
				//通过账号获得密码
          setParams("b_");
          var sUrl="sysadmin/queryPasswordByUseraccount_user.action";
          jQuery.ajax({
			type: 'POST',
			url: sUrl,
			data: params,
			async: false,
			dataType: 'json',
			success: function update_clientCallPassword (json) 
					{ //回传函数实体，参数为XMLhttpRequest.responseText
				      if (json.result=="success")
				      {
				      
				      	clientCallPassword=json.passwordResult;
				      	//alert(clientCallPassword);
				      	//alert(getGxdwbm());
				      }
				      else
				      {
				      	clientCallPassword="";
					  }
					},
			complete: function(){
				
			}
			});
			//alert("33--"+clientCallPassword);
		  return gxdwbm.toString()+":"+usertype.toString()+":"+departname.toString()+":"+username.toString()+":"+userid.toString()+":"+useraccount.toString()+":"+clientCallPassword.toString();
	  }
//创建场所编码和场所名称的session 用于客户端民警登陆取得客户端得场所编码和场所名称
	  function creatSessionForCsbmCsmc(csbm,csmc){
	      var sUrl="sysadmin/creatSessionForCsbmCsmc_login.action";
	      var aa=3;//0失败，1成功
	     jQuery.ajax({
			type: 'POST',
			url: sUrl,
			data: {csbm:csbm,csmc:csmc},
			async: false,
			dataType: 'json',
			success: function (json) {
			aa=1;
			
			},
		   error: function (json) {
			 aa=0;
			}
		
			});
			
			return aa;
			
			
	  }
	  
	
	var testtime;
$(document).ready(function (){
		getGxdwbm();
		//页面高度页面宽度
		pageWidth=document.body.clientWidth;
		pageHeight=document.body.clientHeight;
	 	document.getElementById("allDiv").style.width=pageWidth;
	 	document.getElementById("allDiv").style.height=pageHeight;
	 	
	 	var hyflag = 0; ///行业类别  2为旅馆业
	 	
	 	var usertype = "<%=usertype%>".split(",");
	 	for(i=0;i<usertype.length;i++){
	 	  if(usertype[i]=="24")
	 	    hyflag = 2;
	 	  else if(usertype[i]=="13")
	 	    hyflag = 3;
	 	}
	 	
		///////////////////////////////////////////////////////
		
	 	//////装载 报警页面方法/////////////////////////////////
	        $("#password_modify").empty();
		 	$("#iframes").empty();
			$("#iframes").load("basic/basicsystem/JqxxClient.jsp");
			$("#iframes").show("slow"); 
	//////////////////////////////////////////////////////
		$("#div_login").css({
			position: 'absolute',
			zIndex: 99999999,
			padding: 0,
			margin: 0,
			top: (pageHeight/2-25) + 'px',
			left: (pageWidth/2-122) + 'px'
		});
		$("#div_login").hide();
	
		
		clearTimeout(testtime); //// 清空setTimeout现成
});
		
 			
        //退出系统


        function fnlogout()
        {
        		var sUrl="sysadmin/loginout_login.action";
          		jQuery.ajax({
					type: 'POST',
					url: sUrl,
					data: params,
					async: false,
					dataType: 'json',
					success: update_page
				});
        	
        	clearTimeout(testtime); //// 清空setTimeout现成
        }
        
        function update_page (json) { //回传函数实体，参数为XMLhttpRequest.responseText
		      window.location.href='login-baojing.jsp';
		}
        
        //修改密码
        function fnmodifypassword()
        {
        	//$("#iframes").empty();
        	$("#password_modify").empty();
        	$("#password_modify").load("public/passwordModify.jsp");
        	$("#password_modify").show("slow");
        }
 function setCssPath(path){
	if(path==null || path==""){
		path = "css";
	}
	var linkHtml = "";
	var linkList = $(document).find("link");
	linkList.each(function(){
		var thisHref = $(this).attr("href");
		thisHref = thisHref.substr(thisHref.indexOf("/"));
		linkHtml += "<link rel='stylesheet' href='"+path+thisHref+"' type='text/css' />";
    });
    linkList.remove();
    $("head").append($(linkHtml));
}



   /////关闭报警音乐
   function closemusic(){
      document.music.stop();
   }
   /////开始报警音乐


   function playmusic(){
      document.music.play();
   }
</script>
	<body scroll="no" background="images/zh.gif">
	<input type="hidden" id="b_useraccount" value="<%=useraccount%>"/>
		<table width="1003" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>
<div id="allDiv" align="center" style="width:1003px;">
			<div id="antiFooter">
				<div id="header1">
					<div id="logo">
                    <div style="float:left; padding-top:30px; padding-left:590px;" ><table width="55%" border="0" align="left" cellpadding="3" cellspacing="0">
    <tr>
    <td class="fontpart">当前用户:<%=username %>(<%=departmentname %>) </td>
  </tr>
</table>

</div>
						<table width="80" border="0" align="right" cellpadding="0"
							cellspacing="0">
							<tr>
								<td>
									<a class="pass" href="#" id='modifypassword'
										onclick='fnmodifypassword();'></a>
								</td>
							</tr>
							<tr>
								<td colspan="3" align="right">
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
					</div><div id="div_moveMenu" style="float:right"></div>
					<div id="div_menumain"><ul id='menumain' class='jd_menu jd_menu_jdsharp'></ul></div>
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
        </td>
  </tr>
</table>

		

  <div id=div_login style="position:absolute; background:url(images/loadingbg.gif); width:243px; height:55px;font-size:13px; font-weight:bold; color:#666666;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr><td height="17px;"></td></tr>
		<tr><td width="15"></td>
		    <td><img src="images/loading.gif"/></td>
		    <td>加载中，请稍候......</td>
		</tr>
		</table>
	</div>
    <div id="apDiv1"><embed name="music" src="sound/call.wav" autostart="false" loop="true" hidden="true"><!-- 报警音乐 --></div>
</body>
</html>
