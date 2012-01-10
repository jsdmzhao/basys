<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/public/includeCa.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%

	   String path = request.getContextPath(); 
	   //String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
	   String basePath = "https://"+request.getServerName()+":9443"+path+"/login-ca1.jsp"; 
	   //out.println(basePath);
	   String errMsg = request.getParameter("errorMessage");
	   if(errMsg!=null){
		   if("0".equals(errMsg)){errMsg="证书验证结果不正确!";}
		   else if("1".equals(errMsg)){errMsg="证书解析异常错误!";}
		   else if("2".equals(errMsg)){errMsg="请确认插入USBKEY!";}
		   else if("3".equals(errMsg)){errMsg="该USBKEY未登记或已注销!";}
		   else if("4".equals(errMsg)){errMsg="系统中不存在该证书人员相应的 用户!";}
		   else if("5".equals(errMsg)){errMsg="请正确提交证书！";}
		   else if("6".equals(errMsg)){errMsg="非法登录！";}
		   else if("7".equals(errMsg)){errMsg="非企业端用户禁止登陆！";}
		   else if("8".equals(errMsg)){errMsg="请提交证书！";}
	   }
%>
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
<script src="javascript/valdate.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<script type="text/javascript">
//$.ajax()方式
var message="";
$(document).ready(function (){
	message="<%=errMsg%>";
	if(message!="null"){
		$("#message").text(message);
	}
});

//点击CA登录
function fnca()
{
	 //window.location="https://localhost:9443/scpt1/login.jsp";
    window.location="<%=basePath%>";
}


</script>
</head>
<body style="padding-top:90px" bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" scroll="no" >
<!-- ImageReady Slices  -->
<table width="850" height="435" border="0" align="center" cellpadding="0" cellspacing="0" id="__01">
<tr>
		<td colspan="2">
			<img src="images/login_01.gif" width="850" height="282" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="images/login_02.gif" width="607" height="153" alt=""></td>
		<td background="images/login_03.gif" width="243" height="79">
        <table width="217" border="0" cellspacing="0" cellpadding="0">
        </table>
         <table width="217" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="26" valign="top"><label>
              <span id="message"></span>
            </label></td>
          </tr>
          <tr>
          		<td height="26" valign="top">&nbsp;</td>
          </tr>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="30%"></td>
           <td width="28%"><a href="#"  class="loginbotton" style="width:80px" onclick='fnca()'>证书登录</a></td>
          <td width="12%"></td>
        </tr>
      </table></td>
	</tr>
<tr>
		<td  width="243" height="74" valign="bottom" background="images/login_04.gif" >
			<TABLE>
				<TR><TD width="10PX">&nbsp;</TD><TD style="FONT: 12px Tahoma;">版本号：V1.0(2010.8.10)</TD></TR>
				<TR><TD height="1PX"></TD></TR>
			</TABLE>
		</td>
  </tr>
</table>
<!-- End ImageReady Slices -->
</body>
</html>