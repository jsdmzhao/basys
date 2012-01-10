<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ page import="cn.cwca.cert.*"%>
<%@ page import="java.security.cert.X509Certificate"%>
<%@ page import="cn.cwca.bidding.*"%>
<%@include file="/public/includeCa.jsp" %>
<%@ page import="com.aisino2.sysadmin.Constants" %>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%!
	 /**
     * 根据证书DN取出
     * @param subject String 主题
	 * @param subject dn 所要取的项名称
     * @return String
     */
    private String getNsrsbhFromDN(String subject,String dn) {
        String nsrsbh = "";
        String[] sdn = subject.split(",");
        for (int ii = 0; ii < sdn.length; ii++) {
            String[] stmp = (sdn[ii]).split("=");
            if ((stmp[0].trim()).equalsIgnoreCase(dn)) {
                nsrsbh = (stmp[1]).trim();
                return nsrsbh;
            }
        }
        return nsrsbh;
    }
%>
<%
	String sfzh = "";  ///身份证号
	String certsflag = "1"; ///是否获得证书的标识 1为有证书  0为没有证书
	String myinfo = null;   ///证书有效性 验证标识   1为验证通过   0 为验证未通过
	String path = request.getContextPath();
	String logonURL = "http://"+request.getServerName()+":"+"9090"+path+"/login.jsp?errorMessage=";
	String message = "正在验证证书...";
	CertManager certManager =new CertManager();
	Ocsp ocsp = new Ocsp();
	Crl crl = new Crl();
	try{
		X509Certificate[] cert = (X509Certificate[])request.getAttribute("javax.servlet.request.X509Certificate");
		if(cert==null){
			//out.println("错误！请提交证书！");
			certsflag = "0";
			 response.sendRedirect(logonURL+"8");
			//return;
		}else{
		    //设置根证书地址
			String version_aisinoZS = "";
			Globalpar glo_aisinoZS = new Globalpar();
			Globalpar temp_aisinoZS = null;
			List globList_aisinoZS = null;
			
			glo_aisinoZS.setGlobalparcode("aisinoZS_dz"); //base64-bbh 版本号
			globList_aisinoZS = CacheManager.getCacheGlobalpar(glo_aisinoZS);
			if(globList_aisinoZS!=null&&globList_aisinoZS.size()>0){
				temp_aisinoZS = (Globalpar)globList_aisinoZS.get(0);
				version_aisinoZS = temp_aisinoZS.getGlobalparvalue();	
			}
			String CRLpath=version_aisinoZS;
			//String path=application.getRealPath(request.getRequestURI());
			//String path1 = path+"\\NXCA.cer";
			//设置证书验证
			//CRLpath=CRLpath+"\\crl.crl";
			String subject=certManager.getSubject(cert[0]);
			String crlState = crl.crlOnly(cert[0],CRLpath);  /////crl验证
			if("1".equals(crlState)){ /// 未通过验证
	          	response.sendRedirect(logonURL+"0");
	          return;
			
			}else if("0".equals(crlState)){
			    sfzh = this.getNsrsbhFromDN(subject,"O"); ///身份证号
			}
	    }
	}catch(Exception e){
		//out.print("错误！"+e.getMessage());//－－此处即为获取并显示统一提示信息的方法。
        response.sendRedirect(logonURL+"1");
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
var reurl="<%=logonURL%>";
var message="";
var userAcc; ///用户名
var userPass; //密码
var ukeyid;
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
	sfzh = "<%=sfzh%>";
	certsflag = "<%=certsflag%>";
	ukeyid = CACertification.GetSN();
	if(ukeyid!=""){
		checkUkeyid();
	}else{
		window.location=reurl+"2";
	}
});
//验证ukey是否被登记
function checkUkeyid(){
	jQuery.ajax({
		type: 'POST',
		url: "ukey/querydl_ukey.action",
		data: {ukeyid:ukeyid},
		async: true,
		dataType: 'json',
		success: function (json){
		   if(json.ukeyid=="0"){ //未注册的
			       window.location=reurl+"3";
		   }else{///ukeyid 已注册   登录
			   var useraccount=json.ukey.useraccount;
			   var password=json.ukey.password;
			   denglu(useraccount,password);
		   }
		 }
	 });
}
/////登陆函数
function  denglu(userAcc,userPass){
	$("#p_useraccount").val(userAcc);
    $("#p_password").val(userPass);
    var sUrl="sysadmin/login_login.action";
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
//成功登录后的返回函数
function update_page (json) { //回传函数实体，参数为XMLhttpRequest.responseText
		$("#waitTable").css("display","none");
      if (json.result=="success"){
    	  var usertype=setNull(json.usertype);
  	 		var reurl="<%=logonURL%>";
    		if(usertype==""){
    			window.location=reurl+"7";
        	}else if(usertype.indexOf("114")!=-1){
			 	window.location=reurl+"7";
	 		}else{
	 			//window.location="index1.jsp";//分批加载菜单
	      		window.location="temp-index.jsp";//一次取出所有菜单
	 		}
      }else{
      	jAlert(json.result, '登录信息');
      	$("#p_useraccount").val("");
      	$("#p_password").val("");
      	//$("#t_password").val("");
      }
}
</script>
</head>
<body style="padding-top:90px" bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" scroll="no" >
<!-- ImageReady Slices  -->
<input  type="hidden" class="logininput" name="p_loginip" id="p_loginip"/>
<input  type="hidden" class="logininput" name="p_loginmac" id="p_loginmac"/>
<input name="p_password" id="p_password" type="hidden"/>
<input name="p_useraccount" id="p_useraccount" type="hidden"/>
<!-- End ImageReady Slices -->
	<div id=div_login style="position:absolute; background:url(images/loadingbg.gif); width:243px; height:55px;font-size:13px; font-weight:bold; color:#666666;display: none;">
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