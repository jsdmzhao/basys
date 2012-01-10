<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page import="com.jit.attr.JitAcComp"%>
<%@ page import="com.jit.attr.GenGACode"%>
<%@page import="java.security.cert.X509Certificate,java.util.Vector,com.jit.attr.GAACInfo"%>
<%@include file="/public/includeCa.jsp" %>
<%@include file="/public/includeCaNr.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<%

        String skhdcsbm=request.getParameter("skhdcsbm");
	    String skhdcsmc=request.getParameter("skhdcsmc");
	   if(skhdcsbm ==null){
	     skhdcsbm="nocsbm";
	     skhdcsmc ="nocsmc";
	   }
	  
	   
	   String path = request.getContextPath(); 
	   String basePath = "https://"+request.getServerName()+":9443"+path+"/login-ca1.jsp"; 
	   String logonURL = "http://"+request.getServerName()+":"+request.getServerPort()+path+"/login.jsp?errorMessage=";
%>

<%
	/**IpMac ipmac = new IpMac();
    String ip = "";
    ip =ipmac.getIpAddr(request);
    String mac="";
	mac= ipmac.getMACAddress(ip);*/
	//if("read MAC error!".equals(mac))
	//	mac= "";
	
	
	////oa证书
	String errMsg = request.getParameter("errorMessage");
  	String errorMsg = "";       
	if(null != errMsg&&errMsg.equals("1")){
	 errorMsg = "错误,请插入证书！";
	}

	if(null != errMsg&&errMsg.equals("2")){
	 errorMsg = "错误,PMI目录服务器操作异常";
	}

	if(null != errMsg&&errMsg.equals("3")){
	 errorMsg = "错误,PKI目录服务器操作异常";
	}

	if(null != errMsg&&errMsg.equals("4")){
	 errorMsg = "错误,方法参数异常";
	}
	if(null != errMsg&&errMsg.equals("5")){
	 errorMsg = "错误,公安证书解析异常";
	}
	if(null != errMsg&&errMsg.equals("6")){
	 errorMsg = "错误,读取本地文件异常！";
	}
	if(null != errMsg&&errMsg.equals("7")){
	 errorMsg = "错误,发送审计信息异常";
	}
	if(null != errMsg&&errMsg.equals("8")){
	 errorMsg = "错误,获取该用户类型的权限出错";
	}
	if(null != errMsg&&errMsg.equals("9")){
	 errorMsg = "错误,证书过期";
	}
	if(null != errMsg&&errMsg.equals("10")){
	 errorMsg = "错误,证书签名无效";
	}
	if(null != errMsg&&errMsg.equals("11")){
	 errorMsg = "错误,证书被注销";
	}
	if(null != errMsg&&errMsg.equals("12")){
	 errorMsg = "错误,其它错误未指明";
	}
	if(null != errMsg&&errMsg.equals("13")){
		 errorMsg = "系统中不存在该证书人员相应的 用户!";
	}
	if(null != errMsg&&errMsg.equals("14")){
		 errorMsg = "非法登录!";
	}
	if(null != errMsg&&errMsg.equals("15")){
		 errorMsg = "非公安用户禁止登录!";
	}
	if(null != errMsg&&errMsg.equals("16")){
		 errorMsg = "未通过证书验证!";
	}
	

	String sfzh = "";  ///身份证号
	String certsflag = "0"; ///是否获得证书的标识 1为有证书  0为没有证书
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
var message="<%=errorMsg%>";
var sfzh = "";  ////从证书中读到的身份证号
var certsflag = "0"; //是否获得证书的标识 1为有证书  0为没有证书

var userAcc; ///用户名
var userPass; //密码
$(document).ready(function (){
	if(message!=""){
		jAlert(message,"CA登录提示信息");
	}
	$("#p_useraccount").focus();
   	$('#sendajax').click(function (){ //直接把onclick事件写在了JS中，而不需要混在XHTML中了
   		if(certsflag=="0"){
	   	      ///////没有证书的情况
	   	 	  if (checkControlValue("p_useraccount","String",1,30,null,1,"用户名") && checkControlValue("t_password","String",1,100,null,1,"密码")){	
	          		//hash = hex_md5(#("p_password"));
	          		//alert(hex_md5($("#t_password").val()));
	          		$("#p_password").val(hex_md5($("#t_password").val()));
	          		//alert($("#p_password").val());
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
	
	
	
	/////证书部分
	//sfzh = "110102198506020018";
	//certsflag = "1";
	
	sfzh = "<%=sfzh%>";
	certsflag = "<%=certsflag%>";
	
});


function update_page (json) { //回传函数实体，参数为XMLhttpRequest.responseText
		$("#waitTable").css("display","none");
      if (json.result=="success"){
    	 	var usertype=setNull(json.usertype);
    	 	var reurl="<%=logonURL%>";
      		if(usertype==""){
      			window.location=reurl+"15";
          	}else if(usertype.indexOf("113")!=-1 || usertype.indexOf("112")!=-1){
  			 	window.location=reurl+"15";
  	 		}else{
  	 			//window.location="index1.jsp";//分批加载菜单
  	      		window.location="temp-index.jsp";//一次取出所有菜单
  	 		}
      }else{
      	jAlert(json.result, '登录信息');
      	$("#p_useraccount").val("");
      	$("#p_password").val("");
      	$("#t_password").val("");
      }
      
}
//光标处于帐号框时，按回车时转到密码框
function fnkeypress1()
{
	if(event.keyCode == 13)
	{
		$('#t_password').focus();
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
//点击CA登录
function fnca()
{
	 //window.location="https://localhost:9443/scpt1/login.jsp";
    window.location="<%=basePath%>";
}

//点击取消
function fnreset()
{
	 $("#p_useraccount").val("");
     $("#p_password").val("");
     $("#t_password").val("");
}

//创建场所编码和场所名称

var sscsbm ="<%=skhdcsbm%>";
var sscs ="<%=skhdcsmc%>";
if(sscsbm!='nocsbm'){
creatSessionForCsbmCsmc(sscsbm,sscs);
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
          <tr>
            <td height="26" valign="top"><label>
              <input  type="text" class="logininput" name="p_useraccount" id="p_useraccount"  onkeypress="fnkeypress1();"/>
            </label></td>
          </tr>
          <tr>
            <td height="25"> 
            <input name="t_password" id="t_password" type="password" class="logininput" onkeypress="fnkeypress();"/>
            <input name="p_password" id="p_password" type="hidden"/></td>
          </tr>
          <tr>
            <td  height="6">
            	<input  type="hidden" class="logininput" name="p_loginip" id="p_loginip"/>
            	<input  type="hidden" class="logininput" name="p_loginmac" id="p_loginmac"/>
            </td>
          </tr>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="%2"></td>
          <td width="28%"><a href="#"  class="loginbotton" onclick='fnca()'>CA登录</a></td>
          <td width="30%"><a href="#" class="loginbotton"  id="sendajax">确定</a></td>
          <td width="28%"><a href="#"  class="loginbotton" onclick='fnreset()'>取消</a></td>
          <td width="22%">&nbsp;</td>
        </tr>
      </table></td>
	</tr>
<tr>
		<td  width="243" height="74" valign="bottom" background="images/login_04.gif" >
			<TABLE>
				<TR><TD width="10PX">&nbsp;</TD><TD style="FONT: 12px Tahoma;">版本号：V1.0(2010.3.10)</TD></TR>
				<TR><TD height="1PX"></TD></TR>
			</TABLE>
		</td>
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