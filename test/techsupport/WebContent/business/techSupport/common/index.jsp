<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../../public/common.jsp"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants"%>
<%@page import="com.aisino2.sysadmin.domain.Globalpar"%>
<%@page import="com.aisino2.cache.CacheManager"%>
<%
	Object shouquanObj = session.getAttribute("shouquanEndDate");
	String shouquanEndDate = (shouquanObj != null
			&& !"".equals((String) shouquanObj) ? (String) shouquanObj
			: ""); //客服校验返回值
	String path = request.getContextPath();
	String basePath = "http" + "://" + request.getServerName() + ":"
			+ request.getServerPort() + path + "/";
	String usertype = "";
	String username = "";
	String departmentname = "";
	String useraccount = "";
	String password = "";

	//登录用户ID，用于获得菜单
	int userid = 0;
	User user = new User();
	//获得登录用户session
	user = (User) session.getAttribute(Constants.userKey);
	if (user == null)
		response.sendRedirect("login.jsp");
	else
		userid = user.getUserid().intValue();

	usertype = user.getUsertype();
	username = user.getUsername();

	password = user.getPassword();
	useraccount = user.getUseraccount();

	departmentname = user.getDepartment().getDepartname();
	String departLevel = user.getDepartment().getDepartlevel()
			.toString();
	if (departmentname == null || "".equalsIgnoreCase(departmentname))
		departmentname = "暂无";
%>
<script type="text/javascript">
<!--
	alert(1111111111);//###########
//-->
</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />     
		<title></title>
		
		<script language="javascript" type="text/javascript" src="business/techSupport/common/javascript/uploadify/jquery-1.4.2.min.js"></script>
		<script language="javascript" type="text/javascript" src="javascript/ext/adapter/jquery/ext-jquery-adapter.js"></script>
        <script language="javascript" type="text/javascript" src="javascript/ext/adapter/ext/ext-base.js"></script>
        <script language="javascript" type="text/javascript" src="javascript/ext/ext-all.js"></script>
		<script language="javascript" type="text/javascript" src="javascript/jquery.bgiframe.js?"></script>
		<script language="javascript" type="text/javascript" src="javascript/jquery.dimensions.js?"></script>
		<script language="javascript" type="text/javascript" src="javascript/jdsharp.js?"></script>
		<script language="javascript" type="text/javascript" src="javascript/jquery.jdMenu.js?"></script>
		<script language="javascript" type="text/javascript" src="javascript/jquery.jframe.js"></script>
		<script language="javascript" type="text/javascript" src="javascript/jquery.form.js"></script>
		<script language="javascript" type="text/javascript" src="javascript/jquery.ui.draggable.js"></script>
		<script language="javascript" type="text/javascript" src="javascript/jquery.alerts.js"></script>
		<script language="javascript" type="text/javascript" src="javascript/jquery.combobox.js"></script>
		<script language="javascript" type="text/javascript" src="javascript/jquery.combocheckbox.js"></script>
		<script language="javascript" type="text/javascript" src="javascript/valdate.js"></script>
		<script language="javascript" type="text/javascript" src="javascript/dictDropDown.js"></script>
		<script language="javascript" type="text/javascript" src="javascript/shxxTime.js"></script>
		<script language="javascript" type="text/javascript" src="javascript/shenfenzhengVal.js"></script>
 		<script language="javascript" type="text/javascript" src="javascript/gspicture.js"></script><!-- liufengAdd -->
		<script language="javascript" type="text/javascript" src="javascript/htmlConfig.js" charset="utf-8"></script>
		<script src="javascript/md5.js" language="javascript" type="text/javascript"></script>
		<script language="javascript" type="text/javascript" src="javascript/jquery.ingrid-0.9.2.js"></script>
		<script language="javascript" type="text/javascript" src="javascript/gad-cxtj-ksdld.js"></script>
		<script language="javascript" type="text/javascript" src="javascript/gad-cxtj-csld.js"></script>
		<script language="javascript" type="text/javascript" src="javascript/hylb-link-qyzfl.js"></script>
		<!-- to have Ingrid save her state (selected rows, page number, column sort & direction); just include the jQ cookie plugin -->
		<script language="javascript" type="text/javascript" src="javascript/jquery.cookie.js"></script>
		<script src="javascript/ui.datepicker.js" language="javascript" type="text/javascript" charset="utf-8"></script>
		<script src="javascript/DateTimeMask.js" language="javascript" type="text/javascript" charset="utf-8"></script>
		<script language="javascript" type="text/javascript" src="javascript/jquery.lightbox-0.5.js"></script>
		<script language="javascript" type="text/javascript" src="javascript/jquery.mypagination.js"></script>
