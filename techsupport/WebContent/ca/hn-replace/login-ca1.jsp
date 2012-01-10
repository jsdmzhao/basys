<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page import="com.jit.attr.JitAcComp"%>
<%@ page import="com.jit.attr.GenGACode"%>
<%@page import="java.security.cert.X509Certificate,java.util.Vector,com.jit.attr.GAACInfo"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String sfzh = "";  ///身份证号
	String certsflag = "1"; ///是否获得证书的标识 1为有证书  0为没有证书
	String myinfo = null;   ///证书有效性 验证标识   1为验证通过   0 为验证未通过
	
	try{
		X509Certificate[] certs=(X509Certificate[])request.getAttribute("javax.servlet.request.X509Certificate");
		if(certs==null){
			//out.println("错误！请提交证书！");
			certsflag = "0";
			//return;
		}else{
			
		   X509Certificate gaX509Cert=null;
		   gaX509Cert=certs[0];
			
			////pki 验证
		   com.jit.attr.JitAcComp jitaccomp = new com.jit.attr.JitAcComp();
		   jitaccomp.setBaseDN("c=cn");
		   jitaccomp.setBaseDN("c=cn");
	       jitaccomp.setPrivilegeSetType(0);
	       jitaccomp.setPKICertificate(gaX509Cert);
	      
	       //客户端IP获取及设置审计参数,不设定则不执行审计操作。
	       String ip = request.getRemoteAddr();
	       jitaccomp.setClientIP(ip);
	       jitaccomp.setAuditParameter("10.56.7.5", "3000");  //审计信息的ip地址 和端口       
	       jitaccomp.setParameter("10.56.7.2", "389");//PKI的LDAP服务器IP、端口。
	       jitaccomp.isCheckCRL(true);                                //Crl验证
	       jitaccomp.isCheckCertPath(true);                           //证书链验证
	       myinfo = jitaccomp.getPrivilegeList("10.56.7.3","389","03200","410000"); //PMI的ip地址 端口号 应用码  本地吗
	       
	       if("0".equals(myinfo)){ /// 未通过验证
	       %>
	         <script type="text/javascript">
	           jAlert("证书验证结果不正确!", '登录信息');
	         </script>
	       <%
	          response.sendRedirect("login.jsp");
	          return;
	       }else if("1".equals(myinfo)){///通过验证
			
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
				sfzh = us[1].trim();
	                 		
			}
		 }
	  }
	
	}
	catch(Exception e){
		out.print("错误！"+e.getMessage());//－－此处即为获取并显示统一提示信息的方法。
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

var sfzh = "";  ////从证书中读到的身份证号
var certsflag = "0"; //是否获得证书的标识 1为有证书  0为没有证书

var userAcc; ///用户名
var userPass; //密码

$(document).ready(function (){
	
   
   
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
	
	denglu();
	
});

/////登陆函数
function  denglu(){

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
				    if(userAccP==null){ /////zheng
				       
				       //userAcc = "adminview";
				       //userPass = "";//hex_md5("1");
				       //sUrl = "sysadmin/loginNoPassword_login.action";
				       jAlert("系统中不存在该证书人员相应的 用户!", '登录信息');
				       window.opener=null;            //返回登录页面
        		       window.open("login.jsp");
				       window.close();
				    }else{
				       var uap = userAccP.split("||");
				       userAcc = uap[0];
				       userPass = uap[1];
				    }
				    
				    $("#p_useraccount").val(userAcc);
				    $("#p_password").val(userPass);
				    setParams("p_");
          			
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
   		
   	   }else if(certsflag=="0"){
   		
       }


}

function update_page (json) { //回传函数实体，参数为XMLhttpRequest.responseText
		$("#waitTable").css("display","none");
      if (json.result=="success"){
      	//window.location="index1.jsp";//分批加载菜单
      	window.location="temp-index.jsp";//一次取出所有菜单
      }else{
      	jAlert(json.result, '登录信息');
      	$("#p_useraccount").val("");
      	$("#p_password").val("");
      	//$("#t_password").val("");
      }
      
}

</script>
<!-- 获得ip地址和mac地址，采用浏览器自带ActiveX控件 start  -->
<OBJECT id=locator classid=CLSID:76A64158-CB41-11D1-8B02-00600806D9B6 VIEWASTEXT></OBJECT>
<OBJECT id=foo classid=CLSID:75718C9A-F029-11d1-A1AC-00C04FB6C223></OBJECT>
<SCRIPT language=JScript>
   var service = locator.ConnectServer();
   var MACAddr ;
   var IPAddr ;
   service.Security_.ImpersonationLevel=3;
   service.InstancesOfAsync(foo, 'Win32_NetworkAdapterConfiguration');
</SCRIPT>
<SCRIPT language=JScript event=OnObjectReady(objObject,objAsyncContext) for=foo>
   if(objObject.IPEnabled != null && objObject.IPEnabled != "undefined" && objObject.IPEnabled == true)
   {
	    if(objObject.MACAddress != null && objObject.MACAddress != "undefined")
	    {
	    	MACAddr = objObject.MACAddress;
	    	if(MACAddr==null)
	    		MACAddr = "";
	    	$("#p_loginmac").val(MACAddr);
	    }
	    if(objObject.IPEnabled && objObject.IPAddress(0) != null && objObject.IPAddress(0) != "undefined")
	    {
	    	IPAddr = objObject.IPAddress(0);
	    	if(IPAddr==null)
	    		IPAddr = "";
	    	$("#p_loginip").val(IPAddr);
	    }
    }
</SCRIPT>
<!-- 获得ip地址和mac地址，采用浏览器自带ActiveX控件 end  -->
</head>
<body style="padding-top:90px" bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" scroll="no" >
<!-- ImageReady Slices  -->
<input  type="hidden" class="logininput" name="p_loginip" id="p_loginip"/>
<input  type="hidden" class="logininput" name="p_loginmac" id="p_loginmac"/>
<input name="p_password" id="p_password" type="hidden"/>
<input name="p_useraccount" id="p_useraccount" type="hidden"/>

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