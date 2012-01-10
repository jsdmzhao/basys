<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants;"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	
	String theLoadPage = (String)request.getParameter("theLoadPage");
	if(theLoadPage!=null&&!"".equals(theLoadPage)){
		
	} else {
		theLoadPage = "";
	} %>
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

		<script type="text/javascript" src="javascript/htmlConfig.js"
			charset="utf-8"></script>
		<script type="text/javascript" src="javascript/jquery.ingrid-0.9.2.js"></script>
		<!-- to have Ingrid save her state (selected rows, page number, column sort & direction); just include the jQ cookie plugin -->
		<script type="text/javascript" src="javascript/jquery.cookie.js"></script>
		<script src="javascript/ui.datepicker.js" type="text/javascript"
			charset="utf-8"></script>
		<script src="javascript/DateTimeMask.js" type="text/javascript"
			charset="utf-8"></script>
		<link rel="stylesheet" href="css/site.css" type="text/css" />
		<link rel="stylesheet" href="css/ingrid.css" type="text/css" />
		<link rel="stylesheet" href="css/style.css" type="text/css" />
		<link rel="stylesheet" href="css/ui.datepicker.css" type="text/css"
			media="screen" title="core css file" charset="utf-8" />
</head>
<script type="text/javascript">
	$(document).ready(function (){
		pageWidth=document.body.clientWidth;
		pageHeight=document.body.clientHeight;
		
		var theLoadPage = '<%=theLoadPage %>';
		$("#iframes").empty();
		$("#iframes").load(theLoadPage);
		$("#iframes").show("slow");
		
		$("#div_login").css({
			position: 'absolute',
			zIndex: 99999999,
			padding: 0,
			margin: 0,
			top: (pageHeight/2-25) + 'px',
			left: (pageWidth/2-122) + 'px'
		});
		$("#div_login").hide();
	});
</script>
<body scroll="no">
	<input type="hidden" id="offineFlag" value="1"/>
	<div id="iframes" style="top: 150px; background-color: #FFFFFF; padding: 0px">
	</div>
	
	<div id=div_login style="position:absolute; background:url(images/loadingbg.gif); width:243px; height:55px;font-size:13px; font-weight:bold; color:#666666;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr><td height="17px;"></td></tr>
		<tr><td width="15"></td>
		    <td><img src="images/loading.gif"/></td>
		    <td>加载中，请稍候......</td>
		</tr>
		</table>
	</div>
</body>
</html>

