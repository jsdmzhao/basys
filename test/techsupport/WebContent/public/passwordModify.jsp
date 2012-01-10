<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="com.aisino2.sysadmin.domain.User"%>
<%@ page import="com.aisino2.sysadmin.Constants;"%>
<%
	//登录用户ID，用于获得菜单
	String useraccount = "";
	String username = "";
	User user = new User();
	//获得登录用户session
	user = (User)session.getAttribute(Constants.userKey);
	if(user == null)
		response.sendRedirect("login.jsp");
	else
	{
		useraccount = user.getUseraccount();
		username = user.getUsername();
	}
 %>
<script type="text/javascript">
	$(document).ready(function() {
		//$("#o_username").val("<%=username %>");
      	//$("#o_useraccount").val("<%=useraccount %>");
	}); 
	
	//提交
	function setUpdatePassword(){ 
   	 		if (!checkControlValue("o_password","String",1,100,null,1,"原口令"))
				return false;
			if (!checkControlValue("o_passwordNew","String",1,100,null,1,"新口令"))
				return false;
			if (!checkControlValue("o_passwordNew2","String",1,100,null,1,"重复新口令"))
				return false;
			if($("#o_passwordNew").val() != $("#o_passwordNew2").val())
			{
				jAlert('新口令必须与重复新口令一致', '验证信息');
				$("#o_password").val("");
      			$("#o_passwordNew").val("");
      			$("#o_passwordNew2").val("");
      			$("#a_password").val("");
      			$("#a_passwordNew").val("");
      			$("#a_passwordNew2").val("");
				return false;
			}
			
			$("#a_username").val($("#o_username").val());
			$("#a_useraccount").val($("#o_useraccount").val());
			$("#a_password").val(hex_md5($("#o_password").val()));
			$("#a_passwordNew").val(hex_md5($("#o_passwordNew").val()));
			$("#a_passwordNew2").val(hex_md5($("#o_passwordNew2").val()));
          setParams("a_");
          var sUrl="sysadmin/updatePassword_user.action";
          jQuery.post(sUrl,params,updatePassword,"json");
          /*jQuery.ajax({
			type: 'POST',
			url: sUrl,
			data: params,
			async: false,
			dataType: 'json',
			success: update_page
		  });*/
	}

	function updatePassword (json) { //回传函数实体，参数为XMLhttpRequest.responseText
      if (json.result=="success"){
      	jAlert('修改成功! 系统重新登录后生效', '验证信息');
		 $("#closeDiv").click();
      }else{
      	jAlert(json.result, '验证信息');
      	$("#o_password").val("");
      	$("#o_passwordNew").val("");
      	$("#o_passwordNew2").val("");
      	$("#a_password").val("");
      	$("#a_passwordNew").val("");
      	$("#a_passwordNew2").val("");
      }
      
}

	function modifyVerify(){
		if (!checkControlValue("o_password","String",1,100,null,1,"原口令"))
			return false;
		if (!checkControlValue("o_passwordNew","String",1,100,null,1,"新口令"))
			return false;
		if (!checkControlValue("o_passwordNew2","String",1,100,null,1,"重复新口令"))
			return false;
		return true;
	}
	
	function fnclose()
	{
		$("#password_modify").hide("show");
		$("#password_modify").empty();
		
	}
</script>

<div align="right">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td align="left" class="title1">修改密码</td>
      <td align="right" class="title1"><a href="#" id="closeDiv" onclick='fnclose();' class="close"></td>
    </tr>
</table>
<table width="100%" id="modify">
<tr height="12"></tr>
	<tr>
		<td class="distd" width="33%">用户名</td>
		<td class="detailtd" width="67%"><input type="text" class="readonly" value="<%=username %>" /><input type="hidden" id="o_username" value="<%=username %>" /><input type="hidden" id="a_username" /></td>
	</tr>
	<tr>
	  <td class="distd">帐号</td>
	  <td class="detailtd"><input type="text" class="readonly" value="<%=useraccount %>" /><input type="hidden" id="o_useraccount" value="<%=useraccount %>" /><input type="hidden" id="a_useraccount" /></td>
  </tr>
	<tr>
	  <td class="red">原口令</td>
	  <td class="detailtd"><input type="password" id="o_password" class="inputstyle" /><input type="hidden" id="a_password"/></td>
  </tr>
	<tr>
	  <td class="red">新口令</td>
	  <td class="detailtd"><input type="password" id="o_passwordNew" class="inputstyle" /><input type="hidden" id="a_passwordNew"/></td>
  </tr>
	<tr>
	  <td class="red">重复新口令</td>
	  <td class="detailtd"><input type="password" id="o_passwordNew2" class="inputstyle" /><input type="hidden" id="a_passwordNew2"/></td>
  </tr>
	<tr height="25" align="center">
		<td colspan="4">
		<a href="#" id="moveButtonPassword" hidefocus="true" class="submitbutton" title="保存" onclick='setUpdatePassword();'>保存</a></td>
	</tr><tr height="6"></tr>
</table>

