<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="public/common.jsp" %>
<%@ page import="com.aisino2.sysadmin.domain.User" %>
<%@ page import="com.aisino2.sysadmin.Constants" %>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>
<%
	Object shouquanObj = session.getAttribute("shouquanEndDate");
	String shouquanEndDate =  (shouquanObj!=null&&!"".equals((String)shouquanObj)?(String)shouquanObj:""); //客服校验返回值
	String path = request.getContextPath();
	String basePath ="http"+ "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	String usertype="";
	String username="";
	String departmentname="";
	String useraccount="";
	String password="";
	
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
	
	password=user.getPassword();
	useraccount=user.getUseraccount();
	
	departmentname = user.getDepartment().getDepartname();
	String departLevel = user.getDepartment().getDepartlevel().toString();
	if(departmentname == null || "".equalsIgnoreCase(departmentname))
		departmentname = "暂无";		
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />     
		<title></title>
		<script language="javascript" type="text/javascript" src="javascript/jquery.js"></script>
<!-- 		<script language="javascript" type="text/javascript" src="business/techSupport/common/javascript/uploadify/jquery-1.4.2.min.js"></script> -->
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
	    <style type="text/css">
			<!--
			body { scroll:no; }
			html { overflow-x: hidden; overflow-y: hidden; }
			
			#apDiv1 {
				position:absolute;
				width:200px;
				z-index:2001;
			}
			BODY {
			background-position: center;
			background-repeat: no-repeat; 
			background-attachment: fixed;} 
			--> 
        </style>
