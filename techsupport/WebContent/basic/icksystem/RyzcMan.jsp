<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.aisino2.sysadmin.domain.User"%>
<%@page import="com.aisino2.sysadmin.Constants"%>
<%@page import="com.aisino2.sysadmin.domain.Globalpar" %>
<%@page import="com.aisino2.cache.CacheManager" %>
	
	<%
	String userbm = "";
	User user= (User)session.getAttribute(Constants.userKey);
	if(user!=null&&user.getSsdwbm()!=null&&!"".equals(user.getSsdwbm())){
		userbm = user.getSsdwbm();
	}
%>
<html>
<head>
<script type="text/javascript">

   var fivefalg="yes";
    var ryzcfalg="yes";
  var qybm="<%=userbm %>";

	$(document).ready(function(){
	  bc_bottonMoveRight(1);
		$("#ickknxx").empty();
		$("#ickknxx").load("public/skOne.jsp");
		$("#ickknxx").show("slow");
	});
	
	var zhuceUrl="icksystem/ryzc_qyryskjl.action";
	function setRyzc(){
		 $("#p_qybm").attr("value",qybm);
		 $("#p_cyrybh").attr("value",fivecyrybh);
		 if(fivecyrybh!=''){
			  fivecyrybh="";
			 setParams("p_");
			jQuery.post(zhuceUrl,params,addback,"json");
		}
		
	}


	function addback(json){
		if  (json.result=="success"){
		   $('#ickknxx').find('span').each(function(){
		   		$(this).empty();
		   });
		   // jAlert("注册完成",'提示信息');
		}else{
			jAlert(json.result,'错误信息');
		}		
	}	
	

</script>
</head>
<body>
<input type="hidden" id="p_cyrybh">
<input type="hidden" id="p_qybm">
<table width="100%"  cellpadding="0" cellspacing="0"  class="tableborder">
		<tr>
        	<td class="queryfont">从业人员信息</td>
		</tr>
		<tr>
			<td class="tdbg">
				<div id="ickknxx"></div>
			</td>
		</tr>
		 <tr  align="right">
		<td colspan="4">
		<a href="#" id="addbutton" class="submitbutton" onclick='setRyzc();' title="保存">注册</a>
		</td></tr>
    </table>

</body>
</html>