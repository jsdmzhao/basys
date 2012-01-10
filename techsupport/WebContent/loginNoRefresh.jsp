<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.aisino2.common.IpMac" %>

<%@ page import="com.jit.attr.JitAcComp"%>
<%@ page import="com.jit.attr.GenGACode"%>
<%@page import="java.security.cert.X509Certificate,java.util.Vector,com.jit.attr.GAACInfo"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	IpMac ipmac = new IpMac();
    String ip = "";
    ip =ipmac.getIpAddr(request);
    String mac="";
	mac= ipmac.getMACAddress(ip);
	//if("read MAC error!".equals(mac))
	//	mac= "";
	////oa证书
	String sfzh = "";  ///身份证号
	String certsflag = "1"; ///是否获得证书的标识 1为有证书  0为没有证书
	
	try{
		X509Certificate[] certs=(X509Certificate[])request.getAttribute("javax.servlet.request.X509Certificate");
		
		if(certs==null){
			//out.println("错误！请提交证书！");
			certsflag = "0";
			//return;
		}else{
		
		X509Certificate gaX509Cert=null;
		gaX509Cert=certs[0];
		
		//获取机构代码
		GenGACode ga = new GenGACode();
		ga.setx509(gaX509Cert);
		ga.parserDN();
		String code = ga.getgaxS() + ga.getgaxLCity() + ga.getgaxLCounty() +
		ga.getgaxOU78() + ga.getgaxOU9a() + ga.getgaxOUbc();
		
		//out.print("code---" + code);
		String[] userinfo = ga.getSubjectDN().split(",");
		
		String u = userinfo[0];
        if (u.split("=")[0].toLowerCase().equals("cn")){
				//out.print(" 用户信息："+u.split("=")[1]);
				//response.sendRedirect("clientindex.html");
				String[] us = u.split("=")[1].split(" ");
				String username = us[0];
				sfzh = us[1];           		
		}
	  }
	}
	catch(Exception e){
		out.print("错误！"+e.getMessage());//－－此处即为获取并显示统一提示信息的方法。
	}

%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<script type="text/javascript">
//$.ajax()方式
var sfzh = "";  ////从证书中读到的身份证号
var certsflag = "0"; //是否获得证书的标识 1为有证书  0为没有证书

var userAcc; ///用户名
var userPass; //密码

$(document).ready(function (){
	$("#p_useraccount").focus();
   	$('#sendajax').click(function (){ //直接把onclick事件写在了JS中，而不需要混在XHTML中
   		if(certsflag=="1"){
   		var sfz18;
   		var sfz15;
   		if(sfzh.length=="18"){ ///读取的身份证是18位
   		  sfz18 = sfzh;
   		  sfz15 = isIdCardNo15(sfzh);
   		}else if(sfzh.length=="15"){ ////读取的身份证是15为
   		  sfz15 = sfzh;
   		  sfz18 = isIdCardNo(sfzh);
   		}
   		
   		 var params1 = {idnum:sfz18,idnum15:sfz15};
		 jQuery.ajax({
				type: 'POST',
				url: "sysadmin/queryUserlogin_user.action",
				data: params1,
				async: true,
				dataType: 'json',
				success: function(json){
				    var userAccP =  json.userAccP;
				    var sUrl="sysadmin/login_login.action";
				    if(userAccP==null){
				       
				       userAcc = "adminview";
				       userPass = "";//hex_md5("1");
				       sUrl = "sysadmin/loginNoPassword_login.action";
				    }else{
				       var uap = userAccP.split("||");
				       userAcc = uap[0];
				       userPass = uap[1];
				    }
				    
				    $("#p_useraccount").val(userAcc);
				    $("#p_password").val(userPass);
				    setParams("p_");
          			
          			jQuery.ajax({
						type: 'POST',
						url: sUrl,
						data: params,
						async: true,
						dataType: 'json',
						success: update_page
					});
				}
				
		 });
   		
   		}else if(certsflag=="0"){
   	      ///////没有证书的情况
   	 	  if (checkControlValue("p_useraccount","String",1,20,null,1,"没有提交证书，用户名") && checkControlValue("t_password","String",1,100,null,1,"没有提交证书，密码")){	
          		//hash = hex_md5(#("p_password"));
          		//alert(hex_md5($("#t_password").val()));
          		$("#p_password").val(hex_md5($("#t_password").val()));
          		//alert($("#p_password").val());
          		setParams("p_");
          		var sUrl="sysadmin/login_login.action";
          		jQuery.ajax({
					type: 'POST',
					url: sUrl,
					data: params,
					async: true,
					dataType: 'json',
					success: update_page
				});
          }	
       }	
	});
	pageWidth=document.body.clientWidth;
	pageHeight=document.body.clientHeight;
	
	/////证书部分
	//sfzh = "110102198506020018";
	//certsflag = "1";
	
	sfzh = "<%=sfzh%>";
	certsflag = "<%=certsflag%>";
	
});


function update_page (json) { //回传函数实体，参数为XMLhttpRequest.responseText
      if (json.result=="success"){
		$("#wangZhaKongZhi_login").remove();
		$("#jquery-wangZhaZhuangTai").remove();
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
</script>
</head>
<body style="padding-top:90px" bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" scroll="no" >
<!-- ImageReady Slices  -->
<div align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="left" class="title1">系统登录</td>
      <td><a href="#" id="closeDiv" onclick='$("#wangZhaKongZhi_login").hide("show");'  class="close"></a></td>
    </tr>
     <tr>
      <td align="left"></td>
      <td></td>
    </tr>
</table>	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="3"></td>
		</tr>
	</table></div>
	<div align="center">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td>
        <table border="0" cellspacing="0" cellpadding="0">
          <tr><td class="red">用户名</td>
            <td valign="top"><label>
              <input  type="text" class="logininput" name="p_useraccount" id="p_useraccount" />
            </label></td>
          </tr>
          <tr><td class="red">密码</td>
            <td> 
            <input name="t_password" id="t_password" type="password" class="logininput" onkeypress="fnkeypress();"/>
            <input name="p_password" id="p_password" type="hidden"/></td>
          </tr>
          <tr>
            <td>
            	<input  type="hidden" class="logininput" name="p_loginip" id="p_loginip" value="<%=ip %>"/>
            	<input  type="hidden" class="logininput" name="p_loginmac" id="p_loginmac"  value="<%=mac %>"/>
            </td>
          </tr>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="25%"></td>
          <td width="25%"><a href="#" class="loginbotton"  id="sendajax">确认</a></td>
          <td width="25%"><a href="#"  class="loginbotton" onclick='fnreset()'>取消</a></td>
          <td width="25%"></td>
        </tr>
      </table></td>
	</tr>
</table>
</div>
</body>
</html>