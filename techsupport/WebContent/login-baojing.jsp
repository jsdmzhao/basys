<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="<%=request.getContextPath()%>/css/ingrid.css" rel="stylesheet"  type="text/css"/>
<link href="css/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
<script  src="javascript/jquery.js" type="text/javascript"></script>
<script src="javascript/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="javascript/jquery.alerts.js" type="text/javascript"></script>
<script src="javascript/ui.datepicker.js" type="text/javascript" charset="utf-8"></script>	
<script src="javascript/htmlConfig.js" type="text/javascript"></script>
<script src="javascript/md5.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<script type="text/javascript">
var caTag="";//用于AJAX发送请求时，判断登录方式，true为ca登录，这里设置为空即可。

//$.ajax()方式
$(document).ready(function (){
	$("#p_useraccount").focus();
   	$('#sendajax').click(function (){ //直接把onclick事件写在了JS中，而不需要混在XHTML中了
   	 	  if (checkControlValue("p_useraccount","String",1,20,null,1,"帐号") && checkControlValue("t_password","String",1,100,null,1,"密码")){	
          		$("#p_password").val(hex_md5($("#t_password").val()));
          		setParams("p_");
          		var sUrl="sysadmin/login_login.action";
          		$("#div_login").show(); //打开 AJAX 等待动画
          		jQuery.ajax({
					type: 'POST',
					url: sUrl,
					data: params,
					async: true,
					dataType: 'json',
					success: update_page,
					complete: function(){
						$("#div_login").hide(); //关闭 AJAX 等待动画
					}
				});
          }		
	});
	pageWidth=document.body.clientWidth;
	pageHeight=document.body.clientHeight;
    $("#div_login").css({
		position: 'absolute',
		zIndex: 99999999,
		padding: 0,
		margin: 0,
		top: (pageHeight/2+20) + 'px',
		left: (pageWidth/2-120) + 'px'
	});
	$("#div_login").hide();
});

function update_page (json) { //回传函数实体，参数为XMLhttpRequest.responseText
		$("#waitTable").css("display","none");
      if (json.result=="baojingsuccess"){
      	window.location="temp-baojing.jsp";//
      }else{
      	jAlert(json.result, '登录信息');
      	$("#p_useraccount").val("");
      	$("#p_password").val("");
      	$("#t_password").val("");
      }
      
}
//光标处于密码框时，按回车时进行登录

function fnkeypress()
{
	if(event.keyCode == 13)
	{
		$('#sendajax').click();
	}
}

//点击取消
function fnreset()
{
	 $("#p_useraccount").val("");
     $("#p_password").val("");
     $("#t_password").val("");
}
//返回首页
        function fnloginSy()
        {
			
        }


</script>
</head>
<body style="padding-top:90px" bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" scroll="no" >
<!-- ImageReady Slices  -->
<input type="hidden" id="p_baojingflag" value="baojingyes" />
<table width="850" height="435" border="0" align="center" cellpadding="0" cellspacing="0" id="__01">
<tr>
		<td colspan="2">
			<img src="images/login_011.gif" width="850" height="282" alt=""></td>
  </tr>
	<tr>
		<td rowspan="2">
			<img src="images/login_02.gif" width="607" height="153" alt=""></td>
		<td background="images/login_03.gif" width="243" height="79">
        <table width="217" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="26" valign="top"><label>
              <input  type="text" class="logininput" name="p_useraccount" id="p_useraccount" />
            </label></td>
          </tr>
          <tr>
            <td height="25"> 
            <input name="t_password" id="t_password" type="password" class="logininput" onkeypress="fnkeypress();"/>
            <input name="p_password" id="p_password" type="hidden"/></td>
          </tr>
          <tr>
            <td  height="6"></td>
          </tr>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="30%"></td>
          <td width="30%"><a href="#" class="loginbotton"  id="sendajax">确认</a></td>
          <td width="28%"><a href="#"  class="loginbotton" onclick='fnreset()'>取消</a></td>
          <td width="12%"></td>
        </tr>
      </table></td>
	</tr>
	<tr>
		<td>
			<img src="images/login_04.gif" width="243" height="74" alt=""></td>
	</tr>
</table>
<!-- End ImageReady Slices -->
	<div id=div_login style="position:absolute; background:url(images/loadingbg.gif); width:243px; height:55px;font-size:13px; font-weight:bold; color:#666666;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr><td height="17px;"></td></tr>
		<tr><td width="15"></td>
		    <td><img src="images/loading.gif"/></td>
		    <td>登录中，请稍候......</td>
		</tr>
		</table>
	</div>
</body>
</html>