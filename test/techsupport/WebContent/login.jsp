<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.jit.attr.JitAcComp"%>
<%@ page import="com.jit.attr.GenGACode"%>
<%@page import="java.security.cert.X509Certificate,java.util.Vector,com.jit.attr.GAACInfo"%>
<%@page import="com.ibatis.common.resources.Resources"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	Properties loginProp = Resources.getResourceAsProperties("DisplayerStrings.properties");
	String loginBbh = loginProp.getProperty("loginBbh"); //登陆页右下角显示版本号内容
	if(loginBbh!=null&&!"".equals(loginBbh)){
		loginBbh = new String(loginBbh.getBytes("ISO8859_1"), "GBK");
	} else {
		loginBbh = "";
	}

	String errMsg = request.getParameter("errorMessage");
	//看 是否session过期掉的这个页面。
    String sessionout=request.getParameter("sessionout");
       if(sessionout==null){
         sessionout="no";
       }
       
        String skhdcsbm=request.getParameter("skhdcsbm");
	    String skhdcsmc=request.getParameter("skhdcsmc");
	    String kjtuichu=request.getParameter("kjtuichu");//从控件中页面上的退出
	    if(kjtuichu==null) kjtuichu="noindex";
	  
	   if(skhdcsbm ==null||skhdcsbm.equals("")){
	     skhdcsbm="nocsbm";
	     skhdcsmc ="nocsmc";
	   }
%>
<%
	/**IpMac ipmac = new IpMac();
    String ip = "";
    ip =ipmac.getIpAddr(request);
    String mac="";
	mac= ipmac.getMACAddress(ip);*/
	//if("read MAC error!".equals(mac))
	//	mac= "";
	
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
<title>社会信息采集平台</title>
<script type="text/javascript">
var sessionout="<%=sessionout%>";
 //如果session过期，直接打开
if(sessionout=='yes'){
     if (skhdcsbmflag == 'null'|| skhdcsbmflag ==''){
            window.location.href='login.jsp';
	 }else{
	      
	    window.location.href='login.jsp?skhdcsbm='+skhdcsbmflag+'&skhdcsmc='+skhdcsmcflag+'&kjtuichu=index';
    }
}
</script>
<script type="text/javascript">
//$.ajax()方式
var userAcc; ///用户名
var userPass; //密码
var caTag="";//用于AJAX发送请求时，判断登录方式，true为ca登录，这里设置为空即可。

$(document).ready(function (){
	$("#loginBbh").html('<%=loginBbh %>');
	$("#p_useraccount").focus();
	<%
	if(errMsg!=null){
		   if("6".equals(errMsg)){
	%>
		jAlert("非法登录！","系统提示信息");
	<%	
		   }
	}
	
	%>
   	$('#sendajax').click(function (){ //直接把onclick事件写在了JS中，而不需要混在XHTML中了
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
      if (json.result=="success"){
      	//window.location="index1.jsp";//分批加载菜单
      	window.location="temp-index.jsp";//一次取出所有菜单
      }else{
      	jAlert(json.result, '登录信息');
      	$("#p_useraccount").val("");
      	$("#p_password").val("");
      	$("#t_password").val("");
      }
      
}

//光标在用户名时，按回车时跳到输入密码处
function fnkeyToPass(){
	if(event.keyCode == 13){
		$("#t_password").focus();
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
     $("#p_useraccount").focus();
}

//创建场所编码和场所名称
var sscsbm ="<%=skhdcsbm%>";
var sscs ="<%=skhdcsmc%>";
var kjtuichu="<%=kjtuichu%>";

if(sscsbm!='nocsbm'){

creatSessionForCsbmCsmc(sscsbm,sscs);
}else{

  if (typeof(skhdcsbmflag) == "undefined" ){
	}else{
      if(skhdcsbmflag!='null'&&skhdcsbmflag!=''){
         sscsbm =skhdcsbmflag;
         sscs = skhdcsmcflag
         kjtuichu ='index';
        //  if(!ff){
            creatSessionForCsbmCsmc(sscsbm,sscs);
           //}
        }
    }
}


//创建场所编码和场所名称的session 用于客户端民警登陆取得客户端得场所编码和场所名称
	  function creatSessionForCsbmCsmc(csbm,csmc){
	      
	      var sUrl="sysadmin/creatSessionForCsbmCsmc_login.action";
	      var aa=3;//0失败，1成功
	     jQuery.ajax({
			type: 'POST',
			url: sUrl,
			data: {csbm:csbm,csmc:csmc,kjtuichu:kjtuichu},
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
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<!-- Save for Web Slices (login1.psd) -->
<input  type="hidden" class="logininput" name="p_loginip" id="p_loginip"/>
<input  type="hidden" class="logininput" name="p_loginmac" id="p_loginmac"/>
<table width="1024" height="640" border="0" align="center" cellpadding="0" cellspacing="0" id="__01">
<tr>
		<td>
			<img src="images/login_01.jpg" width="1024" height="299" alt=""></td>
	</tr>
	<tr>
		<td><table id="__" width="1024" height="254" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="115" valign="top" background="images/login_02_01.jpg"><table width="261" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="275" height="35" align="right" valign="top" style="font-size:12px; color:#146da5; line-height:180%">
                	<label for="textfield"></label>
                	<input  type="text" style="border:1px solid #b8d4e0; height:22px;width: 150px" name="p_useraccount" id="p_useraccount" onkeypress="fnkeyToPass()"/>
                 
                  </td>
              </tr>
              <tr>
                <td align="right" style="font-size:12px; color:#146da5; line-height:180%">
                	<input name="t_password" id="t_password" type="password" style="border:1px solid #b8d4e0; height:22px;width: 150px" onkeypress="fnkeypress();"/>
           			 <input name="p_password" id="p_password" type="hidden"/>
                </td>
              </tr>
              <tr>
                <td align="right" style="font-size:12px; color:#146da5; line-height:180%">&nbsp;</td>
              </tr>
              <tr>
                <td align="right" style="font-size:12px; color:#146da5; line-height:180%"><table width="100" border="0" cellspacing="0" cellpadding="3">
                  <tr>
                    <td><img src="images/loginbutton_03.jpg" alt="登录" width="64" height="23" id="sendajax" style="cursor:hand"></td>
                    <td><img src="images/loginbutton_05.jpg" alt="重置" width="64" height="23" style="cursor:hand" onclick='fnreset()'></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td height="139" valign="top" background="images/login_02_02.jpg" style="background-repeat:no-repeat;"><table width="820" border="0" align="right" cellpadding="0" cellspacing="0">
              <tr>
                <td width="400" align="center" style="font-size:12px; color:#146da5; line-height:180%" id="loginBbh"></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
	</tr>
	<tr>
		<td valign="top" height="87" background="images/login_03.jpg" style="background-repeat:no-repeat;"><table width="372" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="372" align="center" style="font-size:12px; color:#FFFFFF; line-height:160%">
	            航天金盾科技有限公司研制开发<br/>
	            建议使用分辨率1024*768显示 IE6.0或以上版本浏览器
            </td>
          </tr>
        </table></td>
  </tr>
</table>
<!-- End Save for Web Slices -->
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