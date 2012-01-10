<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.*"%>
<%@ page import="com.aisino2.common.QjblUtil" %>
<%
	// 场所编码
	String useraccount = "";
	// base64-bbh 版本号
	String version_aisinoCA = "";
	
	// 取得场所编码
	useraccount = (String)request.getParameter("useraccount");
	// 取得base64-bbh 版本号
	version_aisinoCA = QjblUtil.queryQjblVal("aisinoCA-bbh");
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String nowdate = sdf.format(new Date());

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script  src="javascript/jquery.js" type="text/javascript"></script>
<script src="javascript/jquery.alerts.js" type="text/javascript"></script>
<script src="javascript/htmlConfig.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<script type="text/javascript">
var caTag="";//用于AJAX发送请求时，判断登录方式，true为ca登录，这里设置为空即可。
var nowdate='<%=nowdate%>';
var message='';
var useraccount = '<%=useraccount%>';
var ukeyid;
$(document).ready(function (){
    ukeyid = CACertification.GetSN();
    if(ukeyid != ""){
        $("#p_ukeyid").val(ukeyid);
	    checkUkey();
	}else{
	    message = "请确认插入USBKEY";
	    $("#message").val(message);
	}
});

//验证ukey
function checkUkey(){
	setParams("p_");
	jQuery.ajax({
		type: 'POST',
		url: "ukey/queryUkey_ukey.action",
		data: params,
		async: false,
		dataType: 'json',
		success: update_page,
		complete: function(){
		}
	 });
}

//成功登录后的返回函数
function update_page (json) {
    if(json.result=="success"){
   	    if(json.LUkey[0]==null){
   	        message = "用户不存在或已被注销";
	        $("#message").val(message);
   	    }else{
   	        var qybm = json.LUkey[0].qybm;// 证书所属场所
   	        var zsyxq = json.LUkey[0].zsyxrq;// 证书有效期
   	        
   	        if(useraccount != qybm){
   	            message = "非本企业证书，请使用合法证书";
	            $("#message").val(message);
   	        } else{
   	             // 验证证书有效期
   	            if(zsyxq!=null && zsyxq!=''){
   	                var diff = formatDate(zsyxq.substring(0,10)).getTime()-formatDate(nowdate).getTime();
   	                var days = Math.floor(diff/(1000*60*60*24)); 
   	                if(days < 0){
   	                    message = "证书已超过有效期，请及时更换";
	                    $("#message").val(message);
   	                }else if(days>=0 && days<=30){
   	                    //message = "证书于"+zsyxq+"到期，请及时更换证书!";
	                    $("#zsyxq").val(zsyxq.substring(0,10));
   	                }
   	            }
   	        }
   	       
   	    }
     }else{
	     message = "用户不存在或已被注销";
	     $("#message").val(message);
     }
}
// 转换成日期格式
function formatDate(strDate){ 
	var riqi = strDate.split("-");
	return new Date(riqi[0],(riqi[1]-1),riqi[2]);
}
</script>
</head>
<body style="padding-top:90px" bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" scroll="no" >
<div style ="display :none ">
    <object ID="CACertification" CLASSID="CLSID:27D77CF2-727A-4CDE-A019-B992E6488A22" CODEBASE="<%=request.getContextPath() %>/active/aisinoCA.CAB#version=<%=version_aisinoCA %>"></object>
</div>
<input name="p_ukeyid" id="p_ukeyid" type="hidden"/>
<input name="message" id="message" type="hidden"/>
<input name="zsyxq" id="zsyxq" type="hidden"/>
</body>
</html>