</head>
<!--通过include指令嵌入用于CA登录后进行处理的代码与index页面一同编译-->
<%@include file="/ca/checkUsbkey.jsp" %>

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
		onloadIndex();//首页加载项
		clearTimeout(testtime); //// 清空setTimeout现成
		helpContr();
	}).keydown(function(e){
		if(event.keyCode == 13){
			if(e.target.nodeName!=null && e.target.nodeName.toUpperCase()!="TEXTAREA")
			event.keyCode = 9;
		}
	});
	
	function onloadIndex(){
		 //判断用户类别
	     user_type = "<%=usertype%>";
		 $.post("<%=request.getContextPath()%>/sysadmin/queryHangYeMenu_menu.action", 
         	{userid:'<%=userid%>',usertype:user_type},
         	 function(json){
         		isDhyTag = json.menu.singleHylb;
       	 		menuList=json.LMenu;
       	 		systemcode=menuList[0].systemcode;
       	 		if(systemcode=="sys"){
       	 			if(isDhyTag>1){ 	//多行业跳转
	       	 			//systemcode="gad";	
	       	 			shouYeJiaZaiYeMian = "index-duohy.jsp";
	       	 			hyLoad();
	       	 		}else{		//单行业跳转
	       	 			var len=menuList.length;
	       	 			if(len>1){
	       	 				for(var i=0;i<len;i++){
	       	 					var mc=menuList[0].menucode;
	       	 					//if(mc!="xtgl_g"&&mc!="gad-glpt"&&mc!="gad-mjjcz"&&mc!="ukeygl"&&mc!="tjfx_glpt"){
	       	 						hy_MenuCode=mc;
	       	 					//}
	       	 				}
	       	 			}else{
	       	 				hy_MenuCode=menuList[0].menucode;
	       	 			}				
	       	 			//systemcode=menuList[0].systemcode;
	       	 			hyIndex(hy_MenuCode);
	       	 		}
       	 		}else if(systemcode=="qyd"){
       	 			for(var i=0;i<menuList.length;i++){
       	 				var code=menuList[i].menucode;
       	 				//排除企业端的公共模块
       	 				if(code!="usbkey_qyd"&&code!="qyd-guanlipingtai"){
       	 					hy_MenuCode=code;
       	 					break;
       	 				}
       	 			}
	       	 		hyIndex(hy_MenuCode);
       	 		}else if(systemcode=="zkd"){
			 		if(isDhyTag>1){ 	//多行业跳转
	       	 			//systemcode="gad";	
	       	 			shouYeJiaZaiYeMian = "index-duohy-zkd.jsp";
	       	 			hyLoad();
	       	 		}else{		//单行业跳转
	       	 			hy_MenuCode=menuList[0].menucode;						
	       	 			//systemcode=menuList[0].systemcode;
	       	 			hyIndex(hy_MenuCode);
	       	 		}	 
			 	}else if(systemcode=="cjd"){
			 		if(isDhyTag>1){ 	//多行业跳转
	       	 			//systemcode="gad";	
	       	 			shouYeJiaZaiYeMian = "index-duohy-cjd.jsp";
	       	 			hyLoad();
	       	 		}else{		//单行业跳转
	       	 			hy_MenuCode=menuList[0].menucode;						
		         		
	       	 			//systemcode=menuList[0].systemcode;
	       	 			hyIndex(hy_MenuCode);
	       	 		}	 	 
			 	}else if (systemcode=="zcd"){
			 		if(isDhyTag>1){ 	//多行业跳转
	       	 			//systemcode="gad";	
	       	 			shouYeJiaZaiYeMian = "index-duohy-zcd.jsp";
	       	 			hyLoad();
	       	 		}else{		//单行业跳转
	       	 			hy_MenuCode=menuList[0].menucode;						
		         		
	       	 			//systemcode=menuList[0].systemcode;
	       	 			hyIndex(hy_MenuCode);
	       	 		}	 	 
			 	}
			 	 	
 			 },"json"); 
	}
	function hyLoad(){
		$("#mainDIV").empty();
		$("#mainDIV").load(shouYeJiaZaiYeMian);
		$("#mainDIV").show("slow");
	}
	//单行业加载首页
	function hyIndex(menuCode){
		hy_MenuCode  = menuCode;
		if(menuCode=="xtgl_g"){//系统管理
			shouYeJiaZaiYeMian = "index-xtgl.jsp";
		}else if(menuCode=="gad-glpt"){//日常管理
			shouYeJiaZaiYeMian = "index-rcgl.jsp";
		}else if(menuCode=="gad-lvguany"){//旅馆行业
			shouYeJiaZaiYeMian = "index-lgy.jsp";
		}else if(menuCode=="gad-yuley"||menuCode=="qyd-yuleye"||menuCode=="zkdbzh"||menuCode=="bzh_cjd"){//娱乐行业
			shouYeJiaZaiYeMian = "index-yly.jsp";
		}else if(menuCode=="gad-jxy"||menuCode=="qyd-jixiuy"){//机修行业
			shouYeJiaZaiYeMian = "index-jxy.jsp";
		}else if(menuCode=="gad-ddy"||menuCode=="qyd-ddye"){//典当行业
			shouYeJiaZaiYeMian = "index-ddy.jsp";
		}else if(menuCode=="gad-yzy"||menuCode=="qyd-yzy"){//印章行业
			shouYeJiaZaiYeMian = "index-yzy.jsp";
		}else if(menuCode=="gad-eschy"||menuCode=="qyd-eschy"){//旧机动车交易行业
			shouYeJiaZaiYeMian = "index-esc.jsp";
		}else if(menuCode=="gad-esjhy"||menuCode=="qyd-esjy"){//旧移动电话交易行业
			shouYeJiaZaiYeMian = "index-esj.jsp";
		}else if(menuCode=="gad-qcczhy" || menuCode=="qyd-qcczy"){//出租汽车行业
			shouYeJiaZaiYeMian = "index-czc.jsp";
		}else if(menuCode=="gad-qczlhy" || menuCode=="qyd-qczlhy"){//汽车租赁行业 
			shouYeJiaZaiYeMian = "index-qczl.jsp";
		}else if(menuCode=="gad-czzfhy"||menuCode=="qyd-czfwy"){//出租房屋行业
			shouYeJiaZaiYeMian = "index-czfhy.jsp";
		}else if(menuCode=="gad-fjjshy"||menuCode=="qyd-fjjsy"){//废旧金属行业
			shouYeJiaZaiYeMian = "index-fjjs.jsp";
		}else if(menuCode=="gad-zddw"||menuCode=="qyd-zddw"||menuCode=="nbdw"){//重点单位
			shouYeJiaZaiYeMian = "index-nbdw.jsp";
		}else if(menuCode=="gad-jdhxphy" || menuCode=="jdhxphy-qyd"){//剧毒化学品行业
			shouYeJiaZaiYeMian = "index-jdhxp.jsp";
		}else if(menuCode=="gad-jfgl" || menuCode=="qyd-jfgl"){//积分管理
			shouYeJiaZaiYeMian = "index-jfgl.jsp";
		}else if(menuCode=="gad-wtjmguanl"||menuCode=="qyd-wtjmy"){//委托寄卖业
			shouYeJiaZaiYeMian = "index-wtjm.jsp";
		}else if(menuCode=="gad-ba"){//保安
			shouYeJiaZaiYeMian = "index-ba.jsp";
		}else if(menuCode=="gad-jdccj" || menuCode =="qyd-jdccj"){//机动车拆解
			shouYeJiaZaiYeMian = "index-jdccj.jsp";
		}else if(menuCode=="mjjczxt"){//民警检查证制卡端
			shouYeJiaZaiYeMian = "index-mjjcz.jsp";
		}else if(menuCode=="tjfx_glpt" ){//统计分析
			shouYeJiaZaiYeMian = "index-tjfx.jsp";
		}else if(menuCode=="cjd" ){//采集点
			shouYeJiaZaiYeMian = "index-cjd.jsp";
		}else if(menuCode=="zkd" ){//制卡端
			shouYeJiaZaiYeMian = "index-zkd.jsp";
		}else if(menuCode=="zcd"){//技术支持单
			shouYeJiaZaiYeMian="business/techSupport/index.jsp";
		}
		else{
			shouYeJiaZaiYeMian="index-other.jsp";
		}
		hyLoad();
	}
	
	//
	function jiaZaiShouYeYeMian(){
		//$("#password_modify").empty();
	 	$("#iframes").empty();
	 	if(shouYeJiaZaiYeMian!=null && shouYeJiaZaiYeMian!=""){
	 		$("#iframes").load(shouYeJiaZaiYeMian);
	 	}
		$("#iframes").show("slow");
		$("#iframes").width("1020");
	}

	//生成顶级菜单
	function setMenu(menuCode){
		var paramsObj = {userid:'<%=userid%>',usertype:'<%=usertype%>'};
		if(isDhyTag>1){//如果是单行业menuCode无效
			jQuery.extend(paramsObj,{fullcodelike:menuCode});
		}
         $.post(
         	"<%=request.getContextPath()%>/sysadmin/allMenu_menu.action", 
         	paramsObj,
         	 function(result)
         	 {
         	 	$("#menumain").empty();
				$("#menumain").append($(result.treeMenuString));
				$("#menumain").append("<br>");
				//document.getElementById("menumain").innerHTML = result;
				
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
        function loadHyList(){
			//依据menuList(由index.jsp设置)展示行业列表
			var duoHyListHtml = '<tr><td height="5"></td></tr>';
			//var otherHtml = '';
			if(menuList != null){
				var menuLength = menuList.length;
				var oneMenu,oneMenuCode;
				for(var index=0;index<menuLength;index++){
					oneMenu = menuList[index];
					oneMenuCode = oneMenu.menucode;
					if(oneMenuCode!="gad-mjjcz"){
						duoHyListHtml +='<tr><td bgcolor="#e9f6fe" align="left"><img src="images/tcjt.jpg" width="11" height="11" /><a href="#" class="btsmallfont" onclick="hyIndex(\''+oneMenuCode+'\')">'+oneMenu.menuname+'</a></td></tr>'
					}
					
				}
        	}
        	$("#hyListTable").html(duoHyListHtml);
        }
        
        //跳转菜单列表距离跳转按钮的top和left值
        function loadHyDiv(topnum,leftnum){
			var yongHuXxDiv = $("#hyTzListDiv");
			var offset = $("#tz_login_button").position();
			yongHuXxDiv.css({
				top:offset.top+topnum,
				left:offset.left+leftnum
			});
		}
	
        //跳转按钮：多行业首页重新加载其他行业
        function reloadHyIndex(topnum,leftnum,aTagid,imgid,sy_aTagid,sy_imgid,modifypassword,pwd_img){
        	if(aTagid==null){
        		aTagid="tz_login_button";	
        	}
        	if(imgid==null){
        		imgid="tz_login_img";
        	}
        	if(sy_aTagid==null){
        		sy_aTagid="login";
        	}
        	if(sy_imgid==null){
        		sy_imgid="login_img";
        	}
        	if(modifypassword==null){
        		modifypassword="modifypassword";
        	}
        	if(pwd_img==null){
        		pwd_img="pwd_img";
        	}
        	if(isDhyTag>1){//如果是单行业menuCode无效
        		$("#"+modifypassword).remove();	
        		$("#"+pwd_img).remove();
        		var sourceDivObj = $("#"+aTagid);
	        	var divHtml = '<div id="hyTzListDiv" style="position:absolute;z-index:9999;">';
	        	divHtml += '<table id="hyListTable"  width="150" border="0" cellpadding="3" cellspacing="0" style="border:1px #6e9cbe solid">';
				divHtml += '</table></div>';
				sourceDivObj.append(divHtml);
				loadHyDiv(topnum,leftnum);
        		$("#"+aTagid).hover(function(){
        			loadHyList();
        			$("#hyTzListDiv").show();
        		},function(){
        			$("#hyTzListDiv").hide();
        		});
        	}else{
            	cachuli(modifypassword,pwd_img);
            	
        		$("#"+aTagid).hide();
        		$("#"+imgid).hide();
        		$("#"+sy_aTagid).hide();
        		$("#"+sy_imgid).hide();
        	}
        }
        
        //返回首页
        function fnloginSy()
        {
        	$("#mainDIV").empty();
       	 	shouYeJiaZaiYeMian = "index-duohy.jsp";
			hyLoad();
			clearTimeout(testtime); //// 清空setTimeout现成	
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
   		$("#loginNum").empty();
		$("#loginSum").empty();
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
        var usertype = "<%=usertype%>";
        var ssdwbm = "<%=user.getSsdwbm()%>";
        var usertypeAttay = usertype.split(",");
        if (ssdwbm == "" || ssdwbm == "null" || ssdwbm == null) {
            //公安段
            if(usertype=='14'){
                $("#help").attr("href", "help/Ylygad_help.jsp");
			}else{
				$("#help").attr("href", "help/help_gad.jsp");
			}
                if(usertype == "11" || usertype == "12"){//制卡和采集
                	$("#help").attr("href", "help/Nohelp.jsp");
                }
        }
        else {
            //企业的
            //属于两个企业的用户
            if ((usertypeAttay.length) * 1 > 1) {
                $("#help").attr("href", "help/help_qyd.jsp");
            }
            else {
                //属于一个企业的用户
                if (usertype == "13" || usertype == "14"||usertype== "143" || usertype== "144" ) {//娱乐业
                    //$("#help").attr("href", "help/help_qyd_yly.html");
                    if(usertype=='14'){
                    	$("#help").attr("href", "help/Ylygad_help.jsp");
					}else{
						$("#help").attr("href", "help/Ylyqyd_help.jsp");
					}
                }
               
                if (usertype == "24") {//旅馆业
                    $("#help").attr("href", "help/help_qyd_lgy.html");
                }
                if (usertype == "42" || usertype == "43" || usertype == "44") {//机修业
                    $("#help").attr("href", "help/help_qyd_jxy.html");
                }
                if (usertype == "72" || usertype == "73" || usertype == "74") {//二手机
                    $("#help").attr("href", "help/help_qyd_esj.html");
                }
                if (usertype == "51" || usertype == "52" || usertype == "53") {//印章业
                    $("#help").attr("href", "help/help_qyd_yzy.html");
                }
                if (usertype == "92" || usertype == "93" || usertype == "94") {//出租车
                    $("#help").attr("href", "help/help_qyd_czc.html");
                }
                if (usertype == "112" || usertype == "113" || usertype == "114") {//剧毒化学品
                    $("#help").attr("href", "help/help_qyd_jdhxp.html");
                }
                if (usertype == "91") {//出租屋
                    $("#help").attr("href", "help/help_qyd_czfw.html");
                }
                if (usertype == "32" || usertype == "33" || usertype == "34") {//典当业
                    $("#help").attr("href", "help/help_qyd_ddy.html");
                }
                if (usertype == "62" || usertype == "63" || usertype == "64") {//旧机动车
                    $("#help").attr("href", "help/help_qyd_esc.html");
                }
                if (usertype == "102" || usertype == "103" || usertype == "104") {//汽车租赁
                    $("#help").attr("href", "help/help_qyd_qczl.html");
                }
                if (usertype == "82" || usertype == "83" || usertype == "84") {//废旧金属
                    $("#help").attr("href", "help/help_qyd_fjjs.html");
                }
                if (usertype == "121" || usertype == "122") {//重点单位
                    $("#help").attr("href", "help/help_qyd_zddw.html");
                }
            }
        }
    }
    
    var shouquanMes = '<%=shouquanEndDate %>'; //客服校验返回信息
	if(shouquanMes!=''){
		jAlert(''+shouquanMes,'提示'); //如果不需要校验,此信息不会提示。不会影响其他功能。
	}
</script>
<body> 
<input type="hidden" id="b_useraccount" value="<%=useraccount%>"/>
<table width="1020" border="0"  align="center" cellpadding="0" cellspacing="0">
	<tr><td><div id="mainDIV"></div></td></tr>
</table>
<div id="hyTzListDiv" style="position:absolute;">
<table id="hyListTable"  width="150" border="0" cellpadding="3" cellspacing="0" style="border:1px #6e9cbe solid">
</table>
</div>
<div id="apDiv1"><embed name="music" src="sound/call.wav" autostart="false" loop="true" hidden="true"><!-- 报警音乐 --></div>
<div id="man_help" class="page-layout" src="#" style="top:180px; left:300px;display:none;width:600px;">
</body>
</html>
