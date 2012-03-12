<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.jit.attr.JitAcComp"%>
<%@ page import="com.jit.attr.GenGACode"%>
<%@page import="java.security.cert.X509Certificate,java.util.Vector,com.jit.attr.GAACInfo"%>
<%@page import="com.ibatis.common.resources.Resources"%>

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

<html>
<head>
<title>技术支持单流转系统登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
<!--
.STYLE1 {color: #FFFFFF}
-->
</style>
<link href="css/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
<script  src="javascript/jquery.js" type="text/javascript"></script>
<script src="javascript/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="javascript/jquery.alerts.js" type="text/javascript"></script>
<script src="javascript/ui.datepicker.js" type="text/javascript" charset="utf-8"></script>	
<script src="javascript/htmlConfig.js" type="text/javascript"></script>
<script src="javascript/md5.js" type="text/javascript"></script>
<script src="javascript/valdate.js" type="text/javascript"></script>	
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
   	 	  if (verify()){	
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
      	$("#errorText").text('');
      	window.location="temp-index.jsp";//一次取出所有菜单
      }else{
      	$("#errorText").text(json.result);
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

function verify(){
	if(!$('#p_useraccount').val())
	{
		$('#p_useraccount').focus();
		$('#errorText').text("用户名必填");
		return false;
	}

	if(!$('#t_password').val())
	{
		$('#t_password').focus();
		$('#errorText').text("密码必填");
		return false;
	}
	return true;
}
</script>

</head>
<body  leftmargin="0" topmargin="198" marginwidth="0" marginheight="0" style=" background: url(images/login_bg.jpg); ">
<input  type="hidden" class="logininput" name="p_loginip" id="p_loginip"/>
<input  type="hidden" class="logininput" name="p_loginmac" id="p_loginmac"/>
<!-- Save for Web Slices (login.psd) -->
<table   width="595" height="329" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr>
	  <td align="center"   background="images/login_04.jpg" style="background-repeat:no-repeat"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="132" colspan="2">&nbsp;</td>
        </tr>
        <tr>
          <td width="89%"><table width="261" border="0" align="right" cellpadding="0" cellspacing="0">
            <tr>
              <td width="275" height="35" align="right" valign="top" style="font-size:12px; color:#146da5; line-height:180%"><label for="textfield"></label>
                  <span class="STYLE1">用户名：                  </span>
                  <input  type="text" style="border:1px solid #b8d4e0; height:20px;width: 150px" name="p_useraccount" id="p_useraccount" onkeypress="fnkeyToPass()"/>
              </td>
            </tr>
            <tr>
              <td align="right" style="font-size:12px; color:#146da5; line-height:180%"><span class="STYLE1">密码：</span>
                <input name="t_password" id="t_password" type="password" style="border:1px solid #b8d4e0; height:20px;width: 150px" onkeypress="fnkeypress();"/>
                  <input name="p_password" id="p_password" type="hidden"/>              </td>
            </tr>
            <tr>
              <td align="right" style="font-size:12px; color:#146da5; line-height:150%;color: red;" id="errorText">&nbsp;</td>
            </tr>
            <tr>
              <td align="right" style="font-size:12px; color:#146da5; line-height:150%"><table width="64" border="0" cellspacing="0" cellpadding="3">
                  <tr>
                    <td><img src="images/loginbutton_03.jpg" alt="登录" width="64" height="23" id="sendajax" style="cursor:hand"></td>
                  </tr>
              </table></td>
            </tr>
          </table></td>
          <td width="11%">&nbsp;</td>
        </tr>
      </table></td>
  </tr>
</table>
<div id=div_login style="position:absolute; background:url(images/loadingbg.gif); width:243px; height:55px;font-size:13px; font-weight:bold; color:#666666;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr><td height="17px;"></td></tr>
		<tr><td width="15"></td>
		    <td><img src="images/loading.gif"/></td>
		    <td>登录中，请稍候......</td>
		</tr>
		</table>
	</div>
<!-- End Save for Web Slices -->
</body>
</html>