<script language="javascript" type="text/javascript" src="javascript/htmlConfig_ba.js" charset="utf-8"></script>
		
		<link rel="stylesheet" href="css/stylemenu.css" type="text/css" />
		<link rel="stylesheet" href="css/jdMenu.css" type="text/css" />
		<link rel="stylesheet" href="css/jdMenu.jdsharp.css" type="text/css" />
		<link href="css/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
		<link rel="stylesheet" href="css/jquery.lightbox-0.5.css" type="text/css"></link>
		<link rel="stylesheet" href="css/mypagination.css" type="text/css"></link>
		<link rel="stylesheet" href="css/site.css" type="text/css" />
		<link rel="stylesheet" href="css/ingrid.css" type="text/css" />
		<link rel="stylesheet" href="css/style.css" type="text/css" />
		<link  rel="stylesheet"   href="css/main.css"  type="text/css" />
		<link rel="stylesheet" href="css/ui.datepicker.css" type="text/css" media="screen" title="core css file" charset="utf-8" />
</head>
	<script type="text/javascript">	
	var loginOutPath="<%=basePath%>"+"login.jsp";
	var testtime;
	var shouYeJiaZaiYeMian;
	var user_type;
	var menuList;
	var systemcode;
	var hy_MenuCode;//行业代码menu(表的munecode)
	var isDhyTag = 1;//是否是单行业:大于1为多行业
	$(document).ready(function (){
		//页面高度页面宽度
		allPageWidth = document.body.clientWidth;
		pageWidth=1020;
		pageHeight=document.body.clientHeight-45;
		setMenu();
	 	shouYeJiaZaiXiang(); //首页加载项
		clearTimeout(testtime); //// 清空setTimeout现成
		helpContr();
		getLoginlogNum();
	}).keydown(function(e){
		if(event.keyCode == 13){
			if(e.target.nodeName!=null && e.target.nodeName.toUpperCase()!="TEXTAREA")
			event.keyCode = 9;
		}
	});
	
	function shouYeJiaZaiXiang(){
	 	var hyflag = 0; ///行业类别  2为旅馆业
	 	
	 	var usertype = "<%=usertype%>";
	}
	//
	function jiaZaiShouYeYeMian(){
	 	$("#iframes").empty();
	 	if(shouYeJiaZaiYeMian!=null && shouYeJiaZaiYeMian!="")
			$("#iframes").load(shouYeJiaZaiYeMian);
		$("#iframes").show("slow");
		$("#iframes").width("1020");
	}

	//生成顶级菜单
    function setMenu(){
     $.post(
     	"<%=request.getContextPath()%>/sysadmin/allMenu_menu.action", 
     	{userid:'<%=userid%>',usertype:'<%=usertype%>'},
     	 function(result)
     	 {
     	 	$("#menumain").empty();
			$("#menumain").append($(result.treeMenuString));
			$("#menumain").append("<br>");
			initMoveMethod();
     	 	
			setBeginMenu();
			},
			"json"); 
		}
    function setBeginMenu(){
		$('ul.jd_menu').jdMenu();
		}		
	//点击叶子菜单 导航到相应页面
    function showContent(obj)
    {	
        closemusic();           /////选择菜单的时候关闭报警音乐
        clearTimeout(testtime); //// 清空setTimeout现成
    	//$('#'+jQuery(obj).attr("id")).click(function (){
   		func_code = jQuery(obj).attr("id");
   		$("#password_modify").empty();
	 		$("#iframes").empty();
		$("#iframes").load(jQuery(obj).attr("path"));
		$("#iframes").show("slow"); 	
    	//});
    }
        //返回首页
        function fnloginSy()
        {
        	
        }
        
       
         //退出系统 提示框为jalert方式,采用CA登录方式，由于退出时需要退出到https页面，必须采用此方式
        function fnlogout()
        {   
            $(window).unbind("unload");
        	jConfirm('确认退出本系统？', '提示信息', function(r) {
	    	if(r==true){
				//$(document).children().remove();


        		var sUrl="sysadmin/loginout_login.action";
          		jQuery.ajax({
					type: 'POST',
					url: sUrl,
					data: params,
					async: false,
					dataType: 'json',
					success: update_page
				});
			}else{
			   return false;
			}
		});
        	clearTimeout(testtime); //// 清空setTimeout现成
        }
        
   //退出系统时的回调方法
     function update_page (json) { //回传函数实体，参数为XMLhttpRequest.responseText
		window.opener=null;    
		window.open(loginOutPath,"","toolbar=yes,location=yes,directories=yes,menubar=yes,scrollbars=no,resizable=yes,status=yes,top=0,left=0,height="+screen.availHeight+",width="+screen.availWidth);
		window.close();
	}   
	//修改密码
	function fnmodifypassword() {
		//$("#iframes").empty();
		$("#password_modify").empty();
		$("#password_modify").load("public/passwordModify.jsp");
		$("#password_modify").show("slow");
	}
	
	function setCssPath(path){
		if(path==null || path==""){
			path = "css";
		}
		//setCssUrl(path);//换图片地址
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
	
	function setCssUrl(temp_css){
	
		var usertype = "<%=usertype%>";
		var lb="0";
		if(temp_css=='css'){
			var lb="0";
		}
		 if(temp_css=='cssblue'){
			var lb="1";
		}
		 if(temp_css=='cssred'){
			var lb="2";
		}
			if(usertype.indexOf("14")!=-1||usertype.indexOf("144")!=-1)
			 	$('#header').css('background-image','url(images/logo_'+lb+'11.jpg)');
			if(usertype.indexOf("11")!=-1||usertype.indexOf("141")!=-1)
			 	$('#header').css('background-image','url(images/logo_'+lb+'13.jpg)');
			if(usertype.indexOf("12")!=-1||usertype.indexOf("142")!=-1)
			 	$('#header').css('background-image','url(images/logo_'+lb+'14.jpg)');
			if(usertype.indexOf("13")!=-1||usertype.indexOf("143")!=-1)
			 	$('#header').css('background-image','url(images/logo_'+lb+'12.jpg)');
			
	}
//初始化左右移动按钮及操作
var moveArray = new Array();
function initMoveMethod(){
	moveArray.push(0);
	var liList = $("#div_menumain #menumain > li");
 	var lastMenuWidth = 0;
 	var index=0;
	var pageMenuWidth = 0;
 	var length=liList.length;
 	for(;index<length;index++){
 		lastMenuWidth = liList.eq(index).width();
 		pageMenuWidth = pageMenuWidth + lastMenuWidth;
 		if(pageMenuWidth>=pageWidth-lastMenuWidth){
 			if(index%2!=0){
 				index = index - 1;
 			}
 			break;
 		}
 	}
 	if(index<length){
 		$("#div_moveMenu").html('<img src="images/left.gif" style="cursor:hand" onclick="ceshi(-1)" first="1" />&nbsp;<img src="images/right.gif" style="cursor:hand" onclick="ceshi(1)" last="0" />&nbsp;');
 	}
 	
 	shuzi = index;
 	yidongcishu = 0;
 	liList.slice(index).hide();
 	moveArray.push(index);
}
//左右移动操作方法
var yidongcishu = 0;
var shuzi = 0;
function ceshi(yiDongWay){
	var liList = $("#div_menumain #menumain > li");
	var liLength = liList.length;
	
	var sliceLiList;
 	var index=0;
	var pageMenuWidth = 0;
	var lastMenuWidth = 0;

	if(yiDongWay==1){	
		if(shuzi<liLength-1){
			liList.hide();
			sliceLiList = liList.slice(shuzi);
			var length = sliceLiList.length;
			for(;index<length;index++){
		 		lastMenuWidth = sliceLiList.eq(index).width();
		 		pageMenuWidth = pageMenuWidth + lastMenuWidth;
		 		if(pageMenuWidth>=pageWidth-lastMenuWidth){
			 		if(index%2!=0){
		 				index = index - 1;
		 			}
		 			break;
		 		}
		 	}
		 	shuzi = shuzi + index;
		 	sliceLiList.slice(0,index).show().find("li").show("slow");

			var firstImg = $("#div_moveMenu").find("img:first");
			if(firstImg.attr("first")=="1"){
				firstImg.attr("src","images/left1.gif");
				firstImg.attr("first","0");
			}
			if(shuzi>=liLength-1){
				$("#div_moveMenu").find("img:last").attr("src","images/right1.gif").attr("last","1");
			}
			yidongcishu++;
			moveArray.push(shuzi);
	 	}
	}else{
		if(yidongcishu>0){
			liList.hide();
			var currIndex = moveArray[yidongcishu];
			liList.slice(moveArray[yidongcishu-1],currIndex).show().find("li").show("slow");
			yidongcishu--;
			shuzi = currIndex;
		}
		var lastImg = $("#div_moveMenu").find("img:last");
		if(lastImg.attr("last")=="1"){
			lastImg.attr("src","images/right.gif");
			lastImg.attr("last","0");
		}
		if(yidongcishu==0){
			$("#div_moveMenu").find("img:first").attr("src","images/left.gif").attr("first","1");;
		}
	}
}
   /////关闭报警音乐
   function closemusic(){
      //document.music.stop();
   }
   /////开始报警音乐
   function playmusic(){
      //document.music.play();
   }
   
   //顶部登陆状态
   function getLoginlogNum(){
		jQuery.ajax({
		   type: 'POST',
		   url: "sysadmin/getLoginlogNum_loginlog.action",
		   data: {},
		   async: true,
		   dataType: 'json',
		   success: function(json){
		   		$("#loginNum").append(json.logNum);
		   		$("#loginSum").append(json.logNumAll);
		   }
		});
	}
	
	//点击叉号关闭调用
	$(window).unload(function(){
		window.open("unload.jsp","newwindow","height=0,width=0,toolbar=no,menubar=no,scrollbars=no,location=no,status=no,left=20000,top=2000");
	});
	
	/**
	 * 帮助控制
	 */
    function helpContr(){
       
    }
</script>
		<input type="hidden" id="b_useraccount" value="<%=useraccount%>" />
		<table width="1020" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>
					<div id="mainDIV">
						<table width="1020" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td height="144" valign="top" background="images/logo.jpg">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td height="43" colspan="2" valign="top">
												<table width="96%" border="0" align="center" cellpadding="3"
													cellspacing="0">
													<tr>
														<td width="75%">
															<table>
																<tr>
																	<td>
																		当前用户：
																		<span class="yhxx"><%=username%>(<%=departmentname%>)</span>
																	</td>
																	<td id="loginInfoTD">
																		今日共有
																		<span class="yhxx" id="loginNum"></span>个，全部共有
																		<span class="yhxx" id="loginSum"></span>个用户登录
																	</td>
																</tr>
															</table>
														</td>
														<td width="25%" align="right">
															<img src="images/ioc_02.jpg" width="16" height="18"
																id='login_img' />
															<a class="headlink" href="#" id='login'
																onclick='fnloginSy();'>首页</a>
															<img src="images/ioc_04.jpg" width="17" height="18"
																id="pwd_img" />
															<a class="headlink" href="#" id='modifypassword'
																onclick='fnmodifypassword();'>修改密码</a>
															<img src="images/ioc_06.jpg" width="20" height="18" />
															<a class="headlink" href="#" id='help'>帮助</a>
															<img src="images/ioc_08.gif" width="19" height="18" />
															<a class="headlink" href="#" id='logout'
																onclick='fnlogout();'>退出</a>
													</tr>
												</table>
											</td>
										</tr>
										<tr>
											<td width="9%"></td>
											<td width="91%" valign="bottom" class="titlefont">
												社会信息采集平台
											</td>
										</tr>
										<tr>
											<td></td>
											<td valign="top" class="smalltitlefont">
												保安员管理系统
											</td>
										</tr>
										<tr><td>&nbsp;</td></tr>
										<tr><td colspan="2">
						<div id="div_moveMenu" style="float:right; margin-top:-35"></div>
						<div id="div_menumain" style="margin-top:-38">
							<ul id='menumain' class='jd_menu jd_menu_jdsharp'></ul>
						</div></td></tr>
									</table>
								</td>
							</tr>
						</table>
<div id=iframes onload='$("iframes").show("slow");' style="top: 150px; background-color: #ffffff;  padding: 0px; "></div>
<div id="password_modify" class="page-layout" src="#" style="display: none; top: 110px; left: 350px; width: 300px;"></div>
						
					</div>
				</td>
			</tr>
		</table>
		<div id="hyTzListDiv" style="position: absolute;">
			<table id="hyListTable" width="150" border="0" cellpadding="3"
				cellspacing="0" style="border: 1px #6e9cbe solid">
			</table>
		</div>
		<div id="man_help" class="page-layout" src="#"
			style="top: 180px; left: 300px; display: none; width: 600px;">
</html>